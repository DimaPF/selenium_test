1. ��� ������� ���a�o���� jdk/jre � Maven. ������ ���������� ���������� JAVA_HOME (����������� �� JDK) � � PATH (��� Windows) ��������� maven/bin. 
��� ������ �������: 
������� ������� ���������� �� ���������� ������� � �������� � �������
 mvn compile

������:
������� ������� ���������� �� ���������� ������� � �������� � �������
 mvn exec:java -Dexec.mainClass="tasks-1.0-SNAPSHOT.jar"

��� ������� � ������� ������ ����� IntelliJ IDEA

2. ��� ������������ ����� config.properties.
 ������� ������������:
 ��� ������ 1: age = 40

 ��� ������ 2: intArray = 8;5;7;2;3;0;
  ������������� ������. � �������� ����������� ������������ ;

 ��� ������ 3: intArray2 = 8;5;2;7;3;0;
  ������������� ������. � �������� ����������� ������������ ;

 ��� ������ 4:
  stringArray1 = White,Black,Red
  stringArray2 = Green,Red,White

 ��� ������ 5:
  sentenceString = Boom One two boom bom brom boom
  wordString = boom
  ���� ����� "boom" � ����������� 

 ��� ������ 6:
  ������� ������� ��� ����������� �� ������ ��������� � sentenceString.

 ��� ������ 7:
  palindromeWord = tenet

 ��� ������ 8:
  password = _BESTEe1

 ��� ������ 9:
  startDate = 2018,07,01
  endDate = 2018,8,31
  � �������� ����������� ������������ ,

 ��� ������ 10:
  year = 2018

 ��� ������ 11:
  ��� �� �������

 ��� ������ 12:
  imagesUrl = http://www.blizzard.com/
  �� ���������� ������ :) � ��������� ������ ������ ������������� ����, ������� �� ������ �������� � ������ �����

 ��� ������ 13: 
  url = https://maven.apache.org/

3. ���������� ���������� commons-configuration, flying-saucer-pdf, jsoup-1.11.3