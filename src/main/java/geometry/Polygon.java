    package geometry;

    import java.util.List;

    /**
     * Generalize any polygon: triangle, rectangle, pentagon etc
     */
    public interface Polygon <T extends PolygonType>{
        List<Double> getSides();
        void setSides(List<Double> sides);
        int getSidesCount();
        T getType();
        String getTypeStr();
        void setType(T type);
        double getPerimeter();
        double getArea();
    }