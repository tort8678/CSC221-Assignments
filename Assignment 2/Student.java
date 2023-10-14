import java.util.ArrayList;

public class Student {
    //variables
    private String name;
    private int rollNumber;
    private ArrayList<Integer> marks;

    //constructors
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

    //methods
    public void printInfo(){
        System.out.println("Name: "+name);
        System.out.println("Roll Number: "+rollNumber);
        System.out.print("Marks: [");
        for(int i =0; i< marks.size();i++){
            if(i != marks.size()-1) System.out.print(marks.get(i) + ", ");
            else System.out.print(marks.get(i) + "]\n");
        }
        System.out.println("Average Marks: "+ calculateAverageMarks());
    }
    public String toCSV(){
        String csv=name+","+rollNumber;
        for(int i=0; i<marks.size();i++) csv+=","+marks.get(i);
        return csv;
    }

    //getters and setters
    public void addMark(int mark){
        marks.add(mark);
    }
    public int getRollNumber() {return rollNumber;}
    public void setName(String n) {name = n;}
    public void setRollNumber(int n){rollNumber = n;}
    public void setMarks(ArrayList<Integer> m){marks =m;}
    public double calculateAverageMarks(){
        double average = 0.0;
        for(int i=0; i<marks.size();i++){
            average+=marks.get(i);
        }
        average/=marks.size();
        return average;
    }

}
