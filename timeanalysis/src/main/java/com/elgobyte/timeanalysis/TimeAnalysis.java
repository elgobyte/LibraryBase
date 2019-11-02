package com.elgobyte.timeanalysis;

import android.annotation.SuppressLint;
import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TimeAnalysis {


    private Context context;

    private String time;

    public TimeAnalysis() {
    }

    public TimeAnalysis(Context context) {

        this.context = context;
    }


    // Average Time Calculator (based on seconds)
    public String getAverage(ArrayList<String> arrivalTimings) throws ParseException {

        String hours;
        String minutes;
        int averageTime = 0;

        ArrayList<Integer> secondsRecord = new ArrayList<>();
        for (int i = 0; i < arrivalTimings.size(); i++) {

            // TODO : Add a check to see whether time is in 12h Format or 24h Format
            hours = getHours(to24Hours(arrivalTimings.get(i)));  //to24Hours(arrivalTimings.get(i).getTime())
            minutes = getMinutes(to24Hours(arrivalTimings.get(i)));
            secondsRecord.add(totalSeconds(hours, minutes));
        }


        // getting total of all values
        for (int i = 0; i < secondsRecord.size(); i++) {

            averageTime += secondsRecord.get(i);
        }

        // calculating average of all arrival times
        averageTime = averageTime / secondsRecord.size();

        time = convertSecondsToTime(averageTime);

        return time;


     /*   ArrayList<Integer> testRecord = new ArrayList<>();
        ArrayList<String> testTimings = new ArrayList<>();
        testTimings.add("12:05 PM");
        testTimings.add("11:30 AM");
        testTimings.add("11:30 AM");
        testTimings.add("12:10 PM");
        testTimings.add("12:00 PM");
        testTimings.add("11:45 AM");


        for (int i = 0; i < testTimings.size(); i++) {

            hours = getHours(to24Hours(testTimings.get(i)));  //
            minutes = getMinutes(to24Hours(testTimings.get(i)));
            Toast.makeText(context, String.valueOf(hours + ":" + minutes), Toast.LENGTH_LONG).show();
            testRecord.add(totalSeconds(hours, minutes));
        }


        // getting total of all values
        for (int i = 0; i < testRecord.size(); i++) {

            averageTime += testRecord.get(i);
        }

        // calculating average of all arrival times
        averageTime = averageTime / testRecord.size();

        time = convertSecondsToTime(averageTime);

        return time;*/

    }

    public String getHours(String time) {

        return time.substring(0, time.indexOf(":"));

    }

    public String getMinutes(String time) {

        return time.substring(time.indexOf(":") + 1, time.indexOf(":") + 3);

    }

    public int totalSeconds(String hours, String minutes) {

        // Toast.makeText(context, String.valueOf(hours), Toast.LENGTH_LONG).show();

        int hour = Integer.parseInt(hours);
        int mints = Integer.parseInt(minutes);

        int hour_seconds = (hour * 60) * 60;
        int minutes_seconds = mints * 60;

        return hour_seconds + minutes_seconds;


    }

    public String convertSecondsToTime(int totalSeconds) {

        int hours = (totalSeconds / 60);
        int mints = hours % 60;
        hours = hours / 60;
        int seconds = totalSeconds % 60;

        String time = hours + ": " + mints + ": " + seconds;

        return to12Hours(time);

    }


    @SuppressLint("SimpleDateFormat")
    public String to12Hours(String timeIn24Hours) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            final Date dateObj = sdf.parse(timeIn24Hours);
            assert dateObj != null;
            time = new SimpleDateFormat("hh:mm aa").format(dateObj);

            return time;
        } catch (final ParseException e) {
            e.printStackTrace();
            return "error";
        }

    }

    @SuppressLint("SimpleDateFormat")
    public String to24Hours(String timeIn12Hours) throws ParseException {


        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        Date date = parseFormat.parse(timeIn12Hours);

        assert date != null;

        return displayFormat.format(date);

    }


}

