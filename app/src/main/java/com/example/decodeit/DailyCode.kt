package com.example.decodeit

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.daily_code.*

class DailyCode: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_code)

        getDaily()
    }

    private fun getDaily(){
        val queue = Volley.newRequestQueue(this);
        val url = "https://decode-it-server.spicedspices.repl.co/daily/get"

        val strReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                if(response.length <= 22) {
                    for (i in response.indices) {
                        val inputId = resources.getIdentifier("daily_input_$i", "id", packageName)
                        println(inputId)
                        val currInp: EditText = findViewById(inputId)
                        currInp.text =
                            Editable.Factory.getInstance().newEditable(response[i].toString())
                    }
                } else {
                    println("lol idk the length of the code was longer than number of chars")
                }
            },
            Response.ErrorListener { println("there was an error lol this was ethan's fault") }
        )

        queue.add(strReq)
    }

    private fun submit(){
        val queue = Volley.newRequestQueue(this);
        val userText = daily_input_0.text
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
