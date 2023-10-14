import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

class InvalidInputException extends Exception {
    InvalidInputException() {
    }

    InvalidInputException(String message) {
        super(message);
    }
}

public class Assignment_2 {
    /*
     * Functions in main:
     * readFile - returns an arrayList of students found within the file
     * students.txt
     * returnIndex = returns the index in the students array that has a matching
     * roll number, -1 if not found
     * parseMarks - receive input string from user and parse it for
     * findStudent - find and return with matching roll number from students array
     * deleteStudent - delete student with matching roll number from students array
     * main - main menu loop. allows user to pick between 6 options
     * 1. Add a student record.
     * 2. View all student records.
     * 3. Find a student by roll number.
     * 4. Edit an existing student by roll number.
     * 5. Delete a student by roll number.
     * 0. Save and exit the menu.
     */

    // read through existing file if it exists and populate an arraylist of items in
    // the file
    // create file if it does not exist and return empty arraylist
    public static ArrayList<Student> readFile() {
        ArrayList<Student> students = new ArrayList<Student>();
        // try to create a file, if not read the existing file
        try {
            File create = new File("students.txt");
            create.createNewFile();
            if (!create.createNewFile()) {
                Scanner inFile = new Scanner(new File("students.txt"));
                // read the whole line, then split it up by the commas.

                while (inFile.hasNextLine()) {
                    String parse = inFile.nextLine();
                    // split each line of the file into
                    String[] info = parse.split(",");
                    ArrayList<Integer> marks = new ArrayList<Integer>();
                    // first two strings are the name and roll number, so skip those
                    for (int i = 2; i < info.length; i++) {
                        marks.add(Integer.parseInt(info[i]));
                    }
                    students.add(new Student(info[0], Integer.parseInt(info[1]), marks));
                }
            }
            return students;
        }
        // catch error reading file
        catch (Exception e) {
            System.out.println("Cannot read file!");
        }
        return students;
    }

