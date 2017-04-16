package com.example.karim.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize ArrayList with dumb data from my college. :D */
        ArrayList<ReportCard> reportCards = new ArrayList<>();
        reportCards.add(new ReportCard(2014760, "Karim Ebrahem", "Math 1", 86, "2014 - 2015"));
        reportCards.add(new ReportCard(2014761, "Ahmed Bahaa", "Math 2", 66, "2014 - 2015"));
        reportCards.add(new ReportCard(2014762, "Mario Hany", "Physics", 88, "2014 - 2015"));
        reportCards.add(new ReportCard(2014763, "Magdy Hassan", "English", 71, "2014 - 2015"));
        reportCards.add(new ReportCard(2014764, "Abdalla Ghanem", "Software Engineering", 32, "2014 - 2015"));
        reportCards.add(new ReportCard(2014765, "Yara Yasser", "English 2", 55, "2014 - 2015"));
        reportCards.add(new ReportCard(2014766, "Fatma AboElmagd", "Intro to CS", 89, "2014 - 2015"));
        reportCards.add(new ReportCard(2014767, "Ahmed Mohamed", "Database", 61, "2014 - 2015"));
        reportCards.add(new ReportCard(2014768, "Mostafa Khaled", "Logic Programming", 22, "2014 - 2015"));
        reportCards.add(new ReportCard(2014769, "Mahmoud yehya", "Operating Systems", 38, "2014 - 2015"));

        /* Set and Fill custom adapter with reportCards data. */
        ReportCardAdapter itemAdapter =
                new ReportCardAdapter(this, reportCards);

        /* Initialize list view that the user will show. */
        ListView listView = (ListView) findViewById(R.id.list);

        /* Fill list view from adapter. */
        listView.setAdapter(itemAdapter);
    }
}
