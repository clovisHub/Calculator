package com.example.calculator

import android.widget.TextView

abstract class OperationsClass {

    var result:String = ""

    abstract fun display(result:String, textView: TextView)

    abstract fun addition(firstNumber: Double, second: Double)

    abstract fun xTimes(firstNumber: Double, second: Double)

    abstract fun sMinus(firstNumber: Double, second: Double)

    abstract fun divide(firstNumber: Double, second: Double)

    fun clear() {
        result = ""
    }
}