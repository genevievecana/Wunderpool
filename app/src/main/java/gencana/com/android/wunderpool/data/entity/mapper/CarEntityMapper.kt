package gencana.com.android.wunderpool.data.entity.mapper

import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.data.entity.CarDataEntity
import gencana.com.android.wunderpool.domain.model.Car

/**
 * Created by Gen Cana on 23/09/2018
 */

fun CarEntity.toDataEntity() =
        CarDataEntity(
            id,
            address,
            coordinates,
            engineType,
            exterior,
            fuel,
            interior,
            name,
            vin
        )

fun CarDataEntity.toDbEntity() =
        CarEntity(
                address,
                coordinates,
                engineType,
                exterior,
                fuel,
                interior,
                name,
                vin,
                id
        )

fun CarDataEntity.toDomainEntity() =
     Car(
        id,
        address,
        coordinates,
        engineType,
        exterior,
        fuel,
        interior,
        name,
        vin
    )

fun Car.toDbEntity() =
        CarEntity(
                address,
                coordinates,
                engineType,
                exterior,
                fuel,
                interior,
                name,
                vin,
                id
        )

fun Car.toDataEntity() =
        CarDataEntity(
                id,
                address,
                coordinates,
                engineType,
                exterior,
                fuel,
                interior,
                name,
                vin
        )