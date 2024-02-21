package com.example.kotlinpoc.model


import jakarta.persistence.*
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@Entity
//@Table(name="Customer")
//@Primary
//@Bean(name="entityManagerFactory")
class Customer(
        val firstName: String,
        val lastName: String,
        var isActiveFlag: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1) {

        private constructor() : this("", "", "")

        override fun toString(): String {
                return "Customer(firstName='$firstName', lastName='$lastName', isActiveFlag='$isActiveFlag', id=$id)"
        }


}
