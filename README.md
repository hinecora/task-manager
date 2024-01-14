# Spring Boot 3.0 Security with JWT Implementation
Этот проект демонстрирует реализацию безопасности с использованием Spring Boot 3.0 и веб-токенов JSON (JWT). Он включает в себя следующие функции:

## Features
* Регистрация пользователя и вход в систему с аутентификацией JWT
* Шифрование пароля с помощью BCrypt
* Авторизация, на основе роли с помощью Spring Security
* Настраиваемая обработка отказа в доступе
* Механизм выхода из системы
* Обновление токена

## Technologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* BCrypt
* Maven

## Getting Started
Чтобы начать работу с проектом, вам необходимо установить на локальном компьютере следующее:

* JDK 17+
* Maven 3+


Чтобы собрать и запустить проект, выполните следующие действия:

* Клонируем репозиторий: `git clone https://github.com/ali-bouali/spring-boot-3-jwt-security.git`
* Перейдите в каталог проекта: cd Spring-boot-security-jwt.
* Добавьте базу данных «hinecora_task_manager» в postgres.
* Сборка проекта: mvn clean install
* Запустите проект: mvn Spring-boot:run.

-> Приложение будет доступно по адресу http://localhost:8083.