package com.example.decodeit

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.daily_code.*

class DailyCode: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        var inside_keyboard = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_code)
        setDaily()

        daily_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (inside_keyboard) {
                    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                    submit()

                } else {
                    inside_keyboard = true
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        daily_input.setOnClickListener(){
            inside_keyboard = false
            daily_input.text.clear()


        }
    }

    private fun setDaily(){
        val queue = Volley.newRequestQueue(this);
        val url = "https://decode-it-server.spicedspices.repl.co/daily/get"

        val strReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                daily_code_code.text = response
            },
            Response.ErrorListener { println("there was an error lol this was ethan's fault") }
        )

        queue.add(strReq)
    }

    private fun submit(){
        val queue = Volley.newRequestQueue(this);
        val userText = daily_input.text
        val url = "https://decode-it-server.spicedspices.repl.co/daily/answer/$userText"

        val strReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                daily_correct.text = response
            },
            Response.ErrorListener { println("there was an error lol this was ethan's fault") }
        )

        queue.add(strReq)
    }
}
