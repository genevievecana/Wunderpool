package gencana.com.android.wunderpool.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Gen Cana on 22/09/2018
 */

@Entity()
data class CarEntity(
        var address: String? = null,
        var coordinates: Array<Double>? = null,
        var engineType: String? = null,
        var exterior: String? = null,
        var fuel: Int? = null,
        var interior: String? = null,
        var name: String? = null,
        var vin: String? = null,
        @PrimaryKey(autoGenerate = true) var id: Int? = null)



