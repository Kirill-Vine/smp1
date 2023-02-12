package project1;

public class Roster {
    private Student[] roster = new Student[4];
    private int size = 4;

    private void sortStudentProfiles() {


        for (int i = 0; i < size-1; i++){
            int min_idx = i;
            for (int j = i+1; j < size; j++) {
                if (this.roster[j].compareTo(this.roster[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            int temp = this.roster[min_idx];
            this.roster[min_idx] = this.roster[i];
            this.roster[i] = temp;
        }
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
                    print();
                    return true;
                }
            }
            print();
            return true;
        } else {
            System.out.println("student is already in list");
            return false;
        }

    } //add student to end of array

    public boolean remove(Student student) {
        for(int i = 0; i < size; i++){
            if(this.roster[i] != null && this.roster[i].equals(student)){
                roster[i]=null;
                return true;
            }
        }
        print();
        return true;
    }//maintain the order after remove

    public boolean contains(Student student) {
        for(int i = 0; i < size; i++) {
            if(roster[i]!= null && student.equals(roster[i])) {
                return true;
            }
        }
        return false;
    } //if the student is in roster
    public void print () {
        for(int i = 0 ; i< size; i++) {
            if(roster[i]!= null) {
                System.out.println(roster[i].toString());
            } else {
                System.out.println("null");
            }
        }
    } //print roster sorted by profiles
    public void printBySchoolMajor() {} //print roster sorted by school major

    public void printByStanding() {
    } //print roster sorted by standing

}
