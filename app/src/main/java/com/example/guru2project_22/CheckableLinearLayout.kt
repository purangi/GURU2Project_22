package com.example.guru2project_22

import android.R
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.content.Context
import android.util.AttributeSet
import android.widget.Checkable

class CheckableLinearLayout(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs),
    Checkable {
    private val mIsChecked = false
    override fun isChecked(): Boolean {
        val checkbox = findViewById(R.id.checkbox) as CheckBox
        return checkbox.isChecked
        return mIsChecked
    }

    override fun toggle() {
        val cb = findViewById<View>(R.id.checkbox) as CheckBox
        isChecked = if (cb.isChecked) false else true
        isChecked = if (mIsChecked) false else true
    }

    override fun setChecked(checked: Boolean) {
        val cb = findViewById<View>(R.id.checkbox) as CheckBox
        if (cb.isChecked != checked) {
            cb.isChecked = checked
        }

        // CheckBox 가 아닌 View의 상태 변경.
    }
}
