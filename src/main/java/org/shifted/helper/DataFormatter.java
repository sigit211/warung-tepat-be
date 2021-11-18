package org.shifted.helper;

public class DataFormatter {

    public StringBuilder refCodeGenerator(String cart_id, String user_id, String date) {
        StringBuilder refCode = new StringBuilder();
        return refCode.append(cart_id).append(user_id).append(date);
    }
}
