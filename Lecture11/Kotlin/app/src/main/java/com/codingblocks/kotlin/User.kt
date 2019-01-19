package com.codingblocks.kotlin

class User(var name: String, var age: Int) {


    fun test() {
        globalFunction()
        val multiConstructor = MultiConstructor()
        val multiConstructor2 = MultiConstructor("Harshit")
        val multiConstructor3 = MultiConstructor(anotherMemberVar = 5)
    }

}

class ClassName() {

    private lateinit var memberVar: String
    private var anotherMemberVar: Int = 0
    lateinit var thirdMemberVar: String

//    constructor() : this("", 0)
//    constructor(onlyVar: String) : this(onlyVar, 0)
//    constructor(onlyVar: Int) : this("", onlyVar)

    fun getMemberVarSize() = memberVar.length

    fun getAnotherMemberVarSize() = anotherMemberVar + memberVar.length

}

class MultiConstructor(var memberVar: String = "", var anotherMemberVar: Int = 0) {

    lateinit var thirdParam: String

    constructor(first: String, second: Int, third: String) : this(first, second) {
        thirdParam = third
    }

}