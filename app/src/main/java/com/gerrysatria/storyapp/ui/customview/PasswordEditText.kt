package com.gerrysatria.storyapp.ui.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.gerrysatria.storyapp.R
import com.google.android.material.textfield.TextInputEditText

class PasswordEditText : TextInputEditText {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val inputText = s.toString()
                when {
                    inputText.isBlank() -> setError(context.getString(R.string.error_blank), null)
                    inputText.length < 8 -> setError(context.getString(R.string.error_password), null)
                }
            }

            override fun afterTextChanged(s: Editable) {
                val inputText = s.toString()
                when {
                    inputText.isBlank() -> setError(context.getString(R.string.error_blank), null)
                    inputText.length < 8 -> setError(context.getString(R.string.error_password), null)
                }
            }
        })
    }
}