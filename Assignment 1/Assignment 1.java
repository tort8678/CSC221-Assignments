import java.util.Scanner;
class Main{
    public static void main(String args[]){
        // Task 1 
        System.out.println("Task 1:");
        int test1 = 1;
        String test2 = "test2";
        double test3 = 3.0;
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);

        // Task 2
        System.out.println("\nTask 2:");
        System.out.println("What is your age?");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        if(age >= 18){
            System.out.println("You are an adult.");
        }
        else System.out.println("You are a minor.");

        // Task 3
        System.out.println("\nTask 3:");
        System.out.println("Here are all even numbers between 1 and 20:");
        for(int i=1; i <=20;i++){
            if(i%2 == 0) System.out.print(i + " ");
        }
        System.out.println("\nHere is the sum of all odd numbers between 1 and 50:");
        int k =0;
        for(int i=1; i <=20;i++){
            if(i%2 != 0) k += i;
        }
        System.out.println(k);

        //Task 4
        System.out.println("\nTask 4:");
        System.out.println("Area of 12 and 4: "+ calculateArea(12,4));
        System.out.println("Area of 50 and 13: "+ calculateArea(50,13));

        //Task 5        
        System.out.println("\nTask 5:");
        System.out.println("Factorial of 3: "+calculateFactorial(3));
        System.out.println("Factorial of 12: "+calculateFactorial(12));
        System.out.println("Factorial of 2: "+calculateFactorial(2));
        
        //Bonus Task
        System.out.println("\nBonus Task:");
        System.out.println("Please enter two numbers and an operation symbol(+,-,*,/,%) in that order" );

        int num1 = in.nextInt();
        int num2 = in.nextInt();
        char op = in.next().charAt(0);
        System.out.println("The answer is " + calculator(num1, num2, op));

    }

    static double calculator(int one, int two, char op){
            if(op == '+') return one + two;
            else if(op=='-') return one-two;
            else if(op=='/') return one/two;
            else if (op=='%') return one%two;
            else if(op=='*')return one*two;
            else throw new RuntimeException("ERROR: Please use one of the designated operational symbols");
    }

    static int calculateArea(int l, int w){
        return l*w;
    }  

    static int calculateFactorial(int n){
        int sum = 1;
        for(int i = n;i > 0; i--){
            sum*=i;
        }
        return sum;
    }
}

