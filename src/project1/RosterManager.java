package project1;

import java.util.Scanner;

public class RosterManager {

    public static void main(String args[]) {
        Roster roster = new Roster();
        boolean exited = false;
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (!exited) {
            final int ADD_COMMAND_SIZE = 6;
            input = sc.nextLine();
            String[] inputStringList = input.split("\\s+");
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
                case "R":
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
