package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mohammad Mutakim on 11/11/17.
 */
public class ConfigReader {

    private String url;
    private String amazone;
    private String browser;

    private String chromeDriverPath;

    public ConfigReader() {

        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("config.properties");

            //load a properties file
            properties.load(inputStream);

            //get the property value and print it out
            this.url = properties.getProperty("url");
            this.amazone = properties.getProperty("amazon");
            this.chromeDriverPath = properties.getProperty("chrome_driver_path");
            this.browser = properties.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getAmazone() {
        return amazone;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }





    /*private String url;
    private String chromeDriverPath;

    public ConfigReader() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");
            this.chromeDriverPath = prop.getProperty("chrome_driver_path");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {

        return url;
    }

    public String getChromeDriverPath() {

        return chromeDriverPath;
    }*/
}
