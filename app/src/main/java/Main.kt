import kotlinx.coroutines.runBlocking
import ru.ivannikov.tasks.BasicSyntax
import ru.ivannikov.tasks.Collections
import ru.ivannikov.tasks.Coroutines
import ru.ivannikov.tasks.NullSafety
import ru.ivannikov.tasks.Person

/**
 * Демонстрационная точка входа для валидации всех задач лабораторной работы №2.
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03
 */
fun main() {
    println("=== Лабораторная работа 2: Основы языка Kotlin ===\n")

    // Блок 1. Базовый синтаксис
    println("--- Блок 1. Базовый синтаксис ---")
    println(BasicSyntax.greetUser("Сергей", 20))
    println("Месяц 3: ${BasicSyntax.getSeason(3)}")
    println("Месяц 7: ${BasicSyntax.getSeason(7)}")
    println("Месяц 13: ${BasicSyntax.getSeason(13)}")
    println("Факториал 5: ${BasicSyntax.factorial(5)}")
    println("Факториал 0: ${BasicSyntax.factorial(0)}")
    println("Факториал -3: ${BasicSyntax.factorial(-3)}")
    println()

    // Блок 2. Null-безопасность
    println("--- Блок 2. Null-безопасность ---")
    println("parseIntSafe(\"123\"): ${NullSafety.parseIntSafe("123")}")
    println("parseIntSafe(\"abc\"): ${NullSafety.parseIntSafe("abc")}")
    println("parseIntSafe(null): ${NullSafety.parseIntSafe(null)}")
    val mixedList = listOf(1, null, 3, null, 5)
    println("filterNonNullAndDouble($mixedList): ${NullSafety.filterNonNullAndDouble(mixedList)}")
    println()

    // Блок 3. Коллекции
    println("--- Блок 3. Коллекции ---")
    val people = listOf(
        Person("Алексей", 25),
        Person("Мария", 30),
        Person("Иван", 35)
    )
    println("Средний возраст: ${Collections.averageAge(people)}")

    val fruits = listOf("apple", "apricot", "banana", "blueberry", "cherry")
    println("Группировка по букве: ${Collections.groupByFirstLetter(fruits)}")

    val words = listOf("apple", "banana", "pineapple", "kiwi")
    println("Самое длинное слово: ${Collections.findLongestWord(words)}")
    println()

    // Блок 4. Корутины
    println("--- Блок 4. Корутины ---")
    runBlocking {
        print("Ожидание delayedPrint: ")
        Coroutines.delayedPrint("Сообщение с задержкой получено!", 500L)

        println("Запуск параллельных задач...")
        val parallelResults = Coroutines.runParallelTasks()
        println("Параллельные результаты: $parallelResults")
    }
}