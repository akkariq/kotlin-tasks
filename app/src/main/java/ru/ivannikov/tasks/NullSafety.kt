package ru.ivannikov.tasks

/**
 * Задачи блока 2: Механизмы Null Safety в Kotlin[cite: 1].
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03[cite: 1]
 */
object NullSafety {

    /**
     * Задача 2.1: Безопасное преобразование nullable-строки в целое число[cite: 1].
     *
     * @param str Входная nullable-строка[cite: 1].
     * @return Число либо null, если парсинг невозможен[cite: 1].
     */
    fun parseIntSafe(str: String?): Int? {
        return str?.toIntOrNull()
    }

    /**
     * Задача 2.2: Фильтрация null-значений из списка и удвоение оставшихся элементов[cite: 1].
     *
     * @param list Список чисел, содержащий null[cite: 1].
     * @return Список удвоенных чисел без null[cite: 1].
     */
    fun filterNonNullAndDouble(list: List<Int?>): List<Int> {
        return list.filterNotNull().map { it * 2 }
    }
}