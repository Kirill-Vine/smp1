package project1;

/**
 This class handles all of the methods used to print and adjust the student roster

 @author Michael Burton
 @author Kiril Vine
 */

public class Roster {
    private Student[] roster = new Student[4];
    private int size = 4;

    final static int CHANGE_MAJOR_COMMAND_SIZE = 4;
    
    final static int GROWTH_INTERVAL = 4;

    /**
    Sorts the student profiles based lexographically and based on date of birth
     */
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

    /**
    Determine whether a roster is empty.
    @return true if the roster has no students, false if otherwise.
     */
    private boolean isEmpty() {
        for (int i = 0; i < this.roster.length; i++) {
            if (this.roster[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
    Tests whether the roster contains a student.
    @param student the student to be checked whether it's in the roster.
    @return true if student is in the roster, and false if otherwise.
     */
    public boolean contains(Student student) {
        for (int i = 0; i < size; i++) {
            if (roster[i] != null && student.equals(roster[i])) {
                return true;
            }
        }
        return false;
    }
    
    /**
    find the index of a given student in the roster
    @param student the student whose index is to be found
    @return index of the student in the roster, -1 if the student is not in the roster.
     */
    private int find(Student student) {
        if (contains(student)) {
            for (int i = 0; i < size; i++) {
                if (student.equals(roster[i])) {
                    return i;
                }
            }
        }
        System.out.println("Student not in Roster");
        return -1;
    }

    /**
    Increases the size of the roster array by the GROWTH_INTERVAL.
     */
    private void grow() {
        Student[] tempList = new Student[size];
        for (int i = 0; i < size; i++) {
            tempList[i] = roster[i];
        }
        size += GROWTH_INTERVAL;
        roster = new Student[size];
        for (int i = 0; i < size - GROWTH_INTERVAL; i++) {
            roster[i] = tempList[i];

        }
    }

    /**
    Add a student to the roster.
    @param student student to be added to the roster
    @return return true if the student was successfully added to the roster.
     */
    public boolean add(Student student) {
        if (!contains(student)) {
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
            return false;
        } else {
            System.out.println("student is already in list");
            return false;
        }

    }

    /**
    remove a given student from the roster.
    @param student student to be removed from the roster.
    @return true if the student has been removed from the roster, false if otherwise.
     */
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
    }

    /**
    change a student's major
    @param student student whose major should be staged.
    @param newMajor String that represents the string.
     */
    public void changeMajor(Student student, String newMajor) {
        Major tempMajor;
        if (student == null) {
            System.out.println("student is null");
        }
        int index = find(student);
        if (index != -1) {
            tempMajor = Major.stringToMajor(newMajor);
            if (tempMajor != null) {
                roster[index].setMajor(Major.stringToMajor(newMajor));
            }
        }
    }

    /**
    Print all students in the roster of a given major.
    @param major Major that each student should be printed from.
     */
    public void printAllStudentsInMajor(Major major) {
        System.out.println("**Roster for all " + major.toString() + " majors**");
        for (int i = 0; i < size; i++) {
            if (roster[i] != null && roster[i].getMajor().equals(major)) {
                System.out.println(roster[i].toString());
            }
        }
        System.out.println("** Roster End  **");
    }

    /**
    Print the students in the roster sorted lexographically by last name, first name and date of birth.
     */
    public void print() {
        sortStudentProfiles();
        for (int i = 0; i < size; i++) {
            if (roster[i] != null) {
                System.out.println(roster[i].toString());
            }
        }
    }

    /**
    Print the each student in the roster, sorted by standing.
     */
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


    /**
    print every student in the roster sorted by major.
     */
    public void printBySchoolMajor() {
        System.out.println("** Roster sorted by school, major **");
        String [] listOfMajors = {"BAIT", "CS", "MATH", "ITI", "EE"};
        for (int i = 0; i < listOfMajors.length; i++) {
            printAllStudentsInMajor(Major.stringToMajor(listOfMajors[i]));
        }
        System.out.println("**Roster end**");
    }

}
