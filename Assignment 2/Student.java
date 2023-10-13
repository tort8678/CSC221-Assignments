import java.util.ArrayList;

public class Student {
private String name;
private int rollNumber;
private ArrayList<Integer> marks;


public Student(){
    name = "";
    rollNumber=0;
    marks = new ArrayList<Integer>();
}

public Student(String n, int roll, ArrayList<Integer> m){
    name = n;
    rollNumber = roll;
    marks = m;
}
public void printInfo(){
    System.out.println("Name: "+name);
    System.out.println("Roll Number: "+rollNumber);
    System.out.println("Marks:");
    for(int i =0; i< marks.size();i++){
        System.out.println(marks.get(i));
    }
}
public void addMarks(int mark){
    marks.add(mark);
}
public int getRollNumber() {return rollNumber;}

}
