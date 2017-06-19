package com.example.pc.habittrackerapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pc.habittrackerapp.HabitContract.HabitEntry;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditActivity extends AppCompatActivity {

    @BindView(R.id.edit_text_name)
    EditText mNameEditText;
    @BindView(R.id.edit_text_number_of_times)
    EditText mNumberOfTimesEditText;
    @BindView(R.id.text_view_date)
    TextView mDateTextView;
    private String mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        mCurrentDate =  sdf.format(c.getTime());
        Log.d("Edit", mCurrentDate);
        mDateTextView.setText(mCurrentDate);
    }

    private void insertHabit(){

        String nameString = mNameEditText.getText().toString().trim();
        String numberOfTimesString = mNumberOfTimesEditText.getText().toString().trim();
        int numberOfTimes = 0;
        if(!"".equals(numberOfTimesString))
            numberOfTimes = Integer.parseInt(numberOfTimesString);

        DbHelper mDbHelper = new DbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_NAME, nameString);
        values.put(HabitEntry.COLUMN_START_DATE, mCurrentDate);
        values.put(HabitEntry.COLUMN_NUMBER_OF_TIMES, numberOfTimes);

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    public void onSave(View view) {
        if(mNameEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Habit Name must be not empty", Toast.LENGTH_SHORT).show();
            return;
        }
        insertHabit();
        finish();
    }

    public void onCancel(View view) {
        finish();
    }
}
