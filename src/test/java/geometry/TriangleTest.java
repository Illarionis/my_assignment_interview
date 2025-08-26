package geometry;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void defaultTriangle_hasNullSidesAndHasUndeterminedType() {
        Triangle t = new Triangle();
        assertNull(t.getSides());
        assertEquals(TriangleType.UNDEFINED, t.getType());
    }

    @Test
    void constructsFromSides(){
        List<Double> sides = List.of(3.0, 4.0, 5.0);
        Triangle t = new Triangle(sides);

        assertEquals(List.of(3.0, 4.0, 5.0), t.getSides());
    }

    @Test
    void setSides_updatesSides(){
        List<Double> sides = List.of(3.0, 4.0, 5.0);
        Triangle t = new Triangle(sides);

        t.setSides(List.of(6.0, 6.0, 6.0));
        assertEquals(List.of(6.0, 6.0, 6.0), t.getSides());
    }

    @Test
    void setSides_updatesType(){
        List<Double> sides = List.of(3.0, 4.0, 5.0);
        Triangle t = new Triangle(sides);

        t.setSides(List.of(6.0, 6.0, 6.0));
        assertEquals(TriangleType.EQUILATERAL, t.getType());
    }

    @Test
    void triangleType_isUpdatedAndRetrieved(){
        Triangle t = new Triangle();
        assertEquals(TriangleType.UNDEFINED, t.getType());
        assertEquals("Undefined", t.getTypeStr());

        t.setType(TriangleType.EQUILATERAL);
        assertEquals(TriangleType.EQUILATERAL, t.getType());
        assertEquals("Equilateral", t.getTypeStr());

        t.setType(TriangleType.ISOSCELES);
        assertEquals(TriangleType.ISOSCELES, t.getType());
        assertEquals("Isosceles", t.getTypeStr());

        t.setType(TriangleType.SCALENE);
        assertEquals(TriangleType.SCALENE, t.getType());
        assertEquals("Scalene", t.getTypeStr());
    }

    @Test
    void getSidesCount_throws_IllegalArgumentException_forNullSides(){
        Triangle t = new Triangle();
        assertThrows(IllegalStateException.class, ()->{t.getSidesCount();});
    }

    @Test
    void getSidesCount_hasCorrectAmount(){
        Triangle t = new Triangle();
        t.setSides(List.of(3.0, 4.0, 5.0));
        assertEquals(3, t.getSidesCount());
    }

    @Test
    void getPerimeter_throws_IllegalArgumentException_forNullSides(){
        Triangle t = new Triangle();
        assertThrows(IllegalStateException.class, ()->{t.getPerimeter();});
    }

    @Test
    void getPerimeter_isCorrect(){
        Triangle t = new Triangle();

        t.setSides(List.of(3.0, 4.0, 5.0));
        assertEquals(12.0, t.getPerimeter());

        t.setSides(List.of(3.0, 3.0, 3.0));
        assertEquals(9.0, t.getPerimeter());

        t.setSides(List.of(5.0, 5.0, 6.0));
        assertEquals(16.0, t.getPerimeter());
    }

    @Test
    void getArea_throws_IllegalArgumentException_forNullSides(){
        Triangle t = new Triangle();
        assertThrows(IllegalStateException.class, ()->{t.getArea();});
    }

    @Test
    void getArea_isCorrect(){
        Triangle t = new Triangle();

        t.setSides(List.of(3.0, 4.0, 5.0));
        assertEquals(6.0, t.getArea(), 1e-3);

        t.setSides(List.of(3.0, 3.0, 3.0));
        assertEquals(3.897, t.getArea(), 1e-3);

        t.setSides(List.of(5.0, 5.0, 6.0));
        assertEquals(12.0, t.getArea(), 1e-3);

    }
}