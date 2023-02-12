package project1;

import java.util.Scanner;

public class RosterManager {
    final static int ADD_COMMAND_SIZE = 6;
    final static int REMOVE_COMMAND_SIZE = 4;
    final static int PRINT_COMMAND_SIZE = 1;
    final static int CHANGE_MAJOR_COMMAND_SIZE = 4;
    //creates a student class given a list of inputs
    public Student setStudent(String[] inputStringList) {
        if(inputStringList.length == ADD_COMMAND_SIZE) {
            Major tempMajor;
            int credits = 0;
            Date dob = null;
            //determine major
            tempMajor = Major.setMajor(inputStringList[4]);
            //tests credits
            try {
                credits = Integer.parseInt(inputStringList[5]);
            } catch (NumberFormatException nfe) {
                System.out.println("improper credits amount");
                return null;
            }
            if (credits < 0) {
                System.out.println("improper credits amount");
                return null;
            }
            dob = new Date(inputStringList[3]);
            if (!dob.isValid()) {
                System.out.println("invalid Date of Birth");
                return null;
            }
            Student output = new Student(new Profile(inputStringList[2], inputStringList[1], dob),
                    tempMajor, credits);
        } else if(inputStringList == REMOVE_COMMAND_SIZE) {
            Date dob = new Date(inputStringList[3]);
            Profile currentStudentProfile = new Profile(inputStringList[2], inputStringList[1], dob);
            output = new Student(currentStudentProfile);
        }
        return output;

    }

    public static void main(String args[]) {
        Roster roster = new Roster();
        boolean exited = false;
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println("Roster Manager running...");
        while (!exited) {
            input = sc.nextLine();
            String[] inputStringList = input.split("\\s+");
            //list of potential inputs
            switch (inputStringList[0]) {
                case "A": // add student
                    if (inputStringList.length == ADD_COMMAND_SIZE) {
                        Student student = setStudent(inputStringList)
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
                    //make a profile with the string
                    //then compare profile to all other students in roster
                    //if student matches use record and use in remove function
                    if(inputStringList.length == REMOVE_COMMAND_SIZE) {


                        Student currentStudent = new Student(currentStudentProfile);

                        roster.remove(currentStudent);
                    } else {
                        System.out.println("improper command format");
                        continue;
                    }

                    break;
                case "P":
                    if(inputStringList.length == PRINT_COMMAND_SIZE) {
                        roster.print();
                    }else{
                        System.out.println("improper command format");
                        continue;
                    }
                    break;
                case "PS":
                    break;
                case "PC":
                    break;
                case "L":
                    break;
                case "C":
                    if (inputStringList.length == CHANGE_MAJOR_COMMAND_SIZE) {
                        Date dob = new Date(inputStringList[3]);
                        Profile currentStudentProfile = new Profile(inputStringList[2], inputStringList[1], dob);
                        String newMajor = inputStringList[4];
                        Student currentStudent = new Student(currentStudentProfile);
                        private int size = 4;
                        for(int i = 0; i < size; i++){
                            if(this.roster[i] != null && this.roster[i].equals(student)) {
                                roster[i].setMajor(newMajor);
                            }
                        }
                        //Major.setMajor(newMajor);
                    }else{
                        System.out.println("improper command format");
                        continue;
                    }

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
