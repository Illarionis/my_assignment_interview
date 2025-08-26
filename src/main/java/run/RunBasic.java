package run;

import geometry.Triangle;
import logic.PolygonProcessor;
import logic.TriangleProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A more basic class for running the app
 * Allows for only one triangle input
 * Displays only the triangle sides and its type or the error message
 * Terminates in the end unconditionally
 */
public class RunBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept inputs
        List<Double> sides = new ArrayList<>();
        int i = 0;
        while (i < 3){
            System.out.print("Please enter side " + (i+1) + ": ");
            String input = scanner.nextLine().trim();

            try{
                double inputVal = Double.parseDouble(input);
                sides.add(inputVal);
                i++;
            }
            catch (NumberFormatException e){
                System.out.print("Invalid input. Please try again");
            }
        }

        // Validate and classify the triangle
        PolygonProcessor classifier = new TriangleProcessor();
        switch (classifier.validate(sides)){
            case 0:
                Triangle triangle = new Triangle(sides);
                System.out.println("Your triangle " + triangle.getSides() + " is " + triangle.getTypeStr() + "!");
                break;
            case 1:
                System.out.println("Cannot identify triangle: the shape does not have 3 sides");
                break;
            case 2:
                System.out.println("Cannot identify triangle: the shape has non-positive side(s)");
                break;
            case 3:
                System.out.println("Cannot identify triangle: the triangle does not follow the triangle inequality");
                break;
            default:
                break;
        }
    }
}
