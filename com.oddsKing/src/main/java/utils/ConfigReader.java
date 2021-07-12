package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties _prop;
    private FileInputStream inputStream;
    private String url;
    private String browser;
    private String propertyFilePath = System.getProperty("user.dir") +
            "/src/main/resources/config/config.properties";
    private String email;
    private String userName;
    private String password;
    private String firsName;
    private String lastName;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String phoneNumber;
    private String securityAnswer;
    private String securityQuestion;
    private String address;
    private String nodeUrl;

    public ConfigReader() {
        _prop = new Properties();

        try{
            inputStream = new FileInputStream(propertyFilePath);
            _prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }

        //Get properties from config.properties
        url = _prop.getProperty("baseUrl");
        browser = _prop.getProperty("browser");
        email = _prop.getProperty("email");
        userName = _prop.getProperty("username");
        password = _prop.getProperty("password");
        firsName = _prop.getProperty("firstName");
        lastName = _prop.getProperty("lastName");
        birthDay = _prop.getProperty("birthDay");
        birthMonth = _prop.getProperty("birthMonth");
        birthYear = _prop.getProperty("birthYear");
        phoneNumber = _prop.getProperty("phoneNumber");
        securityQuestion = _prop.getProperty("securityQuestionValue");
        securityAnswer = _prop.getProperty("securityAnswer");
        address = _prop.getProperty("address");
        nodeUrl = _prop.getProperty("nodeUrl");
    }

    public String getNodeUrl() {
        return nodeUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getAddress() {
        return address;
    }
}
