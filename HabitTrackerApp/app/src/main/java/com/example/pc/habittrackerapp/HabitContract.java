package com.example.pc.habittrackerapp;

import android.provider.BaseColumns;

public class HabitContract  {

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME ="name";
        public final static String COLUMN_START_DATE = "start_date";
        public final static String COLUMN_NUMBER_OF_TIMES = "number_of_times";
    }
}
