package gencana.com.android.wunderpool.data.db.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import gencana.com.android.wunderpool.data.entity.CarDataEntity
import gencana.com.android.wunderpool.presentation.interfaces.ViewHolderType
import gencana.com.android.wunderpool.presentation.constant.enums.ViewHolderTypeEnum

/**
 * Created by Gen Cana on 22/09/2018
 */

@Entity()
class CarEntity(
        var address: String? = null,
        var coordinates: Array<Double>? = null,
        var engineType: String? = null,
        var exterior: String? = null,
        var fuel: Int? = null,
        var interior: String? = null,
        var name: String? = null,
        var vin: String? = null,
        @PrimaryKey(autoGenerate = true) var id: Int? = null,
        @Ignore override var viewTypeEnum: ViewHolderTypeEnum = ViewHolderTypeEnum.ITEM_CAR
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

fun CarEntity.toDataEntity(): CarDataEntity =
        CarDataEntity(
                this.id!!,
                this.address,
                this.coordinates,
                this.engineType,
                this.exterior,
                this.fuel,
                this.interior,
                this.name,
                this.vin
        )

