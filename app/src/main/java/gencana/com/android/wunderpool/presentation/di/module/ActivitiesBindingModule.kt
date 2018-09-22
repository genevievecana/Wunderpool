package gencana.com.android.wunderpool.presentation.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gencana.com.android.wunderpool.presentation.ui.view.main.MainActivity

/**
 * Created by Gen Cana on 22/09/2018
 */

@Module
interface ActivitiesBindingModule {

    @ContributesAndroidInjector(modules = [])
    fun mainActivity(): MainActivity

}