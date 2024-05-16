package com.example.splashandbutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splashandbutton.adapter.FruitsAdapter
import com.example.splashscreen.R
import com.example.splashscreen.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var homeBinding: FragmentHomeBinding
    var titleList = ArrayList<String>()
    var imageList = ArrayList<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater,container,false)
        titleList.add("Apple")
        imageList.add(R.drawable.fb)
        titleList.add("Apple 3")
        imageList.add(R.drawable.swyambu)

        var adapter = FruitsAdapter(imageList)

        homeBinding.recyclerview.layoutManager = LinearLayoutManager(context)
        homeBinding.recyclerview.adapter = adapter


        return homeBinding.root
    }




}