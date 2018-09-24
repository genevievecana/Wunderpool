package gencana.com.android.wunderpool.presentation.di.viewmodel

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Gen Cana on 22/09/2018
 */

@MapKey
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)