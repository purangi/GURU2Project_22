package com.example.guru2project_22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class CatFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cat, container, false)

        val imageView1 : ImageView = view.findViewById(R.id.imageView1)
        val imageView2 : ImageView = view.findViewById(R.id.imageView2)
        val imageView3 : ImageView = view.findViewById(R.id.imageView3)
        val imageView4 : ImageView = view.findViewById(R.id.imageView4)
        val imageView5 : ImageView = view.findViewById(R.id.imageView5)

        val pref = this.activity?.getSharedPreferences("user", 0)


        when(pref?.getString("item1","").toString()){
            "1"-> imageView1.setImageResource(R.drawable.catfood)
            "3"-> imageView1.setImageResource(R.drawable.bigplant)
            "5"-> imageView1.setImageResource(R.drawable.catplaying)
        }

        when(pref?.getString("item2","").toString()){
            "2"->imageView2.setImageResource(R.drawable.smallplant)
            "4"->imageView2.setImageResource(R.drawable.catbathroom)
        }

        when(pref?.getString("item3","").toString()){
            "9"-> imageView3.setImageResource(R.drawable.cattable)
            "11"->  imageView3.setImageResource(R.drawable.catcircle)
            "14"-> imageView3.setImageResource(R.drawable.catbed)
            "15"-> imageView3.setImageResource(R.drawable.cattv)
        }

        if (pref?.getString("item4","").toString()=="7") imageView4.setImageResource(R.drawable.window)

        when(pref?.getString("item5","").toString()){
            "6"-> imageView5.setImageResource(R.drawable.light)
            "8"-> imageView5.setImageResource(R.drawable.cathome)
            "10"-> imageView5.setImageResource(R.drawable.bookshelf)
            "12"-> imageView5.setImageResource(R.drawable.cattower)
            "13"-> imageView5.setImageResource(R.drawable.catsofa)
        }

        return view
    }
}