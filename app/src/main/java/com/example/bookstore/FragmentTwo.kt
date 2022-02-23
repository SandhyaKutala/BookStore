package com.example.bookstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentTwo : Fragment() {

    private var childrenList : MutableList<Int> = mutableListOf(
        R.drawable.children_one,
        R.drawable.children_two,
        R.drawable.children_three,
        R.drawable.children_four,
        R.drawable.children_five,
        R.drawable.children_six,
        R.drawable.children_seven,
        R.drawable.children_eight,
        R.drawable.children_nine, R.drawable.children_ten,
        R.drawable.children_one, R.drawable.children_two,
        R.drawable.children_three, R.drawable.children_four,
        R.drawable.children_five, R.drawable.children_six,
        R.drawable.children_seven, R.drawable.children_eight,
        R.drawable.children_nine, R.drawable.children_ten
    )

    private lateinit var recyclerView: RecyclerView
    private lateinit var childrenadapter: RecyclerViewAdapter
    private lateinit var gridLayoutManager: GridLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view  =  inflater.inflate(R.layout.fragment_two, container, false)


        recyclerView = view.findViewById(R.id.recycler_view)

        childrenadapter = RecyclerViewAdapter(childrenList)

        gridLayoutManager = GridLayoutManager(requireContext(),3)

        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = childrenadapter


        return view
    }

}