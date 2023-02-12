package project1;

import java.util.Scanner;

public class RosterManager {
    final static int ADD_COMMAND_SIZE = 6;
    final static int REMOVE_COMMAND_SIZE = 4;
    final static int PRINT_COMMAND_SIZE = 1;
    final static int CHANGE_MAJOR_COMMAND_SIZE = 4;
    
    //creates a student class given a list of inputs
    public static Student setStudent(String[] inputStringList) {
        Student output = null;
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
            output = new Student(new Profile(inputStringList[2], inputStringList[1], dob), tempMajor, credits);

        } else if(inputStringList.length == REMOVE_COMMAND_SIZE) {
            Date dob = new Date(inputStringList[3]);
            Profile currentStudentProfile = new Profile(inputStringList[2], inputStringList[1], dob);
            output = new Student(currentStudentProfile);
        } else {
            System.out.println("improper command");
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
                    Student student = RosterManager.setStudent(inputStringList);
                    roster.add(student);
                    break;
                case "R": //remove
                    Student currentStudent = RosterManager.setStudent(inputStringList);
                    roster.remove(currentStudent);
                    break;
                case "P":
                    roster.print();
                    break;
                case "PS":
                    break;
                case "PC":
                    break;
                case "L":
                    break;
                case "C":
                    /*if (inputStringList.length == CHANGE_MAJOR_COMMAND_SIZE) {
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

                    break;*/
                case "Q":
                    exited = true;
                    break;
                default:
                    System.out.println(inputStringList[0] + " is an invalid command");
                    continue;
            }
        }
    }

}
