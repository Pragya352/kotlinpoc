package com.example.kotlinpoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class KotlinpocApplication

fun main(args: Array<String>) {
	println("User")
	runApplication<KotlinpocApplication>(*args)
}
