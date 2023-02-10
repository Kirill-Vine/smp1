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


    @Override
    public String toString() {
        return profile.toString() + " " + major.getMajor() + " " + major.getSchool() + " " +  major.getClassCode() + " " + creditsCompleted;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student student = (Student) o;
            if (this.profile.equals(student.profile) && this.creditsCompleted == student.creditsCompleted
                    && this.major == student.major) {
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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String inputList[] = input.split("\\s+");
        //sets major depending on string
        Major majorInput = null;
        switch (inputList[3]) {
            case "EE":
                majorInput = Major.EE;
                break;
            case "CS":
                majorInput = Major.CS;
                break;
            case "MATH":
                majorInput = Major.MATH;
                break;
            case "ITI":
                majorInput = Major.ITI;
                break;
            case "BAIT":
                majorInput = Major.BAIT;
                break;


        }
        Student test = new Student(new Profile(inputList[0], inputList[1], new Date(inputList[2])), majorInput,
                Integer.parseInt(inputList[4]));
        System.out.println(test.toString());
    }
}



