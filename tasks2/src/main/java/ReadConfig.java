import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReadConfig {
    private String configFile = "config.properties";
    private int age;
    private int[] intArray;
    private int[] intArray2;
    private LocalDate startDate;
    private LocalDate endDate;
    private String sentenceString;
    private String wordString;
    private String palindromeWord;
    private String password;
    private int year;
    private String imagesUrl;
    private String url;
    private List<String> listFirst;
    private List<String> listSecond;

    ReadConfig() {
        init();
    }
    public void init() {

        try
        {

            Configuration config = new PropertiesConfiguration(configFile);

            // access configuration properties
            this.age = config.getInt("age");

            this.intArray = convertIntArray(config.getString("intArray"));
            this.intArray2 = convertIntArray(config.getString("intArray2"));

            this.startDate = convertToDateArray(config.getStringArray("startDate"));
            this.endDate = convertToDateArray(config.getStringArray("endDate"));

            this.listFirst = convertListObjectToListString(config.getList("stringArray1"));
            this.listSecond = convertListObjectToListString(config.getList("stringArray2"));

            this.sentenceString = config.getString("sentenceString");
            this.wordString = config.getString("wordString");
            this.palindromeWord = config.getString("palindromeWord");
            this.password = config.getString("password");
            this.year = config.getInt("year");
            this.imagesUrl = config.getString("imagesUrl");
            this.url = config.getString("url");
        }
        catch (ConfigurationException cex)
        {
            // Something went wrong
        }
    }

    public int getAge() {
        return age;
    }

    public int[] getIntArray() {

        return intArray;
    }

    public int[] getIntArray2() {
        return intArray2;
    }

    public String getSentenceString() {
        return sentenceString;
    }

    public String getWordString() {
        return wordString;
    }

    public String getPalindromeWord() {
        return palindromeWord;
    }

    public String getPassword() {
        return password;
    }

    public int getYear() {
        return year;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }
    public String getUrl() {
        return url;
    }

    public List<String> getListFirst() {
        return listFirst;
    }

    public List<String> getListSecond() {
        return listSecond;
    }

    private static int[] convertIntArray(String stringArrayName) {
        int[] intArray;

        // In config list of INT numbers with ";" delimeter
        String[] parts = stringArrayName.split(";");
        intArray = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            intArray[i] = Integer.valueOf(parts[i]);
        }

        return intArray;
    }

    private static LocalDate convertToDateArray(String[] stringArray) {
        int intArray[] = {0, 0, 0};

        intArray[0] = Integer.valueOf(stringArray[0]);
        intArray[1] = Integer.valueOf(stringArray[1]);
        intArray[2] = Integer.valueOf(stringArray[2]);

        LocalDate dateName = LocalDate.of(intArray[0], intArray[1], intArray[2]);

        return dateName;
    }

    private static List<String> convertListObjectToListString(List<Object> listObject) {

        List<String> stringList = listObject.stream()
                .map( Object::toString )
                .collect( Collectors.toList() );
        return stringList;
    }
}
