import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;

import static org.junit.Assert.*;


public class DriverTest
{

    Term[] terms1 = {   new Term(3,2), 
                        new Term(2,1)};
    
    Term[] terms2 = {   new Term(5, 3), 
                        new Term(4, 1)};
    
    Term[] terms3 = {   new Term(2, 3), // 2x^3
                        new Term(3, 2), // 3x^2
                        new Term(4, 1)}; // 4x
    
    Term[] terms4 = {   new Term(5, 3), // 5x^3
                        new Term(2, 2), // 2x^2
                        new Term(7, 0)}; // 7;
    
    Term[] terms7 = {   new Term(3, 2), // 3x^2
                        new Term(2, 1)}; // 2x
    
    Term[] terms8 = {   new Term(5,4),
                        new Term(4, 3),
                        new Term(3, 2),
                        new Term(2,1),
                        new Term(6, 0)};
  
    


    @Test
    public void testAddPolynomialDifferentDegrees() 
    {
        // Test case 1: Adding two polynomials with different degrees
        Term[] expectedTerms1 = {new Term(5, 3), new Term(3, 2), new Term(6, 1)};
        
        Polynomial poly1 = createPolynomial(terms1);
        Polynomial poly2 = createPolynomial(terms2);
        Polynomial expectedResult1 = createPolynomial(expectedTerms1); 
        
        poly1.add(poly2);
        
        Assert.assertEquals(expectedResult1.toString(), poly1.toString());
    }


    @Test
    public void addPolynomialSameDegree()
    {
        Term[] expectedTerms2 = {new Term(7, 3), new Term(5, 2), new Term(4, 1), new Term(7, 0)};

        Polynomial poly3 = createPolynomial(terms3); 
        Polynomial poly4 = createPolynomial(terms4);
        Polynomial expectedResult2 = createPolynomial(expectedTerms2);

        poly3.add(poly4);
        
        Assert.assertEquals(expectedResult2.toString(), poly3.toString());
    }


    @Test
    public void addEmptyPolynomialsTest()
    {
        Polynomial poly5 = new Polynomial();
        Polynomial poly6 = new Polynomial();
        Polynomial expectedResult3 = new Polynomial();

        poly5.add(poly6);

        Assert.assertEquals(expectedResult3.toString(), poly5.toString());
    }


    @Test
    public void addPolynomialToItselfTest()
    {
        Term[] expectedTerms4 = {new Term(6, 2), new Term(4, 1)};
        Polynomial expectedResult4 = createPolynomial(expectedTerms4);

        Polynomial poly7 = createPolynomial(terms7);

        poly7.add(poly7);
        
        Assert.assertEquals(expectedResult4.toString(), poly7.toString());
    }


    @Test
    public void addPolynomialToEmptyTest()
    {
        Polynomial poly8 = createPolynomial(terms8);
        Polynomial poly9 = new Polynomial();
        Polynomial expectedResult5 = new Polynomial(poly8);

        poly8.add(poly9);

        Assert.assertEquals(expectedResult5.toString(), poly8.toString());
    }


    private Polynomial createPolynomial(Term[] terms) 
    {
        Polynomial polynomial = new Polynomial();
        for (Term term : terms) 
        {
            polynomial.addTerm(term);
        }

        return polynomial;
    }
}