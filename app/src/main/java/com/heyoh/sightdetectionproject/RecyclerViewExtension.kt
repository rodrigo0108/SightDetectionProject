package com.heyoh.sightdetectionproject

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.onItemsVisible(onItemVisible: OnItemVisible) {

    addOnScrollListener(object: RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            with(onItemVisible){
                if (firstTime) {
                    currentFirstVisibleItemPosition = layoutManagerType.findFirstVisibleItemPosition()
                    currentLastVisibleItemPosition = layoutManagerType.findLastVisibleItemPosition()
                    itemsOnScreen(currentFirstVisibleItemPosition,currentLastVisibleItemPosition)
                    firstTime = false
                }
            }
        }
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            with(onItemVisible){
                if (currentFirstVisibleItemPosition != layoutManagerType.findFirstVisibleItemPosition() ||
                    currentLastVisibleItemPosition != layoutManagerType.findLastVisibleItemPosition()
                ) {
                    currentFirstVisibleItemPosition = layoutManagerType.findFirstVisibleItemPosition()
                    currentLastVisibleItemPosition = layoutManagerType.findLastVisibleItemPosition()
                    itemsOnScreen(currentFirstVisibleItemPosition,currentLastVisibleItemPosition)
                }
            }
        }
    })
}

interface OnItemVisible{
    var currentFirstVisibleItemPosition: Int
    var currentLastVisibleItemPosition: Int
    var firstTime: Boolean
    var layoutManagerType : LinearLayoutManager
    fun itemsOnScreen(firstItemPosition: Int, lastItemPosition:Int)
}