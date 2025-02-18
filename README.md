# Quadratic Equation Solver

## Описание проекта

Этот проект представляет реализацию вычисления корней квадратного уравнения вида:
ax² + bx + c = 0

Реализация включает:
- Класс `MathService` для расчета дискриминанта и корней.
- Класс `Pair` для хранения двух корней.
- Тесты с использованием библиотеки JUnit 5 для проверки работы программы, включая позитивные и негативные сценарии, а также параметризованные тесты.

## Структура проекта

- **`MathService`**: Основной класс с методами:
    - `getAnswer(int a, int b, int c)` — вычисляет корни уравнения.
    - `getD(int a, int b, int c)` — вычисляет дискриминант.
- **`Pair`**: Класс для представления пары чисел (корней уравнения).
- **Тесты**:
    - Проверяют позитивные и негативные сценарии.
    - Включают параметризованные тесты для различных входных данных.
  
## Требования

- Java 8 или новее.
- Maven для сборки проекта и запуска тестов.

---

## Как запустить
1. Склонируйте репозиторий на вашу локальную машину.
2. Скомпилируйте проект с помощью Maven:
```
mvn clean install
```
3. Запустите тесты:
```
mvn test
```