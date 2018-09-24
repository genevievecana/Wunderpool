package gencana.com.android.wunderpool.data.repository.car

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.DataSource
import gencana.com.android.wunderpool.data.entity.mapper.toDataEntity
import gencana.com.android.wunderpool.data.entity.mapper.toDomainEntity
import gencana.com.android.wunderpool.data.repository.car.source.CarDataStore
import gencana.com.android.wunderpool.data.repository.car.source.CarDataStoreFactory
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.domain.repository.CarRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gen Cana on 22/09/2018
 */

@Singleton
class CarDataRepository @Inject constructor(
        carDataStoreFactory: CarDataStoreFactory)
    : CarRepository{

    private var carDataStore: CarDataStore = carDataStoreFactory.create()

    override fun insert(items: List<Car>) {
        carDataStore.insert(items.map {
            it.toDataEntity()
        })
    }

    override fun getCarList(): DataSource.Factory<Int, Car> {
        return carDataStore.getCarList().map{
            it.toDomainEntity()
        }
    }

    override fun getAllCarList(): LiveData<List<Car>> {
        return Transformations.map(carDataStore.getAllCarList()){list -> list.map {
            it.toDomainEntity()
        }}
    }

}