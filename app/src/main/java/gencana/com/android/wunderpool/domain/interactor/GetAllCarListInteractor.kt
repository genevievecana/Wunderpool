package gencana.com.android.wunderpool.domain.interactor

import android.arch.lifecycle.LiveData
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.domain.repository.CarRepository
import javax.inject.Inject

/**
 * Created by Gen Cana on 22/09/2018
 */
class GetAllCarListInteractor @Inject constructor(
        private val repository: CarRepository) {

    fun getCarList(): LiveData<List<Car>>{
        return repository.getAllCarList()
    }
}