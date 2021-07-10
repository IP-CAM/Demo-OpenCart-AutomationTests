package util;

import java.util.Random;

public class GenerateRandomString {

    public String getRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        //Length of random string
        while (builder.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }
        String charString = builder.toString();
        return charString.toLowerCase();

    }
}
