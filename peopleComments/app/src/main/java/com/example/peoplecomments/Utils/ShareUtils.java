package com.example.peoplecomments.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtils {
    private static final String FILE_NAME="isFirst";
    private static final String WELCOME_KEY="welcome";

    public static Boolean getWelcomeShare(Context context){
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getBoolean(WELCOME_KEY, false);
    }

    public static void putWelcomeShare(Context context,Boolean isFirst){
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(WELCOME_KEY, isFirst);
        editor.commit();
    }
}
