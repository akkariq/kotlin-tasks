package ru.ivannikov.tasks

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Проверки ожидаемых результатов десяти основных задач лабораторной работы №2.
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 */
class TasksTest {

    /** Проверяет полный формат приветствия. */
    @Test
    fun greetingMatchesAssignment() {
        assertEquals(
            "Привет, Анна! Через 10 лет тебе будет 35 лет.",
            BasicSyntax.greetUser("Анна", 25)
        )
    }

    /** Проверяет все месяцы и недопустимые границы. */
    @Test
    fun seasonsCoverAllMonths() {
        val expected = listOf(
            "Зима", "Зима", "Весна", "Весна", "Весна", "Лето",
            "Лето", "Лето", "Осень", "Осень", "Осень", "Зима"
        )
        expected.forEachIndexed { index, season ->
            assertEquals(season, BasicSyntax.getSeason(index + 1))
        }
        assertEquals("Некорректный месяц", BasicSyntax.getSeason(0))
        assertEquals("Некорректный месяц", BasicSyntax.getSeason(13))
    }

    /** Проверяет факториал и граничные значения без переполнения Long. */
    @Test
    fun factorialHandlesBoundaries() {
        assertEquals(-1L, BasicSyntax.factorial(-3))
        assertEquals(1L, BasicSyntax.factorial(0))
        assertEquals(1L, BasicSyntax.factorial(1))
        assertEquals(120L, BasicSyntax.factorial(5))
        assertEquals(2432902008176640000L, BasicSyntax.factorial(20))
    }

    /** Проверяет числа, ошибочные строки и null. */
    @Test
    fun parsingIsNullSafe() {
        assertEquals(123, NullSafety.parseIntSafe("123"))
        assertEquals(-7, NullSafety.parseIntSafe("-7"))
        assertNull(NullSafety.parseIntSafe("abc"))
        assertNull(NullSafety.parseIntSafe(null))
        assertNull(NullSafety.parseIntSafe("999999999999999"))
    }

    /** Проверяет удаление null и удвоение значений. */
    @Test
    fun numbersAreFilteredAndDoubled() {
        assertEquals(
            listOf(2, 6, 10),
            NullSafety.filterNonNullAndDouble(listOf(1, null, 3, null, 5))
        )
        assertEquals(emptyList<Int>(), NullSafety.filterNonNullAndDouble(listOf(null)))
    }

    /** Проверяет средний возраст и пустую коллекцию. */
    @Test
    fun averageAgeHandlesEmptyList() {
        assertEquals(0.0, Collections.averageAge(emptyList()), 0.0)
        assertEquals(
            30.0,
            Collections.averageAge(listOf(Person("А", 25), Person("Б", 30), Person("В", 35))),
            0.0
        )
    }

    /** Проверяет верхний регистр ключей и пропуск пустых строк. */
    @Test
    fun wordsAreGroupedByUppercaseLetter() {
        assertEquals(
            mapOf('A' to listOf("apple", "apricot"), 'B' to listOf("banana")),
            Collections.groupByFirstLetter(listOf("apple", "apricot", "banana", "", " "))
        )
    }

    /** Проверяет длинное слово и отсутствие результата для пустого списка. */
    @Test
    fun longestWordHandlesEmptyList() {
        assertEquals("pineapple", Collections.findLongestWord(listOf("apple", "pineapple", "kiwi")))
        assertNull(Collections.findLongestWord(emptyList()))
    }

    /** Проверяет начальное сообщение и завершающую строку. */
    @Test
    fun delayedPrintIncludesCompletionMessage() {
        val originalOut = System.out
        val buffer = ByteArrayOutputStream()
        val output = PrintStream(buffer, true, "UTF-8")
        try {
            System.setOut(output)
            runBlocking { Coroutines.delayedPrint("Начинаем...", 0L) }
        } finally {
            System.setOut(originalOut)
            output.close()
        }
        val lines = buffer.toString("UTF-8").lineSequence().filter { it.isNotEmpty() }.toList()
        assertEquals(listOf("Начинаем...", "Готово!"), lines)
    }

    /** Проверяет результаты трёх конкурентных задач с заданными задержками. */
    @Test
    fun parallelTasksReturnAllResults() = runBlocking {
        assertEquals(
            listOf("Результат 1", "Результат 2", "Результат 3"),
            Coroutines.runParallelTasks()
        )
    }
}
