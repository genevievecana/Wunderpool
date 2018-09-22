package gencana.com.android.wunderpool.presentation.di.module

import dagger.Module
import dagger.Provides
import gencana.com.android.wunderpool.data.repository.car.CarDataRepository
import gencana.com.android.wunderpool.domain.repository.CarRepository
import javax.inject.Singleton

/**
 * Created by Gen Cana on 22/09/2018
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideCarRepository(carDataRepository: CarDataRepository): CarRepository {
        return carDataRepository
    }
}