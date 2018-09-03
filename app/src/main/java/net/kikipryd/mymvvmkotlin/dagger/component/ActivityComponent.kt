package net.kikipryd.mymvvmkotlin.dagger.component

import dagger.Component
import net.kikipryd.mymvvmkotlin.dagger.module.NetworkModule
import net.kikipryd.mymvvmkotlin.feature.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}
