package com.example.task5_note

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter

class BindingsAdapter {
    companion object {

        @BindingAdapter("app:text")
        @JvmStatic
        fun setText(view: EditText, text: String) {
            view.setText("$text by adapter")
        }
    }
}