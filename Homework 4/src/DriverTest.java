import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;


public class DriverTest
{

    /* Polynomial poly1 = {    new Term(3,2),
                            new Term(2,1)};

    Polynomial poly2 = {    new Term(5, 3),
                            new Term(4, 1)};

    Polynomial poly3 = {    new Term(2, 3), // 2x^3
                            new Term(3, 2), // 3x^2
                            new Term(4, 1)}; // 4x

    Polynomial poly4 = {    new Term(5, 3), // 5x^3
                            new Term(2, 2), // 2x^2
                            new Term(7, 0)}; // 7

    Polynomial poly5 = new Polynomial();
    Polynomial poly6 = new Polynomial();

    Polynomial poly7 = {    new Term(3, 2), // 3x^2
                            new Term(2, 1)}; // 2x

    Polynomial poly8 = {    new Term(5,4),
                            new Term(4, 3),
                            new Term(3, 2),
                            new Term(2,1),
                            new Term(6, 0)};



*/


@Test
    public void testAddPolynomialDifferentDegrees() {
        // Test case 1: Adding two polynomials with different degrees
        
        Polynomial expectedResult1 = {  new Term(5, 3),
                                        new Term(3, 2),
                                        new Term(6, 1)};
        
        assertEquals(expectedResult1, poly1.add(poly2));
    }


    @Test
    public void addPolynomialSameDegree()
    {
        Polynomial expectedResult2 = {  new Term(7, 3),
                                        new Term(5, 2),
                                        new Term(4, 1),
                                        new Term(7, 0)};
        
        assertEquals(expectedResult2, poly3.add(poly4));
    }


    @Test
    public void addEmptyPolynomialsTest()
    {
        Polynomial expectedResult3 = new Polynomial();

        assertEquals(expectedResult3, poly5.add(poly6));
    }


    @Test
    public void addPolynomialToItselfTest()
    {
        Polynomial expectedResult4 = {  new Term(6, 2), // 6x^2
                                        new Term(4, 1)}; // 4x
        
        assertEquals(expectedResult4, poly7.add(poly7));
    }


    @Test
    public void addPolynomialToEmptyTest()
    {
        Polynomial expectedResult5 = new Polynomial(poly8);

        assertEquals(expectedResult5, poly8.add(poly6));
    }
}