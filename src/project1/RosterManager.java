package project1;

import java.util.Scanner;

public class RosterManager {
    final static int ADD_COMMAND_SIZE = 6;
    final static int REMOVE_COMMAND_SIZE = 4;
    final static int PRINT_COMMAND_SIZE = 1;
    final static int CHANGE_MAJOR_COMMAND_SIZE = 5;
    final static int MIN_AGE = 16;

    //creates a student class given a list of inputs
    public static Student setStudent(String[] inputStringList) {
        Student output = null;
        if(inputStringList.length == ADD_COMMAND_SIZE) {
            Major tempMajor;
            int credits = 0;
            Date dob = null;
            Date today = new Date();
            //determine major
            tempMajor = Major.stringToMajor(inputStringList[4]);
            if (tempMajor == null) {
                return null;
            }
            //tests credits
            try {
                credits = Integer.parseInt(inputStringList[5]);
            } catch (NumberFormatException nfe) {
                System.out.println("credits must be an integer");
                return null;
            }
            if (credits < 0) {
                System.out.println("credits must be a positive number");
                return null;
            }
            dob = new Date(inputStringList[3]);
            if (!dob.isValid()) {
                System.out.print("DOB Invalid: ");
                System.out.println(inputStringList[3] + " is not a calendar date!");
                return null;
            }
            if(today.compareTo(dob) < MIN_AGE) {
                System.out.print("DOB Invalid: ");
                System.out.println(inputStringList[3] + " is younger than 16");
            }
            output = new Student(new Profile(inputStringList[2], inputStringList[1], dob), tempMajor, credits);

        } else if(inputStringList.length == REMOVE_COMMAND_SIZE || inputStringList.length == CHANGE_MAJOR_COMMAND_SIZE) {
            Date dob = new Date(inputStringList[3]);
            Profile currentStudentProfile = new Profile(inputStringList[2], inputStringList[1], dob);
            output = new Student(currentStudentProfile);
        }else {
            System.out.println("improper command");
        }
        return output;

    }

    public static void main(String args[]) {
        Roster roster = new Roster();
        boolean exited = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Roster Manager running...");
        while (!exited) {
            String input = sc.nextLine();
            String[] inputStringList = input.split("\\s+");
            switch (inputStringList[0]) {
                case "A": // add newStudent
                    roster.add(RosterManager.setStudent(inputStringList));
                    break;
                case "R": //remove
                    roster.remove(RosterManager.setStudent(inputStringList));
                    break;
                case "P":
                    roster.print();
                    break;
                case "PS":
                    roster.printByStanding();
                    break;
                case "PC":
                    roster.printBySchoolMajor();
                    /*
A April Doe 1/20/2003 EE 105
A Jane Doe 5/1/1996 CS 30
A April March 3/31/2000 BAIT 109
A Kate Lindsey 7/15/2002 ITI 59
A Paul Siegel 5/15/2000 MATH 90
A Hkjn Siegel 5/12/2002 CS 90
A Paul Jufhei 3/11/2000 ITI 90
A Yjnk Siegel 5/1/2000 EE 90
A Paul Ij 7/1/2000 MATH 90
PC
                     */
                    break;
                case "L":
                    roster.printAllStudentsInMajor(Major.stringToMajor(inputStringList[1]));
                    break;
                case "C":
                    roster.changeMajor(RosterManager.setStudent(inputStringList), inputStringList[4]);
                    break;
                case "Q":
                    System.out.println("Closing Roster...");
                    exited = true;
                    break;
                default:
                    System.out.println(inputStringList[0] + " is an invalid command");
                    continue;
            }
        }
    }

}
