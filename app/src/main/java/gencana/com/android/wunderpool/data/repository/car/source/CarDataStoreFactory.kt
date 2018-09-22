package gencana.com.android.wunderpool.data.repository.car.source

import gencana.com.android.wunderpool.data.db.dao.PlaceMarkDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gen Cana on 22/09/2018
 */

@Singleton
class CarDataStoreFactory @Inject constructor(private val placeMarkDao: PlaceMarkDao){

    fun create(): CarDataStore{
        val carDataStore: CarDataStore = RoomDataStore(placeMarkDao)
        return carDataStore
    }
}