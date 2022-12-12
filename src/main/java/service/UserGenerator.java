package service;

import org.apache.commons.lang3.RandomStringUtils;
import service.pojo.User;

public class UserGenerator {
    static int targetStringLength = 6;

    public static String randomEmail() {
        return RandomStringUtils.randomAlphabetic(targetStringLength).toLowerCase()+"@yandex.ru";
    }
    public static String randomPassword() {
        return RandomStringUtils.randomAlphanumeric(targetStringLength);
    }
    public static String randomName() {
        return RandomStringUtils.randomAlphabetic(targetStringLength);
    }
    public static String randomWrongPassword() {return RandomStringUtils.randomAlphanumeric(5);}
    public static User randomUser() { return new User(randomEmail(), randomPassword(), randomName()); }
    public static User randomWrongPasswordUser() { return new User(randomEmail(),randomWrongPassword(),randomName()); }
}
