package com.android.kkiosk

val menus : MutableList<Munu> = ArrayList()
val food : MutableList<Food> = ArrayList()
val orders : MutableList<Order> = ArrayList()


fun main() {


    init()
    while (true) {
        displayMenu()
        var selectNumber = getNumber()
        if(selectNumber == 0) {
            println("종료합니다.")
            return
        }
        var  selecFood = selectMunu(selectNumber)
        selecFood?.let { food -> addOrder(food)  } ?: run{

        }
    }


}

fun init() {
    menus.add(Munu("Bugers","앵거스 비프 통살을 다져만든 버거"))
    menus.add(Munu("Forzen Custard","매장에서 신선하게 만드는 아이스크림"))
    menus.add(Munu("Drinks","매장에서 직접 만드는 음료"))
    menus.add(Munu("Beer","뉴욕 브루클린 브루어리에서 양조한 맥주"))

    food.add(Food(1, "ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, "Burgers"))
    food.add(Food(2, "SmokeBurger", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, "Burgers"))
    food.add(Food(3, "ShroomBurger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4, "Burgers"))
    food.add(Food(4, "CheeseBurger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9, "Burgers"))
    food.add(Food(5, "Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4, "Burgers"))

    food.add(Food(1,"Classic Shakes","쫀득하고 진한 커스타드가 들어간 클래식 쉐이크",5.9,"Forzen Custard"))
    food.add(Food(2,"Floats","부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료",5.9,"Forzen Custard"))
    food.add(Food(3,"Cups","매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림",5.9,"Forzen Custard"))

    food.add(Food(1,"Lemonade","매장에서 직접 만드는 상큼한 레몬에이드",4.5,"Drinks"))
    food.add(Food(2,"Fresh Brewed Iced Tea","직접 유기농 홍차를 우려낸 아이스 티",3.9,"Drinks"))
    food.add(Food(3,"Fifty/Fifty™ ","레몬에이드와 유기농 아이스 티가 만나 탄생한 시그니처 음료",4.4,"Drinks"))
    food.add(Food(4,"Bottled Water","지리산 암반대수층으로 만든 생수",1.5,"Drinks"))
    food.add(Food(5,"Fountain Soda","탄산음료",3.3,"Drinks"))
    food.add(Food(5,"Abita Root Beer ","청량감 있는 독특한 미국식 무알콜 탄산음료",4.4,"Drinks"))
    food.add(Food(5,"Hot Tea ","보성 유기농 찻잎을 우련낸 녹차,홍차,페퍼민트&레몬그라스",3.4,"Drinks"))

    food.add(Food(1,"Slow IPA ","The Hand and Malt",6.8,"Beer"))
    food.add(Food(1,"Gorillager  ","Gorilla Brewing Co, Busan",6.8,"Beer"))
    food.add(Food(1,"Shack Red™  ","진하고 스파이시한 레드 와인",29.9,"Beer"))
    food.add(Food(1,"Shack White™ ","맑고 상큼한 화이트 와인",29.9,"Beer"))
    food.add(Food(1,"ShackMeister™ Ale ","쉐이크쉑을 위해 핸드앤올트에서 특별히 양조한 에일 맥주",6.8,"Beer"))


}

fun getNumber () : Int {
    var num : String?
    var number : Int?

    while (true) {
        println("번호를 입력하시오")
        num = readLine()
        number = num?.toIntOrNull()

        if (number != null) {
            return number
        }else {
            println("번호를 다시 입력하시오")
        }
    }
}

fun selectMunu(idx : Int) : Food? {
    var munu = menus[idx-1]
    var categoryName = munu.name

    if (categoryName != "Order" && categoryName != "Cancel") {
        var filterFood = food.filter { it.category == categoryName }
        displayDetail(categoryName)

        while (true) {
            var selectFoodNumber = getNumber()
            if (selectFoodNumber > filterFood.size || selectFoodNumber < 0) {
                println("숫자를 다시 입력하시오")
            } else if (selectFoodNumber == 0) {
                return null
            } else {
                return filterFood[selectFoodNumber-1]
            }
        }

    } else {
        when (categoryName) {
            "Order" -> {
                var total = displayOrder(categoryName)
                if (total < 0.0) {
                    println("주문 내역이 없습니다")
                    return null
                }
                while (true) {
                    var selectOrderNum = getNumber()
                    when(selectOrderNum) {
                        1 -> {
                            orders.clear()
                            println("결제를 완료 했습니다.")
                        }
                        2 -> {
                            println("메인으로 돌아갑니다")
                            return null
                        }
                        else -> {
                            println("숫자를 다시 입력하시오")
                        }
                    }
                }
            }
            "Cancel" -> {
                orders.clear()
                println("메인으로 돌아갑니다")
                return null
            }
            else -> {
                return null
            }
        }
    }
}


fun displayMenu() {
    println("메뉴판을 보고 번호를 골라주세요")
    var menuSize = menus.size
    var count = 1
    for(idx in 1..menuSize) {
        val munu = menus[idx-1]
        val name = munu.name
        if (name == "Order") println(" [Order Menu] ")
        val exp = munu.explain
        println("$idx, $name, $exp")
        count++
    }
    println("0. 종료")
}

fun displayDetail(categoryName: String) {
    println("$categoryName Menu")

    var filterFood = food.filter { it.category == categoryName }
    var foodSize = filterFood.size
    for(idx in 1..foodSize) {
        val food = filterFood[idx-1]
        val name = food.name
        val price = food.price
        val exp = food.explain
        println("$idx, $name, W $price, $exp")
    }
}


fun addOrder(food: Food) {
    food.displayInfo()
    println("위 메뉴를 장바구니에 추가하시겠습니까?")
    println("[1] 확인 ,[2] 취소")

    while (true) {
        var adoNumber = getNumber()
        when(adoNumber) {
            1 -> {
                orders.add(Order(food))
                println(" ${food.name} 를(을) 장바구니에 추가했습니다. ")
                return
            }
            2-> {
                println("구매를 취소했습니다.")
                return
            }
            else -> {
                println("숫자를 다시 입력하시오")
            }
        }
    }
}

fun displayOrder(categoryName : String) : Double {
    var orderSize = orders.size
    if (orderSize > 0) {
        println("이대로 주문 하시겠습니까?")
        println("[ Orders ] ")

        for (i in 0 until orderSize) {
            orders[i].food.displayInfo()
        }

        println(" 총 가격은 ")
        val totalPrice = orders.fold(0.0) {ordnum2, order ->
            ordnum2 + order.food.price
        }
        println(" W $totalPrice 입니다.")
        return totalPrice
    }else {
        return -1.0
    }
}





