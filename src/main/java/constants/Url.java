package constants;

public class Url {


    public static final String HOST = "https://qa-desk.education-services.ru";

    public static String getHost() {
        if (System.getProperty("host") != null) {
            return System.getProperty("host");
        } else {
            return HOST;
        }
    }
}
