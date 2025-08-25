package geometry;

import logic.TriangleClassifier;

import java.util.List;

/**
 * Represents the Triangle shape
 */
public class Triangle implements Polygon {

    private List<Double> sides;
    private TriangleType triangleType;

    // used for triangle type identification and validation
    private final TriangleClassifier classifier = new TriangleClassifier();

    // Creates a triangle without sides
    public Triangle(){
        this.sides = null;
        this.triangleType = TriangleType.UNDETERMINED;
    }

    // Creates a triangle given side lengths
    public Triangle (List<Double> sides){
        this.sides = sides;
        this.triangleType = classifier.classify(this.sides);
    }

    @Override
    public List<Double> getSides() {
        return this.sides;
    }

    // Updates the sides, reclassifies accordingly
    @Override
    public void setSides(List<Double> sides) {
        this.sides = sides;
        this.triangleType = classifier.classify(this.sides);
    }

    public TriangleType getTriangleType(){
        return this.triangleType;
    }

    public void setTriangleType(TriangleType triangleType){
        this.triangleType = triangleType;
    }

    public String getTriangleTypeStr(){
        return this.triangleType.toString();
    }

    @Override
    public int getSidesCount() {
        if (this.sides == null)
            throw new IllegalStateException("Triangle sides not initialized!");
        return this.sides.size();
    }

    // Not mentioned in the assignment
    // An expansion of the application to more complex problems
    // Polygon children classes can be used for more processing: finding its perimeter or area
    @Override
    public double getPerimeter() {
        if (this.sides == null)
            throw new IllegalStateException("Triangle sides not initialized!");

        double sum = 0.0;
        for (Double s : this.sides) {
            sum += s;
        }
        return sum;
    }

    // Heron's formula
    @Override
    public double getArea() {
        if (this.sides == null)
            throw new IllegalStateException("Triangle sides not initialized!");
        double semiPerimeter = getPerimeter()/2;
        double a = this.sides.get(0);
        double b = this.sides.get(1);
        double c = this.sides.get(2);

        return Math.sqrt(semiPerimeter*
                        (semiPerimeter-a)*
                        (semiPerimeter-b)*
                        (semiPerimeter-c));
    }

}
