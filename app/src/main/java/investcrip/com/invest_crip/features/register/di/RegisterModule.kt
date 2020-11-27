package investcrip.com.invest_crip.features.register.di

import investcrip.com.invest_crip.features.register.source.local.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val registerModule = module {
    factory<CustomerDAO> { CustomerDAOImpl(androidContext()) }
    factory<CustomerLocalDataSource> { CustomerLocalDataSourceImpl(get()) }
    factory<CustomerRepository> { CustomerRepositoryImpl(get()) }
}
