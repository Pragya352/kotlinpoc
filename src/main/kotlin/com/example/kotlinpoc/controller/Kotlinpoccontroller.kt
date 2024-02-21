package com.example.kotlinpoc.controller

import com.example.kotlinpoc.dao.demoDao
import com.example.kotlinpoc.model.Customer
import com.example.kotlinpoc.repo.CustomerRepository
import com.example.kotlinpoc.service.pocService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Kotlinpoccontroller/*(val demoService: DemoService)*/ {

    @RequestMapping("/hello")
    fun helloKotlin(): String {
        return "hello world"
    }

    /* @GetMapping("/hello-service")
    fun helloKotlinService(): String {
        return pocService.
    }*/

    @GetMapping("/hello-dto")
    fun getHello(): String {
        return demoDao.getHello("User")
    }

    @Autowired
    lateinit var repository: CustomerRepository

    @RequestMapping("/save")
    fun save(): String {
        repository.save(Customer("Hendi", "Santika","Yes"))
        repository.save(Customer("Uzumaki", "Naruto","Yes"))
        repository.save(Customer("Uchiha", "Sasuke","Yes"))
        repository.save(Customer("Haruno", "Sakura","Yes"))
        repository.save(Customer("Hatake", "Kakashi","Yes"))

        return "Data successfully saved in repository"
    }

    @RequestMapping("/findAll")
    fun findAll() = repository.findAll()

    @RequestMapping("/findById/{id}")
    fun findById(@PathVariable id: Long) = repository.findById(id)

    @RequestMapping("findByLastname/{lastName}")
    fun findByLastName(@PathVariable lastName: String) = repository.findByLastName(lastName)

    @RequestMapping("/deleteid/{id}")
    fun deleteById(@PathVariable id: Long): String {
        repository.deleteById(id)

        return "Id deleted: " + id.toString()
    }

    @RequestMapping("/updateflag/{id}")
    fun updateFlag(@PathVariable id: Long): ResponseEntity<Customer>{

        var existingCustomer = repository.findById(id).orElse(null)

        if (existingCustomer == null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        existingCustomer.isActiveFlag = "NO"
        repository.save(existingCustomer)

        println("Active flag updated: " + id.toString())
        return ResponseEntity(existingCustomer, HttpStatus.OK)
    }
}