package gencana.com.android.wunderpool.presentation.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import gencana.com.android.wunderpool.presentation.application.WunderPoolApplication
import gencana.com.android.wunderpool.presentation.di.module.*
import javax.inject.Singleton

/**
 * Created by Gen Cana on 22/09/2018
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    RoomDbModule::class,
    RepositoryModule::class,
    ActivitiesBindingModule::class
])

interface AppComponent: AndroidInjector<WunderPoolApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}