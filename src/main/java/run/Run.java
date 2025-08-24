package run;

import geometry.Triangle;
import logic.PolygonClassifier;
import logic.PolygonManager;
import logic.TriangleClassifier;
import logic.TriangleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    PolygonManager manager;
    Scanner scanner;
    PolygonClassifier classifier;

    Run(){
        manager = new TriangleManager();
        scanner = new Scanner(System.in);
        classifier = new TriangleClassifier();
    }

    // Reading each polygon side from user input in terminal
    private ArrayList<Double> receiveInput(){
        ArrayList<Double> sides = new ArrayList<>();

        System.out.println("\nEnter side lengths separated by Enter key (type 'done' to finish):");
        while (true){
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            try{
                double inputVal = Double.parseDouble(input);
                sides.add(inputVal);
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input. Please try again:");
            }
        }

        System.out.println("You've entered " + sides.size() + " sides: " + sides);
        return sides;
    }

    // Processing side length: validating and looping back if invalid
    private void processTriangleInput() {
        boolean validSides = false;
        while (!validSides) {
            List<Double> sides = this.receiveInput();

            int validityId = classifier.validate(sides);
            switch (validityId){
                case 0:
                    validSides = true;
                    manager.add(new Triangle(sides));
                    break;
                case 1:
                    System.out.println("Invalid number of sides. Please input 3 sides");
                    break;
                case 2:
                    System.out.println("Invalid side length. Please input only non-zero lengths");
                    break;
                case 3:
                    System.out.println("Invalid triangle. Please follow the triangle inequality");
                    break;
            }
        }
    }

    // Printing all triangles provided by user
    private void outputTriangles(int triangleCount){
        for (int i = 0; i < triangleCount; i++){
            Triangle t = (Triangle) manager.getById(i);
            System.out.println("\t" + (i+1) + ". " + t.getSides() + " - " + t.getTriangleTypeStr());
        }
    }

    // Main program loop
    public void startProgram(){
        boolean exit = false;
        while (!exit){
            int triangleCount = manager.getCount();
            System.out.println("\nYou currently have " + triangleCount + " triangles");
            if (triangleCount > 0){
                outputTriangles(triangleCount);
            }

            while (true){
                System.out.println("Add a new triangle or exit the program? Type 'add' or 'exit':");
                String menuInput = scanner.nextLine().trim();
                if (menuInput.equalsIgnoreCase("exit")) {
                    exit = true;
                    break;
                }
                if (menuInput.equalsIgnoreCase("add")){
                    this.processTriangleInput();
                    break;
                }
                else{
                    System.out.println("Menu input invalid, please try again\n");
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
//        ArrayList<Double> sides = new ArrayList<>();
//        sides.add(3.0);
//        sides.add(3.0);
//        sides.add(3.0);
//        Triangle triangle = new Triangle(sides);
//        System.out.println(triangle.getTriangleTypeStr());
//
//        TriangleType newType = TriangleSolver.solveType(triangle);
//        triangle.setTriangleType(newType);
//        System.out.println(triangle.getTriangleTypeStr());
//
//        System.out.println(TriangleSolver.getTrianglePerimeter(triangle));
//        System.out.println(TriangleSolver.getTriangleArea(triangle));
        Run runner = new Run();
        runner.startProgram();
    }
}
