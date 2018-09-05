package net.kikipryd.mymvvmkotlin

import android.app.Application
import android.content.Context

import net.kikipryd.mymvvmkotlin.dagger.component.ActivityComponent
import net.kikipryd.mymvvmkotlin.dagger.component.DaggerActivityComponent
import net.kikipryd.mymvvmkotlin.dagger.component.DaggerViewModelComponent
import net.kikipryd.mymvvmkotlin.dagger.component.ViewModelComponent
import net.kikipryd.mymvvmkotlin.dagger.module.NetworkModule

class App : Application() {

    companion object {
        lateinit var context: Context
        lateinit var networkModule: NetworkModule
        lateinit var activityComponent: ActivityComponent
        lateinit var viewModelComponent: ViewModelComponent
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        networkModule = NetworkModule()
        activityComponent = DaggerActivityComponent.builder()
//                .networkModule(networkModule)
                .build()
        viewModelComponent = DaggerViewModelComponent.builder()
                .networkModule(networkModule)
                .build()
    }
}
