package com.example.premiertp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.logging.Logger
import net.objecthunter.exp4j.ExpressionBuilder

class Calculatrice : AppCompatActivity() {
    val Log = Logger.getLogger(Calculatrice::class.java.name)
    lateinit var operations: TextView
    lateinit var res: TextView

    var lastNumeric: Boolean = false
    var stateError: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.operations = findViewById(R.id.textView)
        this.res = findViewById(R.id.textView2)
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !stateError && !lastDot) {
            operations.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
    fun onDigit(view: View) {
        if (stateError) {
            // If current state is Error, replace the error message
            operations.text = (view as Button).text
            stateError = false
        } else {
            // If not, already there is a valid expression so append to it
            operations.append((view as Button).text)
        }
        // Set the flag
        lastNumeric = true
    }

    fun onOperator(view: View) {
        if (lastNumeric && !stateError) {
            operations.append((view as Button).text)
            lastNumeric = false
            lastDot = false

        }
    }


    /**
     * Clear the TextView
     */
    fun onClear(view: View) {
        this.operations.text = ""
        this.res.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false

    }

    fun onEqual(view: View) {
        // If the current state is error, nothing to do.
        // If the last input is a number only, solution can be found.
        if (lastNumeric && !stateError) {
            // Read the expression
            val txt = operations.text.toString()
            // Create an Expression (A class from exp4j library)
            val expression = ExpressionBuilder(txt).build()
            try {
                // Calculate the result and display
                val result = expression.evaluate()
                res.text = result.toString()

            } catch (ex: ArithmeticException) {
                // Display an error message
                operations.text = "Error"
                stateError = true
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onDelete (view: View){
        this.operations.text = this.operations.text.dropLast(1)
    }


}
