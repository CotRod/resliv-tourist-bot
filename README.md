# resliv-tourist-bot @resliv_tourist_bot
Spring Boot приложение. Запускной класс App.class.
```
bot.username: resliv_tourist_bot
bot.token: 1113235082:AAG2973CZQBVHbEgqO4Up7vJBOPCkaOyGjE
```
Со стартом приложения на базу h2 накатывается небольшая таблица с городами: Minsk, Брест, Могилев, Гомель

Рест запросы доступны по урлам:
`localhost:8080/cities` **POST** - создание города;
`localhost:8080/cities/{cityId}` **DELETE** - удаление, **PUT** - обновление. 
:sunglasses:
