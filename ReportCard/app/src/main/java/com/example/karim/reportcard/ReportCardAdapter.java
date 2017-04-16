package com.example.karim.reportcard;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by karim on 4/5/17.
 */

public class ReportCardAdapter extends ArrayAdapter<ReportCard> {

    public ReportCardAdapter(Activity context, ArrayList<ReportCard> reportCardArrayList) {
        super(context, 0, reportCardArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item, parent, false);
        }

        /** Get current report card in this position. */
        ReportCard currentReportCard = getItem(position);

        /** Set student Id text view with data. */
        TextView studentId = (TextView) listItemView.findViewById(R.id.student_id);
        studentId.setText(Integer.toString(currentReportCard.getStudentID()));

        /** Set student name text view with data. */
        TextView studentName = (TextView) listItemView.findViewById(R.id.student_name);
        studentName.setText(currentReportCard.getStudentName());

        /** Set course text view with data. */
        TextView course = (TextView) listItemView.findViewById(R.id.course);
        course.setText(currentReportCard.getCourse());

        /** Set grade text view with data. */
        TextView grade = (TextView) listItemView.findViewById(R.id.grade);
        grade.setText(currentReportCard.getLetterGrade(currentReportCard.getGrade()));

        /** Set semester text view with data. */
        TextView semester = (TextView) listItemView.findViewById(R.id.semester);
        semester.setText(currentReportCard.getSemester());

        return listItemView;
    }
}
