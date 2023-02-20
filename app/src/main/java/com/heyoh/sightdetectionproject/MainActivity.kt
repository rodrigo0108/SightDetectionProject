package com.heyoh.sightdetectionproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var currentFirstVisibleItemPosition1 = 0
    private var currentLastVisibleItemPosition1 = 0
    private var firstTime1 = true
    private var layoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardAdapter = CardAdapter()
        layoutManager = LinearLayoutManager(this)
        val cardRecyclerView: RecyclerView = this@MainActivity.findViewById(R.id.cardRecyclerView)

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


//        cardRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                if (firstTime) {
//                    currentFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
//                    currentLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
//                    Log.d("SCROLL1", currentFirstVisibleItemPosition.toString())
//                    Log.d("SCROLL1", currentLastVisibleItemPosition.toString())
//                    firstTime = false
//                }
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (currentFirstVisibleItemPosition != layoutManager.findFirstVisibleItemPosition() ||
//                    currentLastVisibleItemPosition != layoutManager.findLastVisibleItemPosition()
//                ) {
//
//                    currentFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
//                    currentLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
//
//                    Log.d("SCROLL", layoutManager.findFirstVisibleItemPosition().toString())
//                    Log.d("SCROLL", layoutManager.findLastVisibleItemPosition().toString())
//                }
//
//            }
//        })

        cardRecyclerView.onItemsVisible(object :OnItemVisible{
            override var currentFirstVisibleItemPosition = currentFirstVisibleItemPosition1
            override var currentLastVisibleItemPosition = currentLastVisibleItemPosition1
            override var firstTime = firstTime1
            override var layoutManagerType = layoutManager!!
            override fun itemsOnScreen(firstItemPosition: Int, lastItemPosition: Int) {
                Log.d("SCROLL", firstItemPosition.toString())
                Log.d("SCROLL", lastItemPosition.toString())
            }

        })

    }

}

class CardAdapter : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    var cards: List<Card> = listOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = "Tarjeta $position"
    }

    override fun getItemCount() = cards.size

}

class Card(val id: String, val name: String)