package com.rita.services

import com.rita.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    // simula um id do banco
    private val counter: AtomicLong = AtomicLong()
    // para inicializar o log
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        // declarando listagem de pessoas
        val persons: MutableList<Person> = ArrayList()
        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)


        }

        return persons

    }

        fun findById(id: Long): Person {

            val person = Person()

            person.id = counter.incrementAndGet()
            person.firstName = "Rita de cassia"
            person.lastName = "Teixeira"
            person.adress = "Passagem orquidea"
            person.gender = "F"

            return person
        }

    fun create(person: Person): Person {
        // iria ao banco
        return person
    }

    fun update(person: Person) = person
    fun delete(id: Long){}
        private fun mockPerson(i: Int): Person {
            // Mock = estrutura de código temporária até que outros componentes estejam prontos
            val person = Person()
            person.id = counter.incrementAndGet()
            person.firstName = "person name$i"
            person.lastName = "last name $i"
            person.adress = "brasil $i"
            person.gender = "$i"

            return person
        }



}