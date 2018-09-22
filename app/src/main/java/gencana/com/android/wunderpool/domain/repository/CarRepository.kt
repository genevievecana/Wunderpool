package gencana.com.android.wunderpool.domain.repository

import androidx.paging.DataSource
import gencana.com.android.wunderpool.data.db.entity.CarEntity

/**
 * Created by Gen Cana on 22/09/2018
 */
interface CarRepository  {

    fun insert(items: List<CarEntity>)

    fun getCarList() : DataSource.Factory<Int, CarEntity>

}