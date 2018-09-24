package gencana.com.android.wunderpool.presentation.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import gencana.com.android.wunderpool.presentation.factory.ViewModelFactory
import gencana.com.android.wunderpool.presentation.ui.view.main.MainViewModel
import gencana.com.android.wunderpool.presentation.ui.view.map.MapViewModel

/**
 * Created by Gen Cana on 22/09/2018
 */

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    fun bindMapViewModel(viewModel: MapViewModel): ViewModel
}