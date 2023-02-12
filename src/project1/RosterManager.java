package project1;

import java.util.Scanner;

public class RosterManager {
    final static int ADD_COMMAND_SIZE = 6;
    final static int REMOVE_COMMAND_SIZE = 4;

    public static void main(String args[]) {
        Roster roster = new Roster();
        boolean exited = false;
        Scanner sc = new Scanner(System.in);
        String input = "";
        //loops inputs until quits
        while (!exited) {
            //A first name last name dob major credits

            input = sc.nextLine();
            String[] inputStringList = input.split("\\s+");
            //list of potential inputs
            switch (inputStringList[0]) {
                case "A": // add student

                    if (inputStringList.length == ADD_COMMAND_SIZE) {
                        Major tempMajor;
                        int credits = 0;
                        Date dob = null;
                        //determine major
                        switch (inputStringList[4]) {
                            case "CS":
                                tempMajor = Major.CS;
                                break;
                            case "MATH":
                                tempMajor = Major.MATH;
                                break;
                            case "EE":
                                tempMajor = Major.EE;
                                break;
                            case "ITI":
                                tempMajor = Major.ITI;
                                break;
                            case "BAIT":
                                tempMajor = Major.BAIT;
                                break;
                            default:
                                System.out.println("Major does not exist");
                                continue;

                        }
                        //tests credits
                        try {
                            credits = Integer.parseInt(inputStringList[5]);
                        } catch (NumberFormatException nfe) {
                            System.out.println("improper credits amount");
                            continue;
                        }
                        if (credits < 0) {
                            System.out.println("improper credits amount");
                            continue;
                        }
                        dob = new Date(inputStringList[3]);
                        if (!dob.isValid()) {
                            System.out.println("invalid Date of Birth");
                            continue;
                        }

                        Student student = new Student(new Profile(inputStringList[2], inputStringList[1], dob),
                                tempMajor, credits);
                        if (!roster.contains(student)) {
                            roster.add(student);
                        } else {
                            System.out.println("Roster already contains student");
                        }
                    } else {
                        System.out.println("improper command");
                        continue;
                    }
                    break;
                case "R": //remove
                    //[0]R [1]fn [2]ln [3]dob
                    // A fgh jkl 1/1/2000 CS 50
                    // R fgh jkl 1/1/2000
                    //make a profile with the string
                    //then compare profile to all other students in roster
                    //if student matches use record and use in remove function
                    if(inputStringList.length == REMOVE_COMMAND_SIZE) {
                        Date dob = new Date(inputStringList[3]);
                        Profile currentStudentProfile = new Profile(inputStringList[2], inputStringList[1], dob);

                        Student currentStudent = new Student(currentStudentProfile);

                        roster.remove(currentStudent);
                    } else {
                        System.out.println("improper command format");
                        continue;
                    }

                    break;
                case "P":
                    break;
                case "PS":
                    break;
                case "PC":
                    break;
                case "L":
                    break;
                case "C":
                    break;
                case "Q":
                    exited = true;
                    break;
                default:
                    System.out.println("unrecognized command");
                    continue;

            }

        }
    }

}
