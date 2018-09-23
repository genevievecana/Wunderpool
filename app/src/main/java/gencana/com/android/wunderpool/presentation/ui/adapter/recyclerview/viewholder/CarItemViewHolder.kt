package gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.viewholder

import android.view.View
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.constant.enums.CarStatus
import gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.BaseRecyclerMultiAdapter
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_car.view.*

/**
 * Created by Gen Cana on 22/09/2018
 */
internal class CarItemViewHolder(itemView: View)
: BaseRecyclerMultiAdapter.BaseViewHolder<Car>(itemView) {

    override fun onBind(data: Car, itemClickPublisher: PublishSubject<Car>?) {
        itemView.txt_vin.text = data.vin
        itemView.txt_address.text = data.address
        itemView.txt_engine.text = data.engineType
        itemView.cb_interior.isChecked = data.interior.equals(CarStatus.GOOD.name)
        itemView.cb_exterior.isChecked = data.exterior.equals(CarStatus.GOOD.name)
    }

}