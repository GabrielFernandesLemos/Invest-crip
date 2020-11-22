package investcrip.com.invest_crip

import android.app.Application
import investcrip.com.invest_crip.features.crypto.di.cryptoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(cryptoModule))
        }
    }
}