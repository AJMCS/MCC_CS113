public class Term
{

    int coefficient, exponent;
    String termString;
    Term term;
    int coIdx;
    int exIdx;
    String substringCoefficient;
    String substringExponent;

    public Term()
    {
        setAll(1,1);
        this.coefficient = 1;
        this.exponent = 1;
    }

    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Term(Term t)
    {
        this.coefficient = t.getCoefficient();
        this.exponent = t.getExponent();
        
    }

    public Term(String str)
    {

        if(str.isEmpty())
        {
            setCoefficient(0);
            setExponent(0);

        }else if(str.indexOf("x") == -1)
        {
            setCoefficient(Integer.parseInt(str));
            setExponent(0);

        }else
        {
            coIdx = str.indexOf("x");
            substringCoefficient = str.substring(0,coIdx);


            if(substringCoefficient.length() == 1)
            {
                if(substringCoefficient.charAt(0) == '+')
                {
                    setCoefficient(1);
                    
                }else
                {
                    setCoefficient(-1);
                    
                }
                
            }else
            {
                setCoefficient(Integer.parseInt(substringCoefficient));
            }

            if(str.indexOf("^") == -1)
            {
                     
                setExponent(1);
                
            }else
            {
                exIdx = str.indexOf("^");
                substringExponent = str.substring(exIdx + 1, str.length());

                setExponent(Integer.parseInt(substringExponent));
            }

        }

    }


    public void setCoefficient(int coefficient)
    {
        this.coefficient = coefficient;
    }
    public void setExponent(int exponent)
    {
        this.exponent = exponent;
    }

    public int getCoefficient()
    {
        return coefficient;
    }
    public int getExponent()
    {
        return exponent;
    }

    public void setAll(int coefficient, int exponent)
    {
        this.setCoefficient(coefficient);
        this.setExponent(exponent);
    }
    public int compareTo(Term t)
    {
        return this.exponent - t.getExponent();
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null || o.getClass() != Term.class)
        {
            return false;
        }        

        Term test = (Term) o;
        return this.coefficient == test.getCoefficient() && this.exponent == test.getExponent(); 
    }

    public Term clone()
    {
        return new Term(this);
    }

    public String toString()
    {
        if(coefficient == 0)
        {
            return "";

        }else if(coefficient == 1)
        {
            if(exponent == 0)
            {
                return "1";
            }else if(exponent == 1)
            {
                return "+x";
            }else
            {
                return "+x^" + exponent;
            }
        }else if(coefficient == -1)
            {
                if(exponent == 0)
                {
                    return "-1";
                }else if(exponent == 1)
                {
                    return "-x";
                }else
                {
                    return "-x^" + exponent;
                }
            }else if(coefficient > 0)
        {
            if(exponent == 0)
            {
                return "+" + coefficient;

            }else if(exponent == 1)
            {
                return "+" + coefficient + "x";

            }else
            {
                return "+" + coefficient + "x^" + exponent;
            }
        }else
        {

            if(exponent == 0)
            {
                return coefficient + "";

            }else if(exponent ==1)
            {
                return coefficient + "x";

            }else
            {
                return coefficient + "x^" + exponent;
            }
        } 
        
    }

}