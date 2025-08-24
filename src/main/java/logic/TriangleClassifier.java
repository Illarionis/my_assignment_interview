package logic;

import geometry.TriangleType;

import java.util.ArrayList;
import java.util.List;

public class TriangleClassifier implements PolygonClassifier<TriangleType>{
    // Identifies the triangle type based on side lengths.
    // (Equilateral, Isosceles, Scalene)
    @Override
    public TriangleType classify(List<Double> sides){
        // Check for valid number of sides
        if (sides.size() != 3){
            return TriangleType.UNDETERMINED;
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

    // Checking for triangles that:
    //  - do not have 3 sides
    //  - have non-positive side lengths
    //  - violate the triangle inequality (any pairwise sum of sides must be greater than the other side)
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
