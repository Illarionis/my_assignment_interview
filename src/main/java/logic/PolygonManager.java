package logic;

import geometry.Polygon;

import java.util.List;

/**
 * Generalize a polygon manager to match the polygons it manages based on their type
 * @param <T> implemented class of Polygon managed: Triangle/Rectangle/Pentagon etc
 */
public interface PolygonManager<T extends Polygon> {
    void add(T p);
    List<T> getAll();
    T getById(int id);
    void removeById(int id);
    void removeAll();
    int getCount();
}
