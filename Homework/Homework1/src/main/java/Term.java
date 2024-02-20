class Term
{
    private double coefficient;
    private String variable = "x";
    private double exponent = 0;

    
    //Setters
    public void setVariable(String variable)
    {
        this.variable = variable;
    }

    public void setCoefficient(double coefficient)
    {
        this.coefficient = coefficient;
        
    }

    public void setExponent(double exponent)
    {
        this.exponent = exponent;
    }
   


    //Getters
    public String getVariable()
    {
        return this.variable;
    }

    public double getCoefficient()
    {
        return this.coefficient;
    }

    public double getExponent()
    {
        return this.exponent;
    }


    public String toString()
    {
        if(coefficient >= 0)
        {
            if(exponent == 0)
            {
                return coefficient + "";
            }else if(exponent == 1)
            {
                return coefficient + variable;
            }else
                
            return coefficient + variable + "^" + exponent;
            
        }else

            if(exponent == 0)
            {
                return (coefficient * -1) + "";
                
            }else if(exponent == 1)
            {
                return (coefficient * -1) + variable;
                
            }
            return (coefficient * -1) + variable + "^" + exponent;
    }
}