package gencana.com.android.wunderpool.data.db.entity.mapper

import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.data.db.entity.toDataEntity
import gencana.com.android.wunderpool.data.entity.CarDataEntity

/**
 * Created by Gen Cana on 22/09/2018
 */

fun toPlaceMarkDataEntity(list: List<CarEntity>)
        : List<CarDataEntity> {
    return list.flatMapTo(ArrayList()) {
        it -> listOf(it.toDataEntity())
    }

}

data class Customer(val name: String, val age: Int)
data class Address(val address: String, val state: String)