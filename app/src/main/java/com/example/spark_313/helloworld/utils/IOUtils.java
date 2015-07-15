package com.example.spark_313.helloworld.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;

/**
 * Created by radu on 06.05.2015.
 */
public class IOUtils {

    public static int getStatusCode(VolleyError error) {
        if (error != null && error.networkResponse != null) {
            return error.networkResponse.statusCode;
        }
        return -1;
    }

    public static int getStatusCode(ExecutionException exception) {
        return getStatusCode((VolleyError) exception.getCause());
    }


    public static boolean isVolleyNetworkResponseError(ExecutionException exception) {
        return exception != null &&
                exception.getCause() != null &&
                exception.getCause() instanceof VolleyError &&
                ((VolleyError) exception.getCause()).networkResponse != null;
    }

    public static boolean isStatusCode(ExecutionException exception, int code) {
        return isVolleyNetworkResponseError(exception) && getStatusCode(exception) == code;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static String getBadRequestResponse(ExecutionException e) throws JSONException {
        NetworkResponse response = ((VolleyError) e.getCause()).networkResponse;
        String message = new String(response.data);
        //    Gson gson = new Gson();
        //     ErrorMessage errorMessage = gson.fromJson(message, ErrorMessage.class);
        return message;
    }

    public static String maskCardNumber(String cardNumber) {
        String mask = "XXXX-XXXX-XXXX-####";
        int value = 16 - cardNumber.length();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < value; i++) {
            prefix.append(0);
        }
        cardNumber = prefix.toString().concat(cardNumber);
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'X') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }
        String result = maskedNumber.toString().substring(value, maskedNumber.toString().length());
        return result;
    }

    private static String capitalize(String str, char[] delimiters) {
        int delimLen = (delimiters == null ? -1 : delimiters.length);
        if (str == null || str.length() == 0 || delimLen == 0) {
            return str;
        }
        int strLen = str.length();
        StringBuffer buffer = new StringBuffer(strLen);
        boolean capitalizeNext = true;
        for (int i = 0; i < strLen; i++) {
            char ch = str.charAt(i);

            if (isDelimiter(ch, delimiters)) {
                buffer.append(ch);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer.append(Character.toTitleCase(ch));
                capitalizeNext = false;
            } else {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    private static boolean isDelimiter(char ch, char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(ch);
        }
        for (int i = 0, isize = delimiters.length; i < isize; i++) {
            if (ch == delimiters[i]) {
                return true;
            }
        }
        return false;
    }


}
