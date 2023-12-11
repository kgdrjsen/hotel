package com.android.kkiosk

open class Munu(name :String, explain : String) {
    var idx : Int
    var name : String
    var explain : String

      init {
        this.idx = getNextIdx()
        this.name = name
        this.explain = explain
    }

    open fun displayInfo() {
        println("ID : $idx, 이름: $name, 설명 : [ $explain ]")
    }

    companion object {
        private var maxIdx = 1

        private fun getNextIdx(): Int {
            return maxIdx++
        }
    }
}