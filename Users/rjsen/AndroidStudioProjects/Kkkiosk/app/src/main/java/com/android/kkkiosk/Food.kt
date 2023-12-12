package com.android.kkkiosk

class Food(idx : Int,name :String, explain : String, price : Double, category : String) : Menu(idx,name,explain) {
    var price : Double
    var category : String

    init {
        this.price = price
        this.category = category
    }
    override fun displayInfo() {
        println("ID: $idx, 카테고리 : $category, 가격 : $price, 이름 : $name, 설명 : [ $explain ] ")
    }
}





