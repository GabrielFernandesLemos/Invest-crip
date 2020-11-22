package investcrip.com.invest_crip.features.crypto.di

import investcrip.com.invest_crip.features.crypto.presentation.CryptoListViewModel
import investcrip.com.invest_crip.features.crypto.source.remote.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val cryptoModule = module {

    single<Api> {
        val builder = OkHttpClient.Builder()
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS)


        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        builder.addInterceptor(logging)

        Retrofit.Builder()
                .baseUrl("https://api.coingecko.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build()
                .create(Api::class.java)
    }

    factory<CryptoRemoteDataSource> { CryptoRemoteDataSourceImpl(api = get()) }
    factory<CryptoRepository> { CryptoRepositoryImpl(dataSource = get()) }

    viewModel { CryptoListViewModel(repository = get()) }
}