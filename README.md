# todo-app

Консольное приложение «Список задач» на Java с CI/CD через GitHub Actions.

## Стек

- Java 23 (Temurin)
- Gradle (Wrapper 8.10.2)
- JUnit 5
- Shadow plugin (fat-JAR)
- GitHub Actions (CI + Release + GitHub Packages)

## Команды приложения

| Команда | Описание |
|---------|----------|
| `add <task>` | добавить задачу |
| `remove <index>` | удалить задачу по индексу |
| `list` | показать все задачи |
| `done <index>` | отметить задачу выполненной |
| `search <строка>` | поиск задач по подстроке |
| `clear` | очистить весь список |
| `exit` | выход |

## Сборка и запуск

```bash
./gradlew build      # сборка + тесты + fat-JAR
./gradlew run        # запуск приложения
```

Fat-JAR появится в `build/libs/todo-app-<version>.jar` и запускается так:

```bash
java -jar build/libs/todo-app-0.2.0.jar
```

## Структура проекта

```
build.gradle                     конфигурация сборки (fat-JAR, maven-publish)
settings.gradle                  имя корневого проекта
gradle.properties                версия проекта
src/main/java/org/example/
  TodoList.java                  бизнес-логика списка задач
  TodoApp.java                   консольный интерфейс (CLI)
src/test/java/org/example/
  TodoListTest.java              тесты JUnit 5
.github/workflows/
  ci.yml                         сборка, тесты, GitHub Release
  publish-package.yml            публикация в GitHub Packages
  nightly.yml                    ночная сборка по расписанию
```
