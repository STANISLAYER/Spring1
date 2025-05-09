#  Spring Boot Project: Library Management System

## Работу выполнил Максименко Станислав, группа I2302
##  Описание проекта

Это RESTful-приложение на Spring Boot, предназначенное для управления библиотекой. Система поддерживает работу с авторами, книгами, издателями, категориями и библиотеками. Все сущности связаны с использованием JPA и аннотаций `@ManyToOne`, `@OneToMany`, `@ManyToMany` и `@ElementCollection`.

---

##  Реализованные связи между сущностями

| Сущность | Связь | Реализация |
|----------|-------|------------|
| **Author** | Один автор может написать много книг | `@OneToMany(mappedBy = "author")` |
| **Publisher** | Один издатель может издать много книг | `@OneToMany(mappedBy = "publisher")` |
| **Book** | Книга принадлежит одному автору | `@ManyToOne` |
|          | Книга имеет одного издателя (может быть null) | `@ManyToOne(optional = true)` |
|          | Книга принадлежит к нескольким категориям | `@ManyToMany` |
| **Category** | Категория может быть связана с несколькими книгами | `@ManyToMany(mappedBy = "categories")` |
| **Library** | Содержит список названий книг | `@ElementCollection` |

---

##  Технологии

- Spring Boot
- Spring Web (REST API)
- Spring Data JPA
- Maven

---

##  Структура проекта

```
src/
└── main/
    ├── java/
    │   └── com/example/spring1/
    │       ├── controller/
    │       ├── dto/
    │       ├── entity/
    │       ├── mapper/
    │       ├── repository/
    │       ├── service/
    │       └── LibraryApplication.java
    └── resources/
        └── application.properties
```

---

##  Примеры DTO и API

### Пример запроса для создания книги

```json
POST /api/books
{
  "title": "Преступление и наказание",
  "authorId": 1,
  "publisherId": 2,
  "categoryIds": [1, 2]
}
```

### Пример ответа

```json
{
  "id": 10,
  "title": "Преступление и наказание",
  "authorId": 1,
  "publisherId": 2,
  "categoryIds": [1, 2]
}
```

---

##  Примечания

- `Publisher` может быть `null` при создании книги.
- `authorId` обязателен.
- MapStruct используется для маппинга между Entity и DTO, включая ручной маппинг ID.

---



- Разработано в Visual Studio Code с использованием Maven
- Тестирование API через REST Client `.http`

