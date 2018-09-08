package com.mev;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        TestTasks testTasks = new TestTasks();

        int age = readConfigInt("age");
        int[] intArray = readConfigIntArray("intArray");
        int[] intArray2 = readConfigIntArray("intArray2");
        int[] dateArray;

        List<String> listFirst = new ArrayList<>();
        listFirst = readConfigArrayStringList("stringArray1", ";");
        List<String> listSecond = new ArrayList<>();
        listSecond = readConfigArrayStringList("stringArray2",";");

        String sentenceString = readConfigString("sentenceString");
        String wordString = readConfigString("wordString");

        String palindromeWord = readConfigString("palindromeWord");
        String password = readConfigString("password");

        String startDateName = "startDate";
        dateArray = readConfigDate(startDateName);
        LocalDate startDate = LocalDate.of(dateArray[0], dateArray[1], dateArray[2]);

        String endDateName = "endDate";
        dateArray = readConfigDate(endDateName);
        LocalDate endDate = LocalDate.of(dateArray[0], dateArray[1], dateArray[2]);

        int year = readConfigInt("year");
        String imagesUrl = readConfigString("imagesUrl");
        String url = readConfigString("url");

        testTasks.instantHeartRate(age);
        testTasks.task2_ArrayElementSum(intArray);
        testTasks.task3_ArrayElementMinMax(intArray2);
        testTasks.task4_SameArraysElements(listFirst, listSecond);
        testTasks.task5_CountWordInString(sentenceString, wordString);
        testTasks.task6_RemoveSpacesFromString(sentenceString);
        testTasks.task7_CheckPalindromeWord(palindromeWord);
        testTasks.task8_PasswordChecking(password);
        testTasks.task9_CompareDates(startDate, endDate);
        testTasks.task10_ProgrammerDay(year);

        testTasks.task11_Last100Tweets();
        testTasks.task12_SaveHTMLimages(imagesUrl);
        testTasks.task13_SaveHTMLToPDF(url);
    }

    public static int readConfigInt(String intConfigName) {
        Properties tasksConfig = new Properties();
        int intConfigValue;

        try {
            tasksConfig.load(new FileInputStream(new File("config.ini")));

            intConfigValue = Integer.valueOf(tasksConfig.getProperty(intConfigName));
            //SOME_DOUBLE_VALUE = Double.valueOf(tasksConfig.getProperty("SOME_DOUBLE_VALUE", "1.0"));
            return intConfigValue;
        }catch (IOException readFileExeption) {
            readFileExeption.printStackTrace();
        }
        return 0;
    }

    public static int[] readConfigIntArray(String intArrayConfigName) {
        Properties tasksConfig = new Properties();
        int[] intArray;

        try {
            tasksConfig.load(new FileInputStream(new File("config.ini")));

            // В настройках находится список целых через точку с запятой
            String[] parts = tasksConfig.getProperty(intArrayConfigName).split(";");
            intArray = new int[parts.length];
            for (int i = 0; i < parts.length; ++i) {
                intArray[i] = Integer.valueOf(parts[i]);
            }

            return intArray;
        }catch (IOException readFileExeption) {
            readFileExeption.printStackTrace();
        }
        return null;
    }

    public static List<String> readConfigArrayStringList(String stringArray1ConfigName, String delimiter) {
        Properties tasksConfig = new Properties();
        List<String> stringArray = new ArrayList<>();

        try {
            tasksConfig.load(new FileInputStream(new File("config.ini")));
            String[] parts = tasksConfig.getProperty(stringArray1ConfigName).split(delimiter);

            for (int i = 0; i < parts.length; ++i) {
                stringArray.add(parts[i]);
                //System.out.println(stringArray1ConfigName + ":" + parts[i]);
            }

            return stringArray;
        }catch (IOException readFileExeption) {
            readFileExeption.printStackTrace();
        }
        return null;
    }

    public static String readConfigString(String stringConfigName) {
        Properties tasksConfig = new Properties();

        try {
            tasksConfig.load(new FileInputStream(new File("config.ini")));
            //System.out.println(tasksConfig.getProperty(stringConfigName));
            return tasksConfig.getProperty(stringConfigName);
        }catch (IOException readFileExeption) {
            readFileExeption.printStackTrace();
        }
        return null;
    }

    public static int[] readConfigDate(String stringConfigName) {
        Properties tasksConfig = new Properties();
        String stringResult, year, month, day;
        int[] intArray = {0, 0, 0};

        try {
            tasksConfig.load(new FileInputStream(new File("config.ini")));
            stringResult = tasksConfig.getProperty(stringConfigName);

            year = stringResult.substring(0,stringResult.indexOf("/"));
            //System.out.println(year);

            intArray[0] = Integer.valueOf(year);

            month = stringResult.substring(stringResult.indexOf("/") + 1, stringResult.lastIndexOf("/"));
            //System.out.println(month);
            intArray[1] = Integer.valueOf(month);

            day = stringResult.substring(stringResult.lastIndexOf("/") + 1);
            //System.out.println(day);
            intArray[2] = Integer.valueOf(day);

            return intArray;
        }catch (IOException readFileExeption) {
            readFileExeption.printStackTrace();
        }
        return null;
    }

}
