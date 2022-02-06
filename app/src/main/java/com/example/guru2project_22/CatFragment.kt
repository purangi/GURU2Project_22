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
            "1" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView1.setImageResource(R.drawable.catfood)
                }else{
                    imageView1.setImageResource(R.drawable.catfood)
                }
            }
            "2" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView2.setImageResource(R.drawable.smallplant)
                }else{
                    imageView2.setImageResource(R.drawable.smallplant)
                }
            }
            "3" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView1.setImageResource(R.drawable.bigplant)
                }else{
                    imageView1.setImageResource(R.drawable.bigplant)
                }
            }
            "4" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView2.setImageResource(R.drawable.catbathroom)
                }else{
                    imageView2.setImageResource(R.drawable.catbathroom)
                }
            }
            "5" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView1.setImageResource(R.drawable.catplaying)
                }else{
                    imageView1.setImageResource(R.drawable.catplaying)
                }
            }
            "6" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView2.setImageResource(R.drawable.light)
                }else{
                    imageView2.setImageResource(R.drawable.light)
                }
            }
            "7" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView4.setImageResource(R.drawable.window)
                }else{
                    imageView4.setImageResource(R.drawable.window)
                }
            }
            "8" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView5.setImageResource(R.drawable.cathome)
                }else{
                    imageView5.setImageResource(R.drawable.cathome)
                }
            }
            "9" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView3.setImageResource(R.drawable.cattable)
                }else{
                    imageView3.setImageResource(R.drawable.cattable)
                }
            }
            "10" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView5.setImageResource(R.drawable.bookshelf)
                }else{
                    imageView5.setImageResource(R.drawable.bookshelf)
                }
            }
            "11" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView3.setImageResource(R.drawable.catcircle)
                }else{
                    imageView3.setImageResource(R.drawable.catcircle)
                }
            }
            "12" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView5.setImageResource(R.drawable.cattower)
                }else{
                    imageView5.setImageResource(R.drawable.cattower)
                }
            }
            "13" ->{
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView5.setImageResource(R.drawable.catsofa)
                }else{
                    imageView5.setImageResource(R.drawable.catsofa)
                }
            }
            "14" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView3.setImageResource(R.drawable.catbed)
                }else{
                    imageView3.setImageResource(R.drawable.catbed)
                }
            }
            "15" -> {
                if(imageView1.visibility==View.INVISIBLE){
                    imageView1.visibility=View.VISIBLE
                    imageView3.setImageResource(R.drawable.cattv)
                }else{
                    imageView3.setImageResource(R.drawable.cattv)
                }
            }
        }

        return view
    }
}