package com.example.samplemvvemproject.utils.extension

import android.graphics.PorterDuff
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun EditText.onTextChanged(onTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {}
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            onTextChanged(p0.toString())
        }
    })
}

fun EditText.onFocusChanged(onFocusChanged: (Boolean) -> Unit){
    this.setOnFocusChangeListener { _, hasFocus ->
        onFocusChanged(hasFocus)
    }
}

fun EditText.onSend(callback: () -> Unit) {

    imeOptions = EditorInfo.IME_ACTION_SEND
    maxLines = 1
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEND) {
            callback.invoke()
            true
        }
        false
    }
}

fun EditText.onDone(callback: () -> Unit) {

    imeOptions = EditorInfo.IME_ACTION_DONE
    maxLines = 1
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            callback.invoke()
            true
        }
        false
    }
}

fun ImageView.imageDrawable(@DrawableRes id:Int){
    this.setImageDrawable(ContextCompat.getDrawable(this.context,id))
}

fun ImageView.colorFilter(@ColorRes id:Int) {
    setColorFilter(ContextCompat.getColor(context, id), PorterDuff.Mode.SRC_IN)
}

fun ImageView.removeColorFilter() {
    colorFilter = null
}
