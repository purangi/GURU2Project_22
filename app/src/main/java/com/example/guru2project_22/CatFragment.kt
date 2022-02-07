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
        val num1 = pref?.getString("item1","").toString()
        if(num1=="1") imageView1.setImageResource(R.drawable.catfood)
        val num2 = pref?.getString("item2","").toString()
        if (num2=="2") imageView2.setImageResource(R.drawable.smallplant)
        //val num3= pref?.getString("item3","").toString()
        //if (num3=="3") imageView1.setImageResource(R.drawable.bigplant)
        //val num4 = pref?.getString("item4","").toString()
        //if (num4=="4") imageView2.setImageResource(R.drawable.catbathroom)
        //val num5 = pref?.getString("item5","").toString()
        //if (num5=="5") imageView1.setImageResource(R.drawable.catplaying)
        val num6 = pref?.getString("item6","").toString()
        if (num6=="6") imageView5.setImageResource(R.drawable.light)
        val num7 = pref?.getString("item7","").toString()
        if (num7=="7") imageView4.setImageResource(R.drawable.window)
        //val num8 = pref?.getString("item8","").toString()
        //if (num8=="8")  imageView5.setImageResource(R.drawable.cathome)
        //val num9 = pref?.getString("item9","").toString()
        //if (num9=="9") imageView3.setImageResource(R.drawable.cattable)
        //val num10 = pref?.getString("item10","").toString()
        //if (num10=="10") imageView5.setImageResource(R.drawable.bookshelf)
        val num11 = pref?.getString("item11","").toString()
        if (num11=="11")  imageView3.setImageResource(R.drawable.catcircle)
        //val num12 = pref?.getString("item12","").toString()
        //if (num12=="12") imageView5.setImageResource(R.drawable.cattower)
        //val num13 = pref?.getString("item13","").toString()
        //if (num13=="13") imageView5.setImageResource(R.drawable.catsofa)
        //val num14 = pref?.getString("item14","").toString()
        //if (num14=="14") imageView3.setImageResource(R.drawable.catbed)
        //val num15 = pref?.getString("item15","").toString()
        //if (num15=="15") imageView3.setImageResource(R.drawable.cattv)

        return view
    }
}