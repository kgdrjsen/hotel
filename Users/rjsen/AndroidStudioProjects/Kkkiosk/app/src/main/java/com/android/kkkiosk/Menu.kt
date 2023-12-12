package com.android.kkkiosk

open class Menu(idx : Int,name :String, explain : String) {
    var idx : Int
    var name : String
    var explain : String

    init {
        this.idx = idx
        this.name = name
        this.explain = explain
    }

    open fun displayInfo() {
        println("ID : $idx, 이름 : $name, 설명 : [ $explain ]")
    }
}