package utils;

import java.util.Random;

public class MailGenerator {

    public String getGeneratedEmail() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        String result = stringBuilder.toString() + "@somedomain.com";
        return result;
    }
}
