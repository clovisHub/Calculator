package com.example.calculator

abstract class Container {

    protected var items : MutableList<Items> = mutableListOf()

    protected abstract var numberOfItems: Int

    protected abstract var containerPrice: Int

    protected abstract var containerName: String
}

data class Items( val name: String,
                  val price: Double,
                  val sellPrice: Double,
                  val lost : Boolean = false,
                  val size : Int = 0)