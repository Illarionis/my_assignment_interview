package logic;

import geometry.TriangleType;

import java.util.List;

/**
 * Identifies a triangle's type in accordance to TriangleType
 * Validates whether a triangle is valid or not
 */
public class TriangleProcessor implements PolygonProcessor<TriangleType> {
    // Identifies the triangle type based on side lengths
    // (Equilateral, Isosceles, Scalene)
    @Override
    public TriangleType classify(List<Double> sides){
        // Check for valid number of sides
        if (sides.size() != 3){
            return TriangleType.UNDEFINED;
        }

        double a = sides.get(0);
        double b = sides.get(1);
        double c = sides.get(2);

        // Check for Equilateral
        if (a == b && b == c)
            return TriangleType.EQUILATERAL;

        // Check for Isosceles
        if (a == b || b == c || a == c)
            return TriangleType.ISOSCELES;

        // Otherwise - Scalene
        return TriangleType.SCALENE;
    }

    // Checking whether a triangle is valid, returns:
    // 0 - valid
    // 1 - doesn't have 3 sides
    // 2 - has non-positive side(s)
    // 3 - violates the triangle inequality
    //     (sum of any two sides' lengths has to be greater than the length of the other side)
    @Override
    public int validate(List<Double> sides){
        // Check for valid number of sides
        if (sides.size() != 3) return 1;

        double a = sides.get(0);
        double b = sides.get(1);
        double c = sides.get(2);

        // Check for non-positive sides
        if (a <= 0 || b <= 0 || c <= 0){
            return 2;
        }

        // Check for a violation of the triangle inequality
        if (a + b <= c || b + c <= a || a + c <= b){
            return 3;
        }
        return 0; // Valid triangle
    }

}
