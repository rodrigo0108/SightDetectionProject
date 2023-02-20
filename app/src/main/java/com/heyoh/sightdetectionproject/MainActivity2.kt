package com.heyoh.sightdetectionproject

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private var currentFirstVisibleItemPosition1 = 0
    private var currentLastVisibleItemPosition1 = 0
    private var firstTime1 = true
    private var layoutManager: LinearLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val cardAdapter = CardAdapter()
        layoutManager = LinearLayoutManager(this)
        val cardRecyclerView: RecyclerView = this@MainActivity2.findViewById(R.id.cardRecyclerView)
        val nestedScrollView: NestedScrollView = this@MainActivity2.findViewById(R.id.nestedScrollView)


        cardRecyclerView.adapter = cardAdapter
        cardRecyclerView.layoutManager = layoutManager

        cardAdapter.cards = listOf(
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", ""),
            Card("", "")
        )

//        cardRecyclerView.onItemsVisible(object :OnItemVisible{
//            override var currentFirstVisibleItemPosition = currentFirstVisibleItemPosition1
//            override var currentLastVisibleItemPosition = currentLastVisibleItemPosition1
//            override var firstTime = firstTime1
//            override var layoutManagerType = layoutManager!!
//            override fun itemsOnScreen(firstItemPosition: Int, lastItemPosition: Int) {
//                Log.d("SCROLL", firstItemPosition.toString())
//                Log.d("SCROLL", lastItemPosition.toString())
//            }
//
//        })
        val scrollBounds = Rect()
        nestedScrollView.getHitRect(scrollBounds)
        nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (v.getChildAt(v.childCount - 1) != null) {
                if (scrollY > oldScrollY) {
                    if (scrollY >= (v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight)) {
                        Log.d("SCROLLY", scrollY.toString())
                        Log.d("SCROLL", (v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight).toString())
                    }
                }
            }
        })
    }
}