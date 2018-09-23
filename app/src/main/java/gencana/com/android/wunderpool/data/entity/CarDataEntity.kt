package gencana.com.android.wunderpool.data.entity


/**
 * Created by Gen Cana on 22/09/2018
 */

data class CarDataEntity(
        var id: Int?,
        var address: String?,
        var coordinates: Array<Double>?,
        var engineType: String?,
        var exterior: String?,
        var fuel: Int?,
        var interior: String?,
        var name: String?,
        var vin: String?
)