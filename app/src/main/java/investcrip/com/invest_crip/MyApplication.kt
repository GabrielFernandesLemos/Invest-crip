package investcrip.com.invest_crip

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import investcrip.com.invest_crip.features.crypto.di.cryptoModule
import investcrip.com.invest_crip.features.register.di.registerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(cryptoModule, registerModule))
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}