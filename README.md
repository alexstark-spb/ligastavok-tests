# Автотесты для UI: ['ЯндексМаркет'](https://market.yandex.ru/) и API: ['TheCatAPI'](https://thecatapi.com/)

## Реализованы проверки:
### UI
1. Зайти на market.yandex.ru;
2. Выбрать раздел Электроника - > Телевизоры;
3. Задать параметр поиска:
   * По цене: от 20000 рублей; 
   * По производителю: Samsung и LG;
4. Открыть первый найденный телевизор из списка.
   * Проверить что производитель и цена соответствуют выбранным параметрам поиска.

### API
1. Выполнить запрос к /breeds/search по названию породы "Scottish Fold".
   * В ответе достать id этой породы;
2. Выполнить запрос к /images/search, в теле запроса должен быть указан параметр breed_id с ранее полученным id породы из шага 1.
   * В ответе проверить, что действительно найдено изображение с указанным breed_id. Из ответа достать id изображения и url изображения;
3. Выполнить запрос к /favourites, который добавит данное изображение в избранное.
   * В ответе проверить, что присутствует ключ "message" со значением "SUCCESS" и получить из него id избранного;
4. Выполнить get запрос к /favourites.
   * Проверить, что в ответе присутствует ключ "id" (избранного) со значением, полученным в шаге 3, а также ключ "image_id" со значением, полученным на шаге 2;
5. Выполнить delete запрос к /favourites, указав в качестве параметра полученный id избранного из шага 3.
   * В ответе проверить, что присутствует ключ "message" со значением "SUCCESS";
6. Снова выполнить get запрос к /favourites.
   * Проверить, что теперь в ответе отсутствует ключ "id" (избранного) со значением, полученным в шаге 3 (т.е. что изображение действительно было удалено из избранного).

## Используемые технологии и инструменты
<table>
<tbody>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"><br>IntelliJ IDEA</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"><br>Java</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"><br>Gradle</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"><br>JUnit5</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"><br>Selenide</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Rest-Assured.svg" width="40" height="40"><br>Rest-Assured</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="40" height="40"><br>Allure Report</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"><br>Github</td>
</tr>
</tbody>
</table>

## Команды для запуска из терминала
Для запуска API тестов потребуется API Key!

Получить его можно по электронной почте бесплатно после регистрации на сайте [thecatapi.com](https://thecatapi.com/)
### Запуск всех тестов UI + API:
```bash
gradle clean test -DapiKey=*ваш API Key*
```
### Запуск тестов UI с параметрами по умолчанию:
```bash
gradle clean ui_tests
```
### Запуск тестов UI с браузером FireFox и разрешением 1920х1080:
```bash
gradle clean ui_tests -Dbrowser=firefox -DbrowserSize=1920x1080
```
### Запуск тестов UI с включением параллельного выполнения и выбором 4-х потоков:
```bash
gradle clean ui_tests -DparallelRun=true -Dthreads=4
```
### Запуск тестов API:
```bash
gradle clean api_tests -DapiKey=*ваш API Key*
```
### Собрать Allure отчет:
```bash
allure serve build/allure-results
```
## Отчёт в Allure Report
### Доска с аналитикой тестирования
![Allure Overview]()

### Пример автоматизированного тест кейса
![Allure Behaviors]()
