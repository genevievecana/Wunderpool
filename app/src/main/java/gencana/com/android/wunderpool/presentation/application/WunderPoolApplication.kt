package gencana.com.android.wunderpool.presentation.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import gencana.com.android.wunderpool.presentation.di.component.DaggerAppComponent


/**
 * Created by Gen Cana on 22/09/2018
 */
class WunderPoolApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .create(this)
                .build()
    }
}