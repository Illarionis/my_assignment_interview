package logic;

import geometry.PolygonType;

import java.util.List;

public interface PolygonClassifier<T extends PolygonType> {
    T classify(List<Double> sides);
    int validate(List<Double> sides);

}
