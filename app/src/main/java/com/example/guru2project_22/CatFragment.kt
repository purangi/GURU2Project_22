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

        var pref = this.activity?.getSharedPreferences("user", 0)
        val num = pref?.getString("item","").toString()


        when(num){
            "1" -> imageView1.setImageResource(R.drawable.catfood)
            "2" -> imageView2.setImageResource(R.drawable.smallplant)
            "3" -> imageView1.setImageResource(R.drawable.bigplant)
            "4" -> imageView2.setImageResource(R.drawable.catbathroom)
            "5" -> imageView1.setImageResource(R.drawable.catplaying)
            "6" -> imageView2.setImageResource(R.drawable.light)
            "7" -> imageView4.setImageResource(R.drawable.window)
            "8" -> imageView5.setImageResource(R.drawable.cathome)
            "9" -> imageView3.setImageResource(R.drawable.cattable)
            "10" -> imageView5.setImageResource(R.drawable.bookshelf)
            "11" -> imageView3.setImageResource(R.drawable.catcircle)
            "12" -> imageView5.setImageResource(R.drawable.cattower)
            "13" -> imageView5.setImageResource(R.drawable.catsofa)
            "14" -> imageView3.setImageResource(R.drawable.catbed)
            "15" -> imageView3.setImageResource(R.drawable.cattv)
        }


        return view
    }
}