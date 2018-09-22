package gencana.com.android.wunderpool.data.entity

import gencana.com.android.wunderpool.data.db.entity.CarEntity

/**
 * Created by Gen Cana on 22/09/2018
 */

data class CarDataEntity(
        var id: Int,
        var address: String?,
        var coordinates: Array<Double>?,
        var engineType: String?,
        var exterior: String?,
        var fuel: Int?,
        var interior: String?,
        var name: String?,
        var vin: String?
)

fun CarDataEntity.toEntity(): CarEntity =
        CarEntity(
                this.address,
                this.coordinates,
                this.engineType,
                this.exterior,
                this.fuel,
                this.interior,
                this.name,
                this.vin
        )