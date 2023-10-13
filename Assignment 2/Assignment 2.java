import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class InvalidInputException extends Exception{
    InvalidInputException(){}

    InvalidInputException(String message){
        super(message);
    }

}

class Main{
    public static ArrayList<Student> readFile(){
        ArrayList<Student> students = new ArrayList<Student>();
        try{
            File create = new File("students.txt");
            create.createNewFile();
            if(!create.createNewFile()){
                Scanner inFile = new Scanner(new File("students.txt"));
                ArrayList<Integer> marks = new ArrayList<Integer>();
                while(inFile.hasNextLine()){
                    String parse = inFile.nextLine();
                    String[] info = parse.split(",");
                    for(int i = 2; i< info.length;i++){
                        marks.add(Integer.parseInt(info[i]));
                    }
                    students.add(new Student(info[0],Integer.parseInt(info[1]),marks));
                }
          }

            return students;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return students;
    }

    static boolean rollNumberExists(int num, ArrayList<Student> students){
        if(students.size()==0) return false;
        else{
            for(int i =0; i<students.size(); i++){
                if(students.get(i).getRollNumber()==num) return true;
            }
            return false;
        }
    }

    static ArrayList<Integer> parseMarks(String parse){
        String[] info = parse.split(",");
        ArrayList<Integer> marks = new ArrayList<Integer>();
        try{
            for(int i =0; i<info.length;i++){
                marks.add(Integer.parseInt(info[i]));
            }
        
        }
        catch(Exception ex){
            System.out.println("Marks not in correct format! Please try again.");
        }
        return marks;
    }
    public static void main(String args[]) throws InvalidInputException{
        // System.out.println("hi");
        // int[] ar = new int[]{85,100};
        // Student s = new Student("Tyler",1,ar);
        // s.printInfo();
        int choice=-1;
        Scanner in = new Scanner(System.in);
        ArrayList<Student> students = readFile();
        for(int i =0; i< students.size();i++){
            students.get(i).printInfo();
        }
        System.out.println("Input one the following numbers to access that option.\n");
        while(choice != 0){
            System.out.println("Menu Options");
            String menu = "1. Add a student record.\n2. View all student records.\n" +
                          "3. Find a student by roll number.\n4. Edit an existing student by roll number.\n"+
                          "5. Delete a student by roll number.\n0. Exit the menu.";
            System.out.println(menu);
            choice = in.nextInt();
            in.nextLine();
            if(choice == 1){
                System.out.println("Create a student\nInput the student's name: ");
                try{
                    String name = in.nextLine();
                    if(name.length()==0){
                        throw new InvalidInputException("Empty student name!");
                    }
                    boolean escape = false;
                    while(escape==false){
                        System.out.println("Input the student's roll number");
                        int number = in.nextInt();
                        if(rollNumberExists(number,students)){
                            System.out.println("Roll number is already in the list! Choose a different number");
                        }
                        else escape = true;
                    }
                    in.nextLine();
                    escape = false;
                    System.out.println("Input all marks earned by student seperated by commas (I.E. 82,34,100)");
                    String marksRaw = in.nextLine();
                    ArrayList<Integer> marks = new ArrayList<Integer>();
                    while(escape == false) {
                        marks = parseMarks(marksRaw);
                        if(marks.size()>0) escape = true;
                    }
                    students.add(new Student(name, choice, marks));
                }
                catch(InvalidInputException ex){

                }
            }
                else if (choice == 2){
                    System.out.println("menu");
                    in.nextLine();
                }
                else if (choice ==3){
                    System.out.println("menu");
                    in.nextLine();

                }
                else if (choice ==4){
                    System.out.println("menu");
                    in.nextLine();
                }
                else if(choice == 5){
                    System.out.println("menu");
                    in.nextLine();
                }
                else if (choice == 0){
                    System.out.println("Exiting...");
                    in.nextLine();
                }
                else{
                    System.out.println("Invalid option! Please input one of the numbers in the menu.");
                }
        }

    }
}


