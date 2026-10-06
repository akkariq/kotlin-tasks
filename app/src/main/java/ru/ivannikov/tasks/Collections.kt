package ru.ivannikov.tasks

/**
 * Задачи блока 3: Работа со стандартными коллекциями Kotlin[cite: 1].
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03[cite: 1]
 */
object Collections {

    /**
     * Задача 3.1: Расчет среднего возраста списка людей[cite: 1].
     *
     * @param people Список объектов Person[cite: 1].
     * @return Средний возраст либо 0.0 для пустой коллекции[cite: 1].
     */
    fun averageAge(people: List<Person>): Double {
        if (people.isEmpty()) return 0.0
        return people.map { it.age }.average()
    }

    /**
     * Задача 3.2: Группировка списка слов по первому символу в верхнем регистре[cite: 1].
     *
     * @param words Список строк[cite: 1].
     * @return Map с группировкой по заглавным символам[cite: 1].
     */
    fun groupByFirstLetter(words: List<String>): Map<Char, List<String>> {
        return words
            .filter { it.isNotBlank() }
            .groupBy { it.first().uppercaseChar() }
    }

    /**
     * Задача 3.3: Поиск самого длинного слова в списке[cite: 1].
     *
     * @param words Список строк[cite: 1].
     * @return Самое длинное слово либо null[cite: 1].
     */
    fun findLongestWord(words: List<String>): String? {
        return words.maxByOrNull { it.length }
    }
}