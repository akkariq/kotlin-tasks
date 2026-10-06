package ru.ivannikov.tasks

/**
 * Задачи блока 1: базовый синтаксис Kotlin.
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03
 */
object BasicSyntax {

    /**
     * Форматирует приветствие с возрастом пользователя через 10 лет.
     *
     * @param name Имя пользователя.
     * @param age Текущий возраст.
     * @return Приветственная строка.
     */
    fun greetUser(name: String, age: Int): String {
        return "Привет, $name! Через 10 лет тебе будет ${age + 10} лет."
    }

    /**
     * Определяет время года по номеру месяца.
     *
     * @param month Номер месяца от 1 до 12.
     * @return Название времени года или сообщение о некорректном месяце.
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
     * Вычисляет факториал хвостовой рекурсией.
     * Точный результат при стандартном накопителе помещается в Long для n от 0 до 20.
     * Переполнение при больших n не проверяется.
     *
     * @param n Исходное число.
     * @param accumulator Промежуточный результат умножения.
     * @return Факториал или -1 для отрицательного n.
     */
    tailrec fun factorial(n: Int, accumulator: Long = 1L): Long {
        return when {
            n < 0 -> -1L
            n == 0 || n == 1 -> accumulator
            else -> factorial(n - 1, accumulator * n)
        }
    }
}
