package logic;

import geometry.PolygonType;

import java.util.List;

/**
 * Generalize any class used to classify and validate a Polygon class
 * @param <T> implemented enum of Polygon being classified, e.g. TriangleType
 */
public interface PolygonProcessor<T extends PolygonType> {
    T classify(List<Double> sides);
    int validate(List<Double> sides);
}