    // check if the roll number already exists in the list of students and return
    // the index where the roll number occurred
    static int returnIndex(int num, ArrayList<Student> students) {
        if (students.size() == 0)
            return -1;
        else {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getRollNumber() == num)
                    return i;
            }
            return -1;
        }
    }

    // parse through user input in the form of integers delimted by commas
    static ArrayList<Integer> parseMarks(String parse) {
        String[] info = parse.split(",");
        ArrayList<Integer> marks = new ArrayList<Integer>();
        // catch error in parseInt
        try {
            for (int i = 0; i < info.length; i++) {
                int mark = Integer.parseInt(info[i]);
                if (mark >= 0 && mark <= 100)
                    marks.add(mark);
            }
        } catch (Exception ex) {
            System.out.println("Marks not in correct format! Please try again.");
        }
        if (marks.size() == info.length)
            return marks;
        else {
            marks.clear();
            return marks;
        }
    }

    // find and return the student by roll number
    static Student findStudent(int num, ArrayList<Student> students) throws InvalidInputException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == num)
                return students.get(i);
        }
        throw new InvalidInputException("Student with roll number " + num + " does not exist!");
    }

    // delete a student from the students list by roll number
    static void deleteStudent(int num, ArrayList<Student> students) throws InvalidInputException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == num) {
                students.remove(i);
                return;
            }
        }
        throw new InvalidInputException("Student with roll number " + num + " does not exist!");
    }

    public static void main(String args[]) throws InvalidInputException {
        int choice = -1;
        Scanner in = new Scanner(System.in);
        ArrayList<Student> students = readFile();
        System.out.println("Input one the following numbers to access that option.\n");
        while (choice != 0) {
            System.out.println("Menu Options");
            String menu = "1. Add a student record.\n2. View all student records.\n" +
                    "3. Find a student by roll number.\n4. Edit an existing student by roll number.\n" +
                    "5. Delete a student by roll number.\n0. Save and exit the menu.";
            System.out.println(menu);
            // catch if next input is not an int
            try {
                choice = in.nextInt();
            } catch (InputMismatchException e) {
            }
            in.nextLine();
            // add student
            if (choice == 1) {
                System.out.println("Create a student\nInput the student's name: ");

                boolean escape = false;
                String name = "";
                while (escape == false) {
                    name = in.nextLine();
                    name = name.trim();
                    if (name.length() > 0)
                        escape = true;
                    else
                        System.out.println("Name must have at least one character!");
                }
                escape = false;
                int number = 0;
                while (escape == false) {
                    System.out.println("Input the student's roll number");
                    // catch if next input is not an int
                    try {
                        number = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be a postive number");
                        in.nextLine();
                    }
                    if (returnIndex(number, students) > -1) {
                        System.out.println("Roll number is already in the list! Choose a different number");
                    } else if (number > 0)
                        escape = true;
                }
                in.nextLine();
                escape = false;
                System.out.println("Input all marks earned by student seperated by commas (I.E. 82,34,100)");
                ArrayList<Integer> marks = new ArrayList<Integer>();
                while (escape == false) {
                    String marksRaw = in.nextLine();
                    marks = parseMarks(marksRaw);
                    if (marks.size() > 0)
                        escape = true;
                    else
                        System.out.println("Each mark must be between 0 and 100 inclusive");
                }
                students.add(new Student(name, number, marks));

            } else if (choice == 2) {
                System.out.println();
                for (int i = 0; i < students.size(); i++) {
                    students.get(i).printInfo();
                    System.out.println();
                }
                System.out.println("Press enter to continue...");
                in.nextLine();
            }
            // print info of one student
            else if (choice == 3) {

                boolean escape = false;
                int number = 0;
                while (escape == false) {
                    System.out.println("Input student roll number you would like to see information on");
                    try {
                        number = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be a postive number");
                        in.nextLine();
                    }
                    if (number > 0)
                        escape = true;
                }
                try {
                    System.out.println();
                    Student found = findStudent(number, students);
                    found.printInfo();
                    System.out.println();
                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
                in.nextLine();
                System.out.println("Press enter to continue...");
                in.nextLine();

            }
            // Edit student info: change name, change number, add one mark, change all marks
            else if (choice == 4) {
                boolean escape = false;
                int number = 0;
                while (escape == false) {
                    System.out.println("Input student roll number you would like to alter");
                    try {
                        number = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be a postive number");
                        in.nextLine();
                    }
                    if (number > 0)
                        escape = true;
                }
                in.nextLine();
                int studentIndex = returnIndex(number, students);
                if (studentIndex > -1) {
                    int choice1 = -1;
                    escape = false;

                    while (escape == false) {
                        String submenu = "How would you like to edit this student?\n1. Change name.\n2. Change roll number.\n"
                                +
                                "3. Add a mark.\n4. Replace all marks.\n0. Exit submenu";
                        System.out.println(submenu);
                        boolean good = false;
                        try {
                            choice1 = in.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Input must be a postive number");
                            in.nextLine();
                        }
                        switch (choice1) {
                            // change student name
                            case 1:
                                System.out.println("Enter a new name for the student");
                                boolean empty = true;
                                String name = "";
                                while (empty) {
                                    name = in.nextLine();
                                    if (name.length() > 0)
                                        empty = false;
                                    else
                                        System.out.println("Name must have at least one character!");
                                }
                                students.get(studentIndex).setName(name);
                                System.out.println("Name changed!");
                                escape = true;
                                break;

                            // change student roll number
                            case 2:
                                number = 0;
                                while (good == false) {
                                    System.out.println("Enter a new roll number for the student");
                                    try {
                                        number = in.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Input must be a postive number");
                                        in.nextLine();
                                    }
                                    if (returnIndex(number, students) > -1) {
                                        System.out.println(
                                                "Roll number is already in the list! Choose a different number");
                                    } else if (number > 0)
                                        good = true;
                                }
                                in.nextLine();
                                students.get(studentIndex).setRollNumber(number);
                                System.out.println("Roll number changed!");
                                escape = true;
                                break;

                            // add 1 mark
                            case 3:
                                number = -1;
                                while (good == false) {
                                    System.out.println("Enter the mark you would like to add");
                                    try {
                                        number = in.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Input must be a number between 0 and 100");
                                        in.nextLine();
                                    }

                                    if (number >= 0 && number <= 100) {
                                        good = true;
                                    } else
                                        System.out.println("Input must be a number between 0 and 100");
                                }
                                in.nextLine();
                                students.get(studentIndex).addMark(number);
                                System.out.println("Added mark!");
                                escape = true;
                                break;
                            // replace all marks with new set
                            case 4:
                                System.out.println("Replace all marks for a student");
                                System.out.println(
                                        "Input all marks earned by student seperated by commas (I.E. 82,34,100)");
                                ArrayList<Integer> marks = new ArrayList<Integer>();
                                good = false;
                                while (good == false) {
                                    String marksRaw = in.nextLine();
                                    marks = parseMarks(marksRaw);
                                    if (marks.size() > 0)
                                        good = true;
                                    else
                                        System.out.println(
                                                "Each mark must be between 0 and 100 inclusive. Please try again");
                                }
                                students.get(studentIndex).setMarks(marks);
                                System.out.println("Marks replaced!");
                                escape = true;
                                break;

                            case 0:
                                escape = true;
                                System.out.println("Exiting submenu...");

                        }
                    }
                } else
                    System.out.println("Roll number does not exist in list!");
                System.out.println("Press enter to continue...");
                in.nextLine();
            }

            // delete
            else if (choice == 5) {
                boolean escape = false;
                int number = 0;
                while (escape == false) {
                    System.out.println("Input student's roll number you would like to delete");
                    try {
                        number = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be a postive number");
                        in.nextLine();
                    }
                    if (number > 0)
                        escape = true;
                }
                in.nextLine();

                try {
                    deleteStudent(number, students);
                    System.out.println("Delete Successful!");
                } catch (InvalidInputException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Press enter to continue...");
                in.nextLine();
            }
            // save and exit
            else if (choice == 0) {
                System.out.println("Exiting...");
                try {
                    PrintWriter pw = new PrintWriter("students.txt");
                    for (int i = 0; i < students.size(); i++) {
                        pw.println(students.get(i).toCSV());
                    }
                    pw.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found!");
                }

                in.close();
            } else {
                System.out.println("Invalid option! Please input one of the numbers in the menu.");
                System.out.println("Press enter to continue...");
                in.nextLine();

            }
        }

    }
}
