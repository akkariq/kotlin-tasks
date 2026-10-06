package ru.ivannikov.tasks

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

/**
 * Задачи блока 4: Асинхронное программирование и корутины[cite: 1].
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03[cite: 1]
 */
object Coroutines {

    /**
     * Задача 4.1: Приостановка выполнения с последующим выводом сообщения[cite: 1].
     *
     * @param message Текст сообщения[cite: 1].
     * @param delayMs Длительность задержки в миллисекундах[cite: 1].
     */
    suspend fun delayedPrint(message: String, delayMs: Long) {
        delay(delayMs)
        println(message)
    }

    /**
     * Задача 4.2: Параллельный запуск трех задач с получением результатов через async/await[cite: 1].
     *
     * @return Список результатов всех трех задач[cite: 1].
     */
    suspend fun runParallelTasks(): List<String> = coroutineScope {
        val task1 = async {
            delay(300L)
            "Результат 1"
        }
        val task2 = async {
            delay(200L)
            "Результат 2"
        }
        val task3 = async {
            delay(100L)
            "Результат 3"
        }

        listOf(task1.await(), task2.await(), task3.await())
    }
}