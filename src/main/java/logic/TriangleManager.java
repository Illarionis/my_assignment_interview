package logic;

import geometry.Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Container, storing and retrieving Triangle instances
 */
public class TriangleManager implements PolygonManager<Triangle>{
    private final List<Triangle> triangles;

    public TriangleManager(){
        triangles = new ArrayList<>();
    }

    @Override
    public void add(Triangle p){
        this.triangles.add(p);
    }

    @Override
    public List<Triangle> getAll(){
        return this.triangles;
    }

    @Override
    public Triangle getById(int id){
        return this.triangles.get(id);
    }

    @Override
    public int getCount(){
        return this.triangles.size();
    }

}
