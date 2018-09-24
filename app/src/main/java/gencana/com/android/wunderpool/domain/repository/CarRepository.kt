package gencana.com.android.wunderpool.domain.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import gencana.com.android.wunderpool.domain.model.Car

/**
 * Created by Gen Cana on 22/09/2018
 */
interface CarRepository  {

    fun insert(items: List<Car>)

    fun getCarList() : DataSource.Factory<Int, Car>

    fun getAllCarList(): LiveData<List<Car>>

}