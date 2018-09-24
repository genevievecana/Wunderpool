package gencana.com.android.wunderpool.domain.interactor

import android.arch.paging.DataSource
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.domain.repository.CarRepository
import javax.inject.Inject

/**
 * Created by Gen Cana on 22/09/2018
 */
class GetCarListInteractor @Inject constructor(
        private val repository: CarRepository) {

    fun getCarList(): DataSource.Factory<Int, Car>{
        return repository.getCarList()
    }
}