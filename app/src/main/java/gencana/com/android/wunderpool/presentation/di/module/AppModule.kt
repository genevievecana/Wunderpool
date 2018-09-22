package gencana.com.android.wunderpool.presentation.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import gencana.com.android.wunderpool.presentation.constant.key.SCHEDULER_IO
import gencana.com.android.wunderpool.presentation.constant.key.SCHEDULER_MAIN_THREAD
import gencana.com.android.wunderpool.presentation.di.viewmodel.ViewModelModule
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Gen Cana on 22/09/2018
 */

@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app : Application) : Context = app

    @Provides
    @Named(SCHEDULER_MAIN_THREAD)
    fun provideAndroidMainThreadScheduler() : Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(SCHEDULER_IO)
    fun provideIoScheduler() : Scheduler = Schedulers.io()
}