package com.example.calculator

import android.util.Log
import android.widget.TextView
import java.lang.Exception

class OperationsClassImplementation : OperationsClass() {

    private var currentNumber: Double = 0.0

    override fun display(result: String, textView: TextView) {
        textView.text = result
    }

    override fun addition(firstNumber: Double, second: Double) {
        result = (firstNumber + second).toString()
    }

    override fun xTimes(firstNumber: Double, second: Double) {
        result = (firstNumber * second).toString()
    }

    override fun sMinus(firstNumber: Double, second: Double) {
        result = (firstNumber - second).toString()
    }

    override fun divide(firstNumber: Double, second: Double) {

         if(second.toInt() != 0) {
             result = (firstNumber / second).toString()
         } else {
            Log.e("operation", "You can not divide a number by zero")
         }

    }

    fun getNumberAndOperation(number: Double, op:String) {

        when {
            op.equals("+", true) -> {
                addition(currentNumber, number)
            }
            op.equals("-", true) -> {
                sMinus(currentNumber, number)
            }
            op.equals("*", true) -> {
                xTimes(currentNumber, number)
            }
            op.equals(":", true) -> {
                divide(currentNumber, number)
            } else -> {
                currentNumber = number
            }
        }
    }
}

class Mano : OperationsClass() {

    override fun display(result: String, textView: TextView) {
        TODO("Not yet implemented")
    }

    override fun addition(firstNumber: Double, second: Double) {
        TODO("Not yet implemented")
    }

    override fun xTimes(firstNumber: Double, second: Double) {
        TODO("Not yet implemented")
    }

    override fun sMinus(firstNumber: Double, second: Double) {
        TODO("Not yet implemented")
    }

    override fun divide(firstNumber: Double, second: Double) {
        TODO("Not yet implemented")
    }

}
