package com.yjooooo.sampleconcatadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.yjooooo.sampleconcatadapter.adapter.BlueAdapter
import com.yjooooo.sampleconcatadapter.adapter.RedAdapter
import com.yjooooo.sampleconcatadapter.adapter.YellowAdapter
import com.yjooooo.sampleconcatadapter.base.BaseActivity
import com.yjooooo.sampleconcatadapter.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()
    private val redAdapter = RedAdapter()
    private val blueAdapter = BlueAdapter()
    private val yellowAdapter = YellowAdapter()
    private val colorRvAdapter = ConcatAdapter(redAdapter, blueAdapter, yellowAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.initRedList()
        mainViewModel.initBlueList()
        mainViewModel.initYellowList()
        initColorRvAdapter()
        initRedListObserver()
        initBlueListObserver()
        initYellowListObserver()
    }

    private fun initColorRvAdapter() {
        binding.rvMain.adapter = colorRvAdapter
    }

    private fun initRedListObserver() {
        mainViewModel.redList.observe(this) { redList ->
            redAdapter.submitList(redList)
        }
    }

    private fun initBlueListObserver() {
        mainViewModel.blueList.observe(this) { blueList ->
            blueAdapter.submitList(blueList)
        }
    }

    private fun initYellowListObserver() {
        mainViewModel.yellowList.observe(this) { yellowList ->
            yellowAdapter.submitList(yellowList)
        }
    }
}
