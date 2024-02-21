
public class Term
{
    private int exponent, coefficient;




    public Term()
    {
        setAll(1,1);
        this.exponent = 1;
        this.coefficient = 1;
    }

    public Term(coefficient, exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }



    public int getExponent()
    {
        return exponent;
    }

    public int getCoefficient()
    {
        return coefficient;
    }




    public void setExponent(exponent)
    {
        this.exponent = exponent;
    }

    public void setCoefficient(coefficient)
    {
        this.coefficient = coefficient;
    }

    public void setAll(coefficient, exponent)
    {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }




    public string toString()
    {
        return "Complete this";
    }
    
}