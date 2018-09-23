package gencana.com.android.wunderpool.presentation.extensions

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

/**
 * Created by Gen Cana on 23/09/2018
 */

fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, duration).show()
}

fun Context.toast(@StringRes msgRes: Int, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msgRes, duration).show()
}