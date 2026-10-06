package ru.ivannikov.tasks

/**
 * Модель данных, описывающая человека.
 *
 * @property name Имя человека.
 * @property age Полный возраст в годах.
 * @author Иванников Сергей Сергеевич
 * @since 2026-09-03
 */
data class Person(
    val name: String,
    val age: Int
)