package logic;

import geometry.Polygon;
import geometry.PolygonType;

import java.util.List;

public interface PolygonManager<T extends Polygon> {
    void add(T p);
    List<T> getAll();
    T getById(int id);
    int getCount();

}
