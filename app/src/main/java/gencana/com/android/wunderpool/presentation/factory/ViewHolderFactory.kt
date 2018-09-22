package gencana.com.android.wunderpool.presentation.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gencana.com.android.wunderpool.presentation.constant.enums.ViewHolderTypeEnum
import gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.viewholder.CarItemViewHolder

/**
 * Created by Gen Cana on 22/09/2018
 */
object ViewHolderFactory {

    fun createViewType(parent: ViewGroup, type: Int)
            : RecyclerView.ViewHolder{
        val viewTypeEnum: ViewHolderTypeEnum = getViewType(type)
                ?: throw NullPointerException("Invalid ViewHolder Type")

        val view: View = LayoutInflater.from(parent.context)
                .inflate(viewTypeEnum.layout, parent, false)
        return when(viewTypeEnum){
            ViewHolderTypeEnum.ITEM_CAR -> CarItemViewHolder(view)
        }
    }

    private fun getViewType(type: Int): ViewHolderTypeEnum?{
        ViewHolderTypeEnum.values().forEach {
            if (it.type == type){
                return it
            }
        }

        return null
    }

}