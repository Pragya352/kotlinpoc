package com.example.kotlinpoc.dao

class demoDao {

    fun getHello(Test : String): String {
        return Test
    }

    companion object {
        fun getHello(s: String): String {
            return s
        }
    }
}