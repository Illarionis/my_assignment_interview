    package geometry;

    import java.util.List;

    /**
     * Generalize any polygon: triangle, rectangle, pentagon etc
     */
    public interface Polygon {
        List<Double> getSides();
        void setSides(List<Double> sides);
        int getSidesCount();
        double getPerimeter();
        double getArea();
    }

    /*
    getSides -> getDimensions
    getTypeOfDimension
    ||
    \/
    Determine figure

    Incr complexity 1: only triangle, but more solutions: perimeter, area, angles given sides
    Incr complexity 2: given the params - determine figure and its solutions
     */


    /*
    1. Start the program
    2. Show how many triangles
        2.1 If >0 -> list the sides and type
    3. Ask if they want to input more triangles or exit
        3.1 If exit - stop the while loop
    4. Take in however many sides they give us OR Take in three sides
    5. Process the sides:
        - Check for right amount
        - Check for non-zero vals
        - Check for validity under triangle inequality (sum of any 2 sides must be greater than the 3rd side)
        5.1 If invalid, loop back to 4
    6. Create new triangle obj with new Triangle(sides)
    7. Loop back to 2.
     */