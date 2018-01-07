package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoint {
    @Test
    public void testPoint() {
        Point p1 = new Point(3.2, 2.3);
        Point p2 = new Point(4.1, 1.1);
        Assert.assertEquals(p1.distance(p2), 1.4999999999999993);
}


}
