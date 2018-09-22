package gencana.com.android.wunderpool.presentation.ui.view.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import gencana.com.android.wunderpool.R
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import dagger.android.AndroidInjection
import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.BaseRecyclerMultiAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    private lateinit var recyclerViewAdapter: BaseRecyclerMultiAdapter<CarEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewAdapter = BaseRecyclerMultiAdapter(null)
        recycler_view.adapter = recyclerViewAdapter
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        //test data
        for (i in 0.. 500){
            val list = ArrayList<CarEntity>()
            list.add(CarEntity("a $i", arrayOf(1.0, 2.5, 3.7), "b", "c", 5, "e", "f", "g", null))
            mainViewModel.addCarList(list)
        }

        mainViewModel.getCarList().observe(this, Observer<PagedList<CarEntity>> {
            recyclerViewAdapter.submitList(it)
        })

        setupLiveData()
    }

    private fun setupLiveData() {
        mainViewModel.loadingLiveData.observe(this, Observer{
            toast("loading live $it")
        })

        mainViewModel.responseLiveData.observe(this, Observer{
            toast("responseLiveData live ${it.value?.size}")
        })

        mainViewModel.errorLiveData.observe(this, Observer {
            toast("error live $it")
        })
    }

    private fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
