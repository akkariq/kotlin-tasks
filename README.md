# Kotlin Tasks — Лабораторная работа №2

Практическая работа по изучению базовых возможностей языка Kotlin: синтаксис, система Null Safety, функциональная обработка коллекций и асинхронность на базе Coroutines.

## Результаты выполнения
![Вывод в консоли](screenshots/console_output.png)

## Стек технологий
- **Язык разработки:** Kotlin (JVM)
- **Система сборки:** Gradle (Kotlin DSL)
- **Библиотеки:** `kotlinx-coroutines-core` (1.8.0)
- **Среда разработки:** Android Studio

## Структура проекта
- `app/src/main/java/Main.kt` — точка входа и демонстрация работы функций.
- `app/src/main/java/tasks/DataClasses.kt` — модель данных `Person`.
- `app/src/main/java/tasks/BasicSyntax.kt` — блок 1: строковая интерполяция, оператор `when`, хвостовая рекурсия `tailrec`.
- `app/src/main/java/tasks/NullSafety.kt` — блок 2: безопасные вызовы `?.`, `toIntOrNull()`, `filterNotNull()`.
- `app/src/main/java/tasks/Collections.kt` — блок 3: операции `average()`, `groupBy()`, `maxByOrNull()`.
- `app/src/main/java/tasks/Coroutines.kt` — блок 4: приостанавливаемые функции `suspend`, `coroutineScope`, билдеры `async` и `await`.
- `app/src/test/java/MainTest.kt` — запуск выполнения через тестовый раннер.

## Инструкция по сборке и запуску
1. Склонируйте репозиторий:
   ```bash
   git clone [https://github.com/akkariq/kotlin-tasks.git](https://github.com/akkariq/kotlin-tasks.git)