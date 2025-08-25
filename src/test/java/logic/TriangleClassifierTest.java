package logic;

import geometry.TriangleType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {
    @Test
    void classify_Undetermined(){
        TriangleProcessor c = new TriangleProcessor();
        TriangleType cType;

        // Cannot determine triangle type if the number of sides is invalid
        cType = c.classify(List.of());
        assertEquals(TriangleType.UNDETERMINED, cType);

        cType = c.classify(List.of(3.0));
        assertEquals(TriangleType.UNDETERMINED, cType);

        cType = c.classify(List.of(3.0, 4.0));
        assertEquals(TriangleType.UNDETERMINED, cType);

        cType = c.classify(List.of(3.0, 4.0, 5.0, 6.0));
        assertEquals(TriangleType.UNDETERMINED, cType);

    }

    @Test
    void classify_Equilateral(){
        TriangleProcessor c = new TriangleProcessor();
        TriangleType cType;

        // All sides match
        cType = c.classify(List.of(3.0, 3.0, 3.0));
        assertEquals(TriangleType.EQUILATERAL, cType);

        // Two sides match
        cType = c.classify(List.of(3.0, 3.0, 4.0));
        assertNotEquals(TriangleType.EQUILATERAL, cType);

        cType = c.classify(List.of(5.0, 6.0, 5.0));
        assertNotEquals(TriangleType.EQUILATERAL, cType);

        cType = c.classify(List.of(7.0, 8.0, 8.0));
        assertNotEquals(TriangleType.EQUILATERAL, cType);

        // No sides match
        cType = c.classify(List.of(3.0, 4.0, 5.0));
        assertNotEquals(TriangleType.EQUILATERAL, cType);
    }

    @Test
    void classify_Isosceles(){
        TriangleProcessor c = new TriangleProcessor();
        TriangleType cType;

        // Two sides match
        cType = c.classify(List.of(3.0, 3.0, 4.0));
        assertEquals(TriangleType.ISOSCELES, cType);

        cType = c.classify(List.of(5.0, 4.0, 4.0));
        assertEquals(TriangleType.ISOSCELES, cType);

        cType = c.classify(List.of(5.0, 6.0, 5.0));
        assertEquals(TriangleType.ISOSCELES, cType);

        // No sides match
        cType = c.classify(List.of(5.0, 6.0, 7.0));
        assertNotEquals(TriangleType.ISOSCELES, cType);
    }

    @Test
    void classify_Scalene(){
        TriangleProcessor c = new TriangleProcessor();
        TriangleType cType;

        // No sides match
        cType = c.classify(List.of(5.0, 6.0, 7.0));
        assertEquals(TriangleType.SCALENE, cType);

        // Two sides match
        cType = c.classify(List.of(3.0, 3.0, 4.0));
        assertNotEquals(TriangleType.SCALENE, cType);

        cType = c.classify(List.of(5.0, 4.0, 4.0));
        assertNotEquals(TriangleType.SCALENE, cType);

        cType = c.classify(List.of(5.0, 6.0, 5.0));
        assertNotEquals(TriangleType.SCALENE, cType);

        // All sides match
        cType = c.classify(List.of(3.0, 3.0, 3.0));
        assertNotEquals(TriangleType.SCALENE, cType);

    }

    @Test
    void validate_InvalidSize(){
        TriangleProcessor c = new TriangleProcessor();
        int validId;

        // 0 sides
        validId = c.validate(List.of());
        assertEquals(1, validId);

        // 1, 2, 4 sides
        validId = c.validate(List.of(1.0));
        assertEquals(1, validId);

        validId = c.validate(List.of(1.0, 1.0));
        assertEquals(1, validId);

        validId = c.validate(List.of(1.0, 1.0, 1.0, 1.0));
        assertEquals(1, validId);
    }

    @Test
    void validate_NonPositive(){
        TriangleProcessor c = new TriangleProcessor();
        int validId;

        // A negative or a zero side
        validId = c.validate(List.of(-1.0, 1.0, 1.0));
        assertEquals(2, validId);

        validId = c.validate(List.of(1.0, -1.0, 1.0));
        assertEquals(2, validId);

        validId = c.validate(List.of(1.0, 1.0, -1.0));
        assertEquals(2, validId);

        validId = c.validate(List.of(1.0, 0.0, 1.0));
        assertEquals(2, validId);

        // No negative sides
        validId = c.validate(List.of(1.0, 1.0, 1.0));
        assertNotEquals(2, validId);

    }

    @Test
    void validate_InvalidTriangleInequality(){
        TriangleProcessor c = new TriangleProcessor();
        int validId;

        // Invalid triangles
        validId = c.validate(List.of(1.0, 2.0, 3.0));
        assertEquals(3, validId);

        validId = c.validate(List.of(2.0, 2.0, 5.0));
        assertEquals(3, validId);

        validId = c.validate(List.of(10.0, 2.0, 1.0));
        assertEquals(3, validId);

        validId = c.validate(List.of(3.0, 20.0, 2.0));
        assertEquals(3, validId);

        // Valid triangles
        validId = c.validate(List.of(3.0, 4.0, 5.0));
        assertNotEquals(3, validId);

        validId = c.validate(List.of(3.0, 4.0, 4.0));
        assertNotEquals(3, validId);

        validId = c.validate(List.of(4.0, 4.0, 4.0));
        assertNotEquals(3, validId);
    }

    @Test
    void validate_Valid(){
        TriangleProcessor c = new TriangleProcessor();
        int validId;

        // Valid triangles
        validId = c.validate(List.of(3.0, 4.0, 5.0));
        assertEquals(0, validId);

        validId = c.validate(List.of(3.0, 4.0, 4.0));
        assertEquals(0, validId);

        validId = c.validate(List.of(4.0, 4.0, 4.0));
        assertEquals(0, validId);

        // Invalid triangles
        validId = c.validate(List.of(1.0, 2.0, 3.0));
        assertNotEquals(0, validId);

        validId = c.validate(List.of(-1.0, 1.0, 1.0));
        assertNotEquals(0, validId);

        validId = c.validate(List.of(1.0));
        assertNotEquals(0, validId);
    }
}