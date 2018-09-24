package gencana.com.android.wunderpool.presentation.base

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject
import java.lang.reflect.ParameterizedType

/**
 * Created by Gen Cana on 23/09/2018
 */
abstract class BaseActivity<VM: BaseViewModel<T>, T>: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>)
        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.responseLiveData.observe(this,
                Observer {
                    onResponseSuccess(it!!)
                })

        viewModel.getErrorLiveData().observe(this,
                Observer {
                    onError(it)
                })

        viewModel.getLoadingMediatorLiveData().observe(this,
                Observer {
                    showLoading(it==true)
                })
    }

    abstract fun showLoading(show: Boolean)

    abstract fun onResponseSuccess(data: T)

    abstract fun onError(errorMsg: String?)


}