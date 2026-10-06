package ru.ivannikov.tasks

/**
 * Задачи блока 1: Базовый синтаксис Kotlin.
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03
 */
object BasicSyntax {

    /**
     * Задача 1.1: Форматирует приветственную строку и рассчитывает возраст через 10 лет[cite: 1].
     *
     * @param name Имя пользователя[cite: 1].
     * @param age Текущий возраст[cite: 1].
     * @return Приветственная строка[cite: 1].
     */
    fun greetUser(name: String, age: Int): String {
        return "Привет, $name! Через 10 лет тебе будет ${age + 10}."
    }

    /**
     * Задача 1.2: Определяет время года по номеру месяца через конструкцию when[cite: 1].
     *
     * @param month Номер месяца (1-12)[cite: 1].
     * @return Название времени года[cite: 1].
     */
    fun getSeason(month: Int): String {
        return when (month) {
            12, 1, 2 -> "Зима"
            in 3..5 -> "Весна"
            in 6..8 -> "Лето"
            in 9..11 -> "Осень"
            else -> "Некорректный месяц"
        }
    }

    /**
     * Задача 1.3: Вычисляет факториал числа с хвостовой рекурсией (tailrec)[cite: 1].
     *
     * @param n Исходное неотрицательное число[cite: 1].
     * @param accumulator Промежуточный результат умножения[cite: 1].
     * @return Значение факториала либо -1 для отрицательных n[cite: 1].
     */
    tailrec fun factorial(n: Int, accumulator: Long = 1L): Long {
        return when {
            n < 0 -> -1L
            n == 0 || n == 1 -> accumulator
            else -> factorial(n - 1, accumulator * n)
        }
    }
}