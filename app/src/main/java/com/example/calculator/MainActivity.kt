package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

//clovis
//yooooooouuuuuuuuuuu
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private val operationList : MutableList<String> by lazy { mutableListOf<String>()}

    private val numberList : MutableList<String> by lazy { mutableListOf<String>()}

    private val operation : OperationsClass  by lazy { OperationsClassImplementation()}

    private var currentNumber : String = ""
    private var currentValue : String = ""
    private var currentChangeNumber : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setClicks()
        setContentView(binding.root)
    }

    fun setClicks() {

                binding.oneId.setOnClickListener {
                    currentNumber = "1"
                    setToScreen()
                }
                binding.twoId.setOnClickListener {
                    currentNumber = "2"
                    setToScreen()
                }
                binding.threeId.setOnClickListener {
                    currentNumber = "3"
                    setToScreen()
                }
                binding.fourId.setOnClickListener {
                    currentNumber = "4"
                    setToScreen()
                }
                binding.fiveId.setOnClickListener {
                    currentNumber = "5"
                    setToScreen()
                }
                binding.sixId.setOnClickListener {
                    currentNumber = "6"
                    setToScreen()
                }
                binding.sevenId.setOnClickListener {
                    currentNumber = "7"
                    setToScreen()
                }
                binding.eightId.setOnClickListener  {
                    currentNumber = "8"
                    setToScreen()
                }
                binding.nineId.setOnClickListener {
                    currentNumber = "9"
                    setToScreen()
                }

                binding.zeroId.setOnClickListener {
                    currentNumber = "0"
                    setToScreen()
                }
                binding.plusId.setOnClickListener {
                    adjustOperation("+")

                }
                binding.minusId.setOnClickListener {
                    adjustOperation("-")
                }
                binding.timesId.setOnClickListener {
                    adjustOperation("*")
                }
                binding.divideId.setOnClickListener {
                    adjustOperation(":")
                }
                binding.enterId.setOnClickListener {
                    binding.displayTextId.text = ""
                    var index = 0
                    if(currentValue.isNotEmpty()) numberList.add(currentValue)

                    numberList.forEach {
                        if(index == 0) {
                            (operation as OperationsClassImplementation)
                                .getNumberAndOperation(it.toDouble(),"#" )
                        }
                        else if(index < numberList.size) {
                            (operation as OperationsClassImplementation)
                                .getNumberAndOperation(it.toDouble(), operationList[index-1])
                        }
                        index++
                    }

                    operation.display(operation.result.toDouble().toInt().toString(), binding.displayTextId)
                    numberList.clear()
                    operationList.clear()
                    operation.result = ""
                    currentChangeNumber = ""

                }

                binding.clearId.setOnClickListener {
                    binding.displayTextId.text = ""
                    currentChangeNumber = ""
                    numberList.clear()
                    operationList.clear()
                }

    }

    @SuppressLint("SetTextI18n")
    private fun setToScreen(sign:String = "") {
        currentValue += currentNumber
        if (sign.isEmpty() && currentChangeNumber.isEmpty()) {
            currentChangeNumber = currentNumber
            binding.displayTextId.text = ""
            binding.displayTextId.text = "$currentNumber".trim()
        }
        else {
            binding.displayTextId.text = ""
            binding.displayTextId.text = currentChangeNumber + "$currentNumber"
            currentChangeNumber =  binding.displayTextId.text.toString()
        }
    }

    fun setSign(op: String) {
        currentChangeNumber = binding.displayTextId.text.toString() + " $op "
        binding.displayTextId.text = binding.displayTextId.text.toString() + " $op "
    }

    private fun adjustOperation(op: String) {

        if (currentChangeNumber.isASign() && currentChangeNumber.length > 1) {
            currentChangeNumber = currentChangeNumber.substring(0, currentChangeNumber.lastIndex-1)
            setSign(op)
            operationList.removeAt(operationList.lastIndex)
            operationList.add(op)
            numberList.add(currentValue)

        } else if (currentChangeNumber.isNotEmpty() && currentChangeNumber.length > 1) {
            operationList.add(op)
            setSign(op)
            numberList.add(currentValue)
        }else if (currentChangeNumber.length == 1 ) {
            numberList.add(currentValue)
            operationList.add(op)
            setSign(op)

        } else {
            binding.displayTextId.text = ""
        }
        currentValue = ""
    }

    private fun String.isASign() : Boolean {
        return when {
            this.endsWith("+") -> true
            this.endsWith("-") -> true
            this.endsWith(":") -> true
            else -> this.endsWith("*")
        }
    }
}