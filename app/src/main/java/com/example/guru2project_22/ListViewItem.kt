package com.example.guru2project_22

import android.graphics.drawable.Drawable


class ListViewItem {
    private var iconimg: Drawable? = null
    private var textview3: String? = null

    fun setIcon(icon: Drawable?) {
        this.iconimg = icon
    }

    fun setText(text: String?) {
        this.textview3 = text
    }

    fun getIcon(): Drawable? {
        return iconimg
    }

    fun getText(): String? {
        return textview3
    }
}