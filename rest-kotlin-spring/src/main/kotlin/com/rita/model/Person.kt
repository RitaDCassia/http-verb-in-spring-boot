package com.rita.model

import jakarta.persistence.*

// vamos fazer essa classe virar uma entidade, uma classe que representa uma tabela do banco
@Entity
// dizendo que é uma tabela do banco
@Table(name = "person")
data class Person(
    // dizemos que esse is é a chave primaria da tabela
    @Id
    // adicionamos a estrategia que vamos usar
    // o hibernate vai gerar um id incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    // aqui temos as demais colunas
    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",
    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",
    @Column(nullable = false, length = 100)
    var address: String = "",
    @Column(nullable = false, length = 6)
    var gender: String = "",
)
