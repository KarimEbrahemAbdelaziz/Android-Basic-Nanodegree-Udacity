package com.example.karim.reportcard;

public class ReportCard {

    /* Those variables are here to hold Student Data. */
    private int mStudentID;
    private String mStudentName;
    private String mCourse;
    private int mGrade;
    private String mSemester;

    /** Constructor to initialize the data. */
    public ReportCard(int studentID, String studentName, String course, int grade, String semester) {
        this.mStudentID = studentID;
        this.mStudentName = studentName;
        this.mCourse = course;
        this.mGrade = grade;
        this.mSemester = semester;
    }

    /** Function to return student ID. */
    public int getStudentID() {
        return mStudentID;
    }

    /** Function to set student ID. */
    public void setStudentID(int id) {
        mStudentID = id;
    }

    /** Function to return student name. */
    public String getStudentName() {
        return mStudentName;
    }

    /** Function to set student name. */
    public void setStudentName(String name) {
        mStudentName = name;
    }

    /** Function to return course. */
    public String getCourse() {
        return mCourse;
    }

    /** Function to set course. */
    public void setCourse(String course) {
        this.mCourse = course;
    }

    /** Function to return grade in integer form. */
    public int getGrade() {
        return mGrade;
    }

    /** Function to set grade. */
    public void setGrade(int grade) {
        this.mGrade = grade;
    }

    /** Function to return semester. */
    public String getSemester() {
        return mSemester;
    }

    /** Function to set semester. */
    public void setSemester(String semester) {
        this.mSemester = semester;
    }

    /** Function to return grade in string form. */
    public String getLetterGrade(int grade){

        String letterGrade;

        if(grade > 79 && grade < 101){
            letterGrade = "A";
        } else if (grade > 69 && grade < 50){
            letterGrade = "B";
        } else if (grade > 59 && grade < 70){
            letterGrade = "C";
        }  else if (grade > 49 && grade < 60){
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        return letterGrade;
    }

    /** Function to return all data in string form.
     *  I used it to practice and test. :) */
    @Override
    public String toString() {
        return  "Student ID = " + mStudentID +
                "\nStudent Name = " + mStudentName +
                "\nCourse = " + mCourse +
                "\nGrade = " + mGrade +
                "\nSemester = " + mSemester;
    }
}
