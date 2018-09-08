package com.mev;

import com.lowagie.text.DocumentException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTasks {
    public static void instantHeartRate(int age){
        //int pulseOfRest = 60;
        int maxPulse = 220 - age;
        double zoneVO2 = maxPulse * 0.9;
        double anaerobicZone = maxPulse * 0.8;
        double aerobicZone = maxPulse * 0.7;
        double fatBurningZone = maxPulse * 0.6;
        double zoneOfLightActivity = maxPulse * 0.5;

        System.out.println("---- 1 pulse ------");
        System.out.println("max ЧСС 100%: " + maxPulse);
        System.out.println("зона VO2 90% - 100%: " + zoneVO2 + " - " + maxPulse);
        System.out.println("анаэробная зона 80% - 90%: " + anaerobicZone + " - " + zoneVO2);
        System.out.println("аэробная зона 70% - 80%: " + aerobicZone + " - " + anaerobicZone);
        System.out.println("начало жиросжигающей зоны 60% - 70%: " + fatBurningZone + " - " + aerobicZone);
        System.out.println("зона легкой активности 50% - 60%: " + zoneOfLightActivity + " - " + fatBurningZone);
        System.out.println("-------------");
    }
    public static void task2_ArrayElementSum(int[] intArray){
        //int[] intArray = {2, 5, 7, 8, 3, 0};
        int i, arrayElementSum, manualArrayElementSum;

        manualArrayElementSum = 0;

        for(i=0; i < intArray.length; i++){
            manualArrayElementSum = manualArrayElementSum + intArray[i];
        }

        arrayElementSum = Arrays.stream(intArray).sum();

        System.out.println("---- 2 sum ------");
        System.out.println("Array manual sum: " + manualArrayElementSum);
        System.out.println("Array sum(): " + arrayElementSum);
        System.out.println("-------------");
    }

    public static void task3_ArrayElementMinMax(int[] intArray){
        //int[] intArray = {2, 5, 7, 8, 3, 0};
        int i, min, max;
        OptionalInt arrayBuiltInMax, arrayBuiltInMin;

        min = intArray[1];
        max = min;

        for(i=1; i < intArray.length; i++){
            if (max < intArray[i]) {
                max = intArray[i];
            }
            if (min > intArray[i]){
                min = intArray[i];
            }
        }

        arrayBuiltInMin = Arrays.stream(intArray).min();
        arrayBuiltInMax = Arrays.stream(intArray).max();

        System.out.println("---- 3 min/max ------");
        System.out.println("Array manual min=" + min + " max=" + max);
        System.out.println("Array max(): " + arrayBuiltInMax.getAsInt());
        System.out.println("Array min(): " + arrayBuiltInMin.getAsInt());
        System.out.println("-------------");
    }

    public static void task4_SameArraysElements(List<String> listFirst, List<String> listSecond){
        //List<String> listFirst = new ArrayList<>();
        //List<String> listSecond = new ArrayList<>();
        String result = "";
        int i,j;

        /*
        listFirst.add("White");
        listFirst.add("Black");
        listFirst.add("Red");

        listSecond.add("Green");
        listSecond.add("Red");
        listSecond.add("White"); */

        for(i=0; i < listFirst.size(); i++)
            for(j=0; j < listSecond.size(); j++) {
                if (listFirst.get(i).equals(listSecond.get(j))){
                    result = result + listFirst.get(i) + " ";
                }
            }

        listFirst.retainAll(listSecond);

        System.out.println("---- 4 same arrays elements ------");
        System.out.println("Same elements (manual): " + result);
        System.out.println("Same elements retainAll(): " + listFirst);

        System.out.println("-------------");
    }

    public static void task5_CountWordInString(String sentenceString, String wordString){
        int wordCounter = 0;

        for (String retval : sentenceString.split(" ")) {
            if (retval.toLowerCase().equals(wordString.toLowerCase())) {
                wordCounter++;
            }
        }

        System.out.println("---- 5 count some word usage in string ------");
        System.out.println("Count: " + wordCounter);

        System.out.println("-------------");
    }

    public static void task6_RemoveSpacesFromString(String sentenceString){
        String newString = "";

        for (String retval : sentenceString.split(" ")) {
            newString = newString + retval;
        }

        System.out.println("---- 6 Remove Spaces From String ------");
        System.out.println("String without spaces (manual): " + newString);
        System.out.println("String without spaces replaceAll(): " + sentenceString.replaceAll(" ",""));
        System.out.println("-------------");
    }

    public static void task7_CheckPalindromeWord(String palindromeWord){
        int i;
        Boolean isPalindrome = Boolean.TRUE;
        char letterStartIndex, letterEndIndex;

        System.out.println("---- 7 Check if word is palindrome ------");
        for(i=0; i < palindromeWord.length(); i++){
            letterStartIndex = palindromeWord.toLowerCase().charAt(i);
            letterEndIndex = palindromeWord.toLowerCase().charAt(palindromeWord.length() - i - 1);
            if (letterStartIndex != letterEndIndex) {
                System.out.println("'" + palindromeWord + "'" + " is NOT the palindrome");
                isPalindrome = Boolean.FALSE;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("'" + palindromeWord + "'" + " is the palindrome");
        }
        System.out.println("-------------");
    }

    public static void task8_PasswordChecking(String password){
        System.out.println("---- 8 Secure password check ------");

        if (checkWithRegExp(password)){
            System.out.println("Password " + "'" + password + "'" + " is secure");
        } else  System.out.println("Password " + "'" + password + "'" + " is NOT secure");

        System.out.println("-------------");
    }

    public static boolean checkWithRegExp(String passwordString){
        Pattern passwordPattern = Pattern.compile("^((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_])(?=\\S+$))(?=[a-zA-Z0-9_]+$).{8,30}$"); //max limit 30
        Matcher isPasswordSecure = passwordPattern.matcher(passwordString);
        return isPasswordSecure.matches();
    }

    public static void task9_CompareDates(LocalDate startDate, LocalDate endDate){
        //https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html
        long resultDays = compareDates(startDate, endDate);

        System.out.println("---- 9 Compare Dates ------");
        System.out.println("Date difference: " + resultDays + " days");
        System.out.println("-------------");
    }

    public static long compareDates(LocalDate startDate, LocalDate endDate) {
        long resultDays = ChronoUnit.DAYS.between(startDate, endDate);
        return resultDays;
    }

    public static void task10_ProgrammerDay(int year){
        LocalDate februaryDay = LocalDate.of(year, 2, 1);
        LocalDate marchDay = LocalDate.of(year, 3, 1);

        long daysInFebruary = compareDates(februaryDay, marchDay);

        System.out.println("---- 10 Programmer Day ------");
        if (daysInFebruary == 28) {
            System.out.println("Programmer Day 13th of September, " + new GregorianCalendar(year, 8, 13).getTime());
        } else System.out.println("Programmer Day 12th of September, "  + new GregorianCalendar(year, 8, 12).getTime());

        System.out.println("-------------");
    }

    public static void task11_Last100Tweets(){


        System.out.println("---- 11 Last 100 Tweets ------"); //https://twitter.com/tutspluscode

        System.out.println("-------------");
    }

    public static void task12_SaveHTMLimages(String url){
        //String url = "http://www.blizzard.com/"; //http://en.wikipedia.org/ //http://www.google.com
        int i=1;
        System.out.println("---- 12 Save HTML images to local directory ------");

        try {
            Document doc = Jsoup.connect(url).get();
            Elements images = doc.getElementsByTag("img");
            //System.out.println("Images: " + images);

            for (Element headline : images) {
                //log("%s\n\t%s", headline.attr("src"));
                System.out.println("Images: " + headline.attr("src"));

                if (headline.attr("src").equals("")) {
                    System.out.println("Image empty");
                } else{
                    //InputStream in = new URL(url+headline.attr("src")).openStream();
                    InputStream in = new URL(headline.attr("src")).openStream();
                    Files.copy(in, Paths.get("" + i + headline.attr("src").substring(headline.attr("src").lastIndexOf("."))));
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------");
    }

    public static void task13_SaveHTMLToPDF(String url){
        //https://stackoverflow.com/questions/10493837/how-to-export-html-page-to-pdf-format
        System.out.println("---- 13 Save HTML To PDF ------");

        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        //System.out.println(content);

        content = "<result>" +"<![CDATA[" + content + "]]>" + "</result>";
        ITextRenderer renderer = new ITextRenderer();

        renderer.setDocumentFromString(content);

        renderer.layout();

        try {
            renderer.setDocumentFromString(content);
            renderer.layout();

            String fileNameWithPath = "PDF-FromHtmlString.pdf";
            FileOutputStream fos = new FileOutputStream( fileNameWithPath );
            renderer.createPDF( fos );
            fos.close();

            System.out.println( "File 1: '" + fileNameWithPath + "' created." );
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-------------");
    }
}
