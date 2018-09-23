package gencana.com.android.wunderpool.domain.model

import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.presentation.constant.enums.ViewHolderTypeEnum
import gencana.com.android.wunderpool.presentation.interfaces.ViewHolderType

/**
 * Created by Gen Cana on 23/09/2018
 */
data class Car(
        var id: Int?,
        var address: String?,
        var coordinates: Array<Double>?,
        var engineType: String?,
        var exterior: String?,
        var fuel: Int?,
        var interior: String?,
        var name: String?,
        var vin: String?,
        override var viewTypeEnum: ViewHolderTypeEnum = ViewHolderTypeEnum.ITEM_CAR
): ViewHolderType {

    override fun getDataId(): String {
        return id.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is CarEntity)
            return false

        return other.id == this.id &&
                other.address == this.address &&
                this.coordinates?.let { other.coordinates?.contentEquals(it) } ?: true &&
                other.engineType == this.engineType &&
                other.exterior == this.exterior &&
                other.fuel == this.fuel &&
                other.name == this.name &&
                other.vin == this.vin
    }
}