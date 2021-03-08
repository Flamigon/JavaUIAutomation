package ru.geekbrains.lesson;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleAreaTest {

    static final Logger logger = LoggerFactory.getLogger(TriangleAreaTest.class);

    @BeforeEach
    void setUpTest(){
        logger.info("\tBefore one test");
    }

    @AfterEach
    void tearDownTest(){
        logger.info("\tAfter one test");
    }

    @DisplayName("Is the triangle's area calculated correctly?")
    @ParameterizedTest
    @CsvSource({
            "3, 4, 5"
    })
    void areaTest(double x, double y, double z){
        logger.info("\t\t Test start");
        double u = FindTriangleArea.triangleArea(x, y, z);
        double v = (x + y + z)/2;
        Assertions.assertEquals(Math.sqrt(v*(v-x)*(v-y)*(v-z)), u);
        logger.info("\t\t Test end");
    }
}
