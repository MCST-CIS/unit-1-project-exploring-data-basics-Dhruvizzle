import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "votes.txt"; // file
        int cand1 = 0; // candidate one
        int cand2 = 0; // candidate two

        try { // try catch 
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            if (reader.ready()) {
                cand1 = Integer.parseInt(reader.readLine());
                cand2 = Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred with this file.");
        }

        Scanner reply1 = new Scanner(System.in); // using scanner 
        System.out.println("Please enter your name: ");
        String name = reply1.nextLine(); // getting user name
        System.out.println("Please enter your age: ");
        int age = reply1.nextInt(); // getting user age 

        if (age >= 18) {
            System.out.println("Please select a candidate to vote for: "); // asking user to vote for a candidate
            System.out.println("(1.) Devan Patel ");
            System.out.println("(2.) Hillary Clinton");
            int choice = reply1.nextInt();

            if (choice == 1) {
                cand1++;
            } else if (choice == 2) {
                cand2++;
            } else {
                System.out.println("Invalid choice."); // error trap
                reply1.close();
                return;
            }
            System.out.println("Thank you for voting, " + name);
        } else {
            System.out.println("Sorry, you are not eligible to vote :("); // error trap 
        }

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            writer.println(cand1);
            writer.println(cand2);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred with this file.");
        }

        System.out.println("Votes for Devan: " + cand1);
        System.out.println("Votes for Hillary: " + cand2);

        reply1.close();
    }
}
