package project1;

public class Roster {
    private Student[] roster = new Student[4];
    private int size = 4;

    final static int CHANGE_MAJOR_COMMAND_SIZE = 4;

    private void sortStudentProfiles() { //sort by lname, fname, dob
        for (int i = 0; i < size - 1; i++) {
            int currentMinimum = i;
            if (roster[i] == null) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                if (roster[j] == null) {
                    continue;
                }
                if (this.roster[j].compareTo(this.roster[currentMinimum]) > 0) {
                    currentMinimum = j;
                }
            }
            Student temp = this.roster[currentMinimum];
            this.roster[currentMinimum] = this.roster[i];
            this.roster[i] = temp;
        }
    }

    private boolean isEmpty() {
        for (int i = 0; i < this.roster.length; i++) {
            if (this.roster[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Student student) {
        for(int i = 0; i < size; i++) {
            if(roster[i]!= null && student.equals(roster[i])) {
                return true;
            }
        }
        return false;
    }
    
    private int find(Student student) {
        if(contains(student)) {
            for (int i = 0; i < size; i++) {
                if (student.equals(roster[i])) {
                    return i;
                }
            }
        } 
        System.out.println("Student not in Roster");
        return -1;
    } //search the given student in roster

    private void grow() {
        final int GROWTH_INTERVAL = 4;
        Student[] tempList = new Student[size];
        for (int i = 0; i < size; i++) {
            tempList[i] = roster[i];
        }
        size += GROWTH_INTERVAL;
        roster = new Student[size];
        for (int i = 0; i < size-GROWTH_INTERVAL; i++) {
            roster[i] = tempList[i];
            
        }
    } //increase the array capacity by 4

    public boolean add(Student student) {
        if(!contains(student)) {
            if (this.roster[this.size - 1] != null) {
                this.grow();
            }
            //goes through whole thing array and adds student to the end
            for (int i = 0; i < this.size; i++) {
                if (this.roster[i] == null) {
                    this.roster[i] = student;
                    return true;
                }
            }
            return true;
        } else {
            System.out.println("student is already in list");
            return false;
        }

    } //add student to end of array

    public boolean remove(Student student) {
        if (!this.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (this.roster[i] != null && this.roster[i].equals(student)) {
                    roster[i] = null;
                    System.out.println("Student has been removed");
                    return true;
                }
            }
            System.out.println("Student is not in roster");
            return false;
        } else {
            System.out.println("Roster is empty!");
            return false;
        }
    }//maintain the order after remove

    public void changeMajor(Student student, String newMajor){
        if (student == null) {
            System.out.println("student is null");
        }
        int index = find(student);
        if (index != -1) {
            roster[index].setMajor(Major.stringToMajor(newMajor));
        }

    }
     //if the student is in roster


    public void print() {
        sortStudentProfiles();
        for (int i = 0; i < size; i++) {
            if (roster[i] != null) {
                System.out.println(roster[i].toString());
            }
        }
    }

    public void printAllStudentsInMajor(Major m) {
        System.out.println("**Roster for all " + m.toString() + " majors**");
        for (int i = 0; i < size; i++) {
            if (roster[i] != null && roster[i].getMajor().equals(m)) {
                System.out.println(roster[i].toString());
            }
        }
        System.out.println("** Roster End  **");
    }

    public void printByStanding() {
        System.out.println("** Roster sorted by standing **");
        int minimum;
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            minimum = Integer.MAX_VALUE;
            for (int j = i; j < size; j++) {
                if (roster[j] != null && roster[j].getCredits() < minimum) {
                    minimum = roster[j].getCredits();
                    minIndex = j;
                }
            }
            Student temp = roster[i];
            roster[i] = roster[minIndex];
            roster[minIndex] = temp;
        }
        for (int i = 0; i < size; i++) {
            if (roster[i] != null) {
                System.out.println(roster[i]);
            }
        }
        System.out.println("** Roster End ** ");
    }


    //print roster sorted by profiles
    public void printBySchoolMajor() {
        System.out.println("** Roster sorted by school, major **");
        String [] listOfMajors = {"BAIT", "CS", "MATH", "ITI", "EE"};
        for (int i = 0; i < listOfMajors.length; i++) {
            for (int j = 0; j < size; j++) {
                if (roster[j] != null && roster[j].getMajor().equals(Major.stringToMajor(listOfMajors[i]))) {
                    System.out.println(roster[j].toString());
                }
            }
        }
        System.out.println("**Roster end**");
    }

}
