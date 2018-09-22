package gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.viewholder

import android.view.View
import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.BaseRecyclerMultiAdapter
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_car.view.*

/**
 * Created by Gen Cana on 22/09/2018
 */
internal class CarItemViewHolder(itemView: View)
: BaseRecyclerMultiAdapter.BaseViewHolder<CarEntity>(itemView) {

    override fun onBind(data: CarEntity, itemClickPublisher: PublishSubject<CarEntity>?) {
        itemView.txt_name.text = data.address
    }

}