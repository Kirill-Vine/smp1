package project1;

public class Roster {
    private Student[] roster = new Student[4];
    private int size = 4;

    private int find(Student student) {
        return 0;
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
        if (this.roster[this.size - 1] != null) {
            this.grow();
        }
        //goes through whole thing array and adds student to the end
        for (int i = 0; i < size; i++) {
            if (this.roster[i] != null) {
                this.roster[i] = student;
                return true;
            }
        }
        return true;

    } //add student to end of array

    public boolean remove(Student student) {
        return true;
    }//maintain the order after remove

    public boolean contains(Student student) {
        return true;
    } //if the student is in roster
    public void print () {} //print roster sorted by profiles
    public void printBySchoolMajor() {} //print roster sorted by school major

    public void printByStanding() {
    } //print roster sorted by standing
    
}
