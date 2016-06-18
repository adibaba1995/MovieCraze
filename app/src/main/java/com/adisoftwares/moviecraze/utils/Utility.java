package com.adisoftwares.moviecraze.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.adisoftwares.moviecraze.R;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Aditya Thanekar on 6/19/2015.
 * This class is just for utility stuff like checking internet conection, checking whether device is tablet or mobile, etc.
 */
public class Utility {

    //This method is used to check whether the user is online or not.
    public static boolean isOnline(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            Toast.makeText(context, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public static String getYearFromDate(String dateInString) {
        try {
            java.sql.Date javaSqlDate = java.sql.Date.valueOf(dateInString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(javaSqlDate);
            return Integer.toString(calendar.get(Calendar.YEAR));
        } catch(Exception e) {}
        return null;
    }

    public static String getFormattedDate(String dateInString) {
        try {
            java.sql.Date javaSqlDate = java.sql.Date.valueOf(dateInString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(javaSqlDate);
            return Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) + " " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) + " " + calendar.get(Calendar.YEAR);
        } catch(Exception e) {}
        return "";
    }

    public static String getHoursMinutesFromMinutes(int minutes) {
        int hours = minutes / 60;
        int minute = minutes % 60;
        return hours + " hr : " + minute + " min";
    }

    public static float dpFromPx(Context context, float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}