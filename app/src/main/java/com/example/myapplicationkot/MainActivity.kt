package com.example.myapplicationkot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
class MainActivity : AppCompatActivity() {
    lateinit var txtInput: TextView

    var lastNumeric: Boolean = false

    var stateError: Boolean = false

    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.txtInput)

    }
        fun onDecimalPoint(view: View) {
            if (lastNumeric && !stateError && !lastDot) {
                txtInput.append(".")
                lastNumeric = false
                lastDot = false


            }
        }

        fun onClear(view: View) {
            this.txtInput.text = ""
            lastNumeric = false
            stateError = false
            lastDot = false
        }


        fun onEqual(view: View){
            if (lastNumeric && !stateError){
                val txt = txtInput.text.toString()

                val expression = ExpressionBuilder(txt).build()

                try{
                    val result = expression.evaluate()
                    txtInput.text = result.toString()
                    lastDot = true

                }catch(ex: ArithmeticException){
                    txtInput.text = "Error"
                    stateError = true
                    lastNumeric = false
                }

            }
        }
}






