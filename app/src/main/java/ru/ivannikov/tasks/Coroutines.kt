package ru.ivannikov.tasks

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.selects.select

/**
 * Задачи блока 4: асинхронное программирование и корутины.
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03
 */
object Coroutines {

    /**
     * Печатает сообщение, приостанавливается и печатает "Готово!".
     *
     * @param message Начальное сообщение.
     * @param delayMs Длительность задержки в миллисекундах.
     */
    suspend fun delayedPrint(message: String, delayMs: Long) {
        println(message)
        delay(delayMs)
        println("Готово!")
    }

    /**
     * Запускает три конкурентные задачи с задержками 1, 2 и 3 секунды.
     * Выводит результаты по мере готовности через select и onAwait.
     * Если несколько задач готовы одновременно, select выбирает первую готовую
     * ветку в порядке регистрации; строгий порядок для одновременных завершений не задан.
     *
     * @return Результаты в порядке обработки завершений.
     */
    suspend fun runParallelTasks(): List<String> = coroutineScope {
        val tasks = listOf(1000L, 2000L, 3000L).mapIndexed { index, delayMs ->
            async {
                delay(delayMs)
                "Результат ${index + 1}"
            }
        }
        val pending = tasks.toMutableList()
        val results = mutableListOf<String>()

        while (pending.isNotEmpty()) {
            val (completed, result) = select<Pair<Deferred<String>, String>> {
                pending.forEach { task ->
                    task.onAwait { value -> task to value }
                }
            }
            pending.remove(completed)
            println(result)
            results.add(result)
        }

        tasks.forEach { it.await() }
        results
    }
}
