package com.rita.services

import com.rita.exceptions.ResourceNotfoundException
import com.rita.model.Person
import com.rita.repository.PersonRepository
import jakarta.persistence.Entity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger
import kotlin.math.log

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository
    // para inicializar o log
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")
        return repository.findAll()

    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")
        return repository.findById(id)
            .orElseThrow{ResourceNotfoundException("Noo records found for this id")}

    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with id ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow {ResourceNotfoundException("No records found for this id!")}

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }
    fun delete(id: Long){
        logger.info("Deleting one person with id ${id}")
        val entity = repository.findById(id)
            .orElseThrow {ResourceNotfoundException("No records found for yhis id!")}
        repository.delete(entity)
    }
        private fun mockPerson(i: Int): Person {
            // Mock = estrutura de código temporária até que outros componentes estejam prontos
            val person = Person()
            //person.id = counter.incrementAndGet()
            person.firstName = "person name$i"
            person.lastName = "last name $i"
            person.address = "brasil $i"
            person.gender = "$i"

            return person
        }



}