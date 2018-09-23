package gencana.com.android.wunderpool.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import dagger.android.AndroidInjection
import javax.inject.Inject
import gencana.com.android.wunderpool.R
import java.lang.reflect.ParameterizedType

/**
 * Created by Gen Cana on 23/09/2018
 */
abstract class BaseActivity<VM: BaseViewModel<T>, T>: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var mainViewModel: VM

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>)
        observeLiveData()

    }

    private fun observeLiveData() {
        mainViewModel.responseLiveData.observe(this,
                Observer {
                    onResponseSuccess(it)
                })

        mainViewModel.errorLiveData.observe(this,
                Observer {
                    onError(it)
                })

        mainViewModel.loadingLiveData.observe(this,
                Observer {
                    showLoading(it)
                })
    }

    abstract fun showLoading(show: Boolean)

    abstract fun onResponseSuccess(data: T)

    abstract fun onError(errorMsg: String)


}