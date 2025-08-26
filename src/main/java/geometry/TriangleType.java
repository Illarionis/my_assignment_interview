package geometry;

/**
 * Identifies the triangle's type based on its sides' equality
 */
public enum TriangleType implements PolygonType{
    EQUILATERAL("Equilateral"), // equilateral
    ISOSCELES("Isosceles"), // isosceles
    SCALENE("Scalene"), // scalene
    UNDEFINED("Undefined");  // none, type is not determined yet

    private final String name;

    TriangleType(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
