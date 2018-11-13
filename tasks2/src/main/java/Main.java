public class Main {

    public static void main(String[] args) {
        //TestTasks testTasks = new TestTasks();
        ReadConfig readConfig = new ReadConfig();

        TestTasks.instantHeartRate(readConfig.getAge());
        TestTasks.task2_ArrayElementSum(readConfig.getIntArray());
        TestTasks.task3_ArrayElementMinMax(readConfig.getIntArray2());
        TestTasks.task4_SameArraysElements(readConfig.getListFirst(), readConfig.getListSecond());
        TestTasks.task5_CountWordInString(readConfig.getSentenceString(), readConfig.getWordString());
        TestTasks.task6_RemoveSpacesFromString(readConfig.getSentenceString());
        TestTasks.task7_CheckPalindromeWord(readConfig.getPalindromeWord());
        TestTasks.task8_PasswordChecking(readConfig.getPassword());
        TestTasks.task9_CompareDates(readConfig.getStartDate(), readConfig.getEndDate());
        TestTasks.task10_ProgrammerDay(readConfig.getYear());

        TestTasks.task11_Last100Tweets();
        //TestTasks.task12_SaveHTMLimages(readConfig.getImagesUrl());
        //TestTasks.task13_SaveHTMLToPDF(readConfig.getUrl());
    }

}
