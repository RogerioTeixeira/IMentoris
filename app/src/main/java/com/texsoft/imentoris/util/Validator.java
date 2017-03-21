package com.texsoft.imentoris.util;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by Rogerio Lavoro on 21/03/2017.
 */

public class Validator {
    public static boolean isValidEmail(String target) {
        return !isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isValidPassword(String target) {
        return !isEmpty(target) && target.length() >= 6;
    }

    public static boolean isEmpty(String target) {
        return TextUtils.isEmpty(target);
    }
}
