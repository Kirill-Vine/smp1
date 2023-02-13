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
    private int find(Student student) {
        if(contains(student)) {
            for (int i = 0; i < size; i++) {
                if (student.equals(roster[i])) {
                    return i;
                }
            }
        } else {
            return -1;
        }
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
        if(student == null) {
            System.out.println("student is null");
        }
        roster[find(student)].setMajor(Major.stringToMajor(newMajor));

    }
    public boolean contains(Student student) {
        for(int i = 0; i < size; i++) {
            if(roster[i]!= null && student.equals(roster[i])) {
                return true;
            }
        }
        return false;
    } //if the student is in roster


    public void print () {
        sortStudentProfiles();
        for(int i = 0 ; i < size; i++) {
            if(roster[i] != null) {
                System.out.println(roster[i].toString());
            } else {
                System.out.println("null");
            }
        }
    }
    public void printAllStudentsInMajor(Major m) {
        System.out.println("*Roster for all " + m.toString() + " majors");
        for(int i = 0; i < size; i++) {
            if(roster[i] != null && roster[i].getMajor().equals(m)) {
                System.out.println(roster[i].toString());
            }
        }
        System.out.println("*");
    }


    //print roster sorted by profiles
    public void printBySchoolMajor() {
        String [] listOfMajors = {"BAIT", "CS", "MATH", "ITI", "EE"};
        Student [] newRoster = this.roster;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(roster[i] == null) {
                continue;
            }
            System.out.println(this.roster[i].getMajor());
            if (this.roster[i].getMajor().equals(Major.stringToMajor(listOfMajors[0]))) {
                //System.out.print(roster[i].getMajor());
                newRoster[count]=this.roster[i];
                count+=1;
            }
        }
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            if(roster[i] == null) {
                continue;
            }
            System.out.println(this.roster[i].getMajor());
            if (this.roster[i].getMajor().equals(Major.stringToMajor(listOfMajors[1]))) {
                //System.out.print(roster[i].getMajor());
                newRoster[count]=this.roster[i];
                count+=1;
            }
        }
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            if(roster[i] == null) {
                continue;
            }
            System.out.println(this.roster[i].getMajor());
            if (this.roster[i].getMajor().equals(Major.stringToMajor(listOfMajors[2]))) {
                //System.out.print(roster[i].getMajor());
                newRoster[count]=this.roster[i];
                count+=1;
            }
        }
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            if(roster[i] == null) {
                continue;
            }
            System.out.println(this.roster[i].getMajor());
            if (this.roster[i].getMajor().equals(Major.stringToMajor(listOfMajors[3]))) {

                newRoster[count]=this.roster[i];
                count+=1;
            }
        }
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            if(roster[i] == null) {
                continue;
            }
            System.out.println(this.roster[i].getMajor());
            if (this.roster[i].getMajor().equals(Major.stringToMajor(listOfMajors[4]))) {
                //System.out.print(roster[i].getMajor());
                newRoster[count]=this.roster[i];
                count+=1;
            }
        }

        //print
        for(int i = 0 ; i < size; i++) {
            if(newRoster[i] != null) {
                System.out.println(newRoster[i].toString());
            }
        }
    } //print roster sorted by school major

//    public void printByStanding() {
//        int minIndex;
//        for(int i = 0; i < size; i++) {
//            if(roster[i] == null) {
//                continue;
//            }
//            minIndex = Integer.MAX_VALUE;
//            for(int j = i; j < size; j++) {
//                if(roster[j] == null) {
//                    continue;
//                }
//                if (roster[j] < minIndex) {
//                    minIndex = j;
//                }
//            }
//            Student temp = roster[i];
//            roster[i] = roster[minIndex];
//            roster[j] = temp;
//        }
//        for(int i = 0 ; i < size;i ++) {
//            if(roster[i] != null) {
//                System.out.println(roster[i].toString());
//            }
//        }
//    } //print roster sorted by standing

}
