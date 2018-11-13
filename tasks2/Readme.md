1. Для запуска устaнoвите jdk/jre и Maven. Делаем глобальные переменные JAVA_HOME (указывающая на JDK) и в PATH (для Windows) добавляем maven/bin. 
Для сборки проекта: 
сменить текущую директорию на директорию проекта и написать в консоли
 mvn compile

Запуск:
сменить текущую директорию на директорию проекта и написать в консоли
 mvn exec:java -Dexec.mainClass="tasks-1.0-SNAPSHOT.jar"

или открыть и глянуть проект через IntelliJ IDEA

2. Вся конфигурация через config.properties.
 Примеры конфигурации:
 Для задачи 1: age = 40

 Для задачи 2: intArray = 8;5;7;2;3;0;
  Целочисленный массив. В качестве разделителя использовать ;

 Для задачи 3: intArray2 = 8;5;2;7;3;0;
  Целочисленный массив. В качестве разделителя использовать ;

 Для задачи 4:
  stringArray1 = White,Black,Red
  stringArray2 = Green,Red,White

 Для задачи 5:
  sentenceString = Boom One two boom bom brom boom
  wordString = boom
  Ищет слово "boom" в предложении 

 Для задачи 6:
  Удаляет пробелы для предложения из строки указанной в sentenceString.

 Для задачи 7:
  palindromeWord = tenet

 Для задачи 8:
  password = _BESTEe1

 Для задачи 9:
  startDate = 2018,07,01
  endDate = 2018,8,31
  В качестве разделителя использовать ,

 Для задачи 10:
  year = 2018

 Для задачи 11:
  Ещё не сделана

 Для задачи 12:
  imagesUrl = http://www.blizzard.com/
  Не рекомендую менять :) В некоторых сайтах заданы относительные пути, которые не всегда сопадают с именем сайта

 Для задачи 13: 
  url = https://maven.apache.org/

3. Использует библиотеки commons-configuration, flying-saucer-pdf, jsoup-1.11.3