package com.kodilla;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Square;
import com.kodilla.spring.shape.Triangle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodillaCourseApplicationTests {

    @Test
    void testCircleLoadedIntoContainer() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("circle");

        String name = shape.getShapeName();

        assertEquals("This is circle", name);
    }

    @Test
    void testTriangleLoadedIntoContainer() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("triangle");

        String name = shape.getShapeName();

        assertEquals("This is triangle", name);
    }

    @Test
    void testSquareLoadedIntoContainer() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("createSquare");

        String name = shape.getShapeName();

        assertEquals("This is square", name);
    }

    @Test
    void testShapeLoadedIntoContainer() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("chosenShape");

        String name = shape.getShapeName();

        System.out.println(name);
    }

}
