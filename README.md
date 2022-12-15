# Тестовое задание в компанию TOT systems
**Стек технологий: Java8, Postgres, Hibernate, Spring Data, SpringBoot**

> Чтобы запустить приложение необходимо иметь установленную СУБД PostgreSQL и в файле application.properties изменить дефолтные креды к бд на свои. По умолчанию используется стандартный порт 5432, суперюзер postges, для которого необходимо создать бд exchange (CREATE DATABASE exchange WITH OWNER = postgres). После старта приложение загружает исходные данные и дальше работает, как обычный REST-сервис

Исходные данные представлены выгрузками Московской биржи (описание API: https://fs.moex.com/files/6523): <br>
**Задача:** Реализовать API для CRUD операций по следующим объектам и их атрибутам:
1. Информация о ценных бумагах (Security)
- id
- secid
- regnumber
- name
- emitent_title
2. История торгов за произвольную дату (History)
- secid
- tradedate
- numtrades
- open:

Описание функционала:мпорт объектов из приложенных файлов в приложение:
Выбранную архитектуру решения и инструкцию по запуску приложения описать в Readme
файле.


## Система имеет следующие endpoints: ##
1. HistoryController <br>
GET /histories <br>
GET /histories/{id} <br>
POST /histories with Request body as JSON: 
  {
    "secid": "AKHA",
    "tradedate": "2022-12-14",
    "numtrades": 697.0,
    "open": 12.56,
    "close": 12.79
}<br>
DELETE /histories/{id} <br>
PATCH /histories/{id} with Request body as JSON: 
  {
    "open": 14.56,
    "close": 0.44
  }

2. GenreController <br>
GET /securities <br>
GET /securities/{id} <br>
POST /securities with Request body as JSON: 
 {
    "id": 1234,
    "secid": "TOTSYSTEMS",
    "regnumber": "1-03-45219-D",
    "name": "TOT systems форева",
    "emitentTitle": "TOT Systems российский разработчик ПО ""
} <br>
DELETE /securities/{id} <br>
PATCH /securities/{id} with Request body as JSON: 
{
    "name": "TOT systems, hunt me!",
}

3. MainController <br>
GET /stockmarket 
