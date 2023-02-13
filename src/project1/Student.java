package project1;
import java.util.Scanner;


public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditsCompleted;

    Student(Profile p, Major m, int cc) {
        profile = p;
        major = m;
        creditsCompleted = cc;
    }
    Student (Profile p) {
        profile = p;
        major = major.CS;
        creditsCompleted = 0;
    }



    @Override
    public String toString() {
        String output;
        output = profile.toString() + " (" + major.getClassCode() + " " + major.getMajor() + " " +  major.getSchool() +  " + creditsCompleted: " + creditsCompleted;
        if(creditsCompleted < 30) {
            output += "(Freshman)";
        } else if(creditsCompleted < 60) {
            output += "(Sophomore)";
        } else if(creditsCompleted < 90) {
            output+= "(Junior)";
        } else if (creditsCompleted < 120) {
            output+= "(Senior)";
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student student = (Student) o;
            if (this.profile.equals(student.profile)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int compareTo(Student student) {
        if (student.equals(this)) {
            return 0;
        } else {
            return student.profile.compareTo(this.profile);
        }
    }

    //getter methods
    public Profile getProfile() {
        return profile;
    }
    public Major getMajor() {
        return major;
    }
    public int getCredits() {
        return creditsCompleted;
    }

    //setter methods
    public void setMajor (Major m) {
        major = m;
    }
}



