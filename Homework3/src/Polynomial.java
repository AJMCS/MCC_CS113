import java.util.ArrayList;

public class Polynomial 
{
    ArrayList<Term> polynomial = new ArrayList <Term>();

    public Polynomial (Polynomial poly)
    {
        for(int i = 0; i < poly.getNumTerms(); i++)
        {
            this.addTerm(poly.getTerm(i));
        }
    }

    public Polynomial()
    {
        
    }

    public void add (Polynomial poly)
    {
        for(int i = 0; i < poly.getNumTerms(); i++)
        {
            this.addTerm(poly.getTerm(i));
        }
    }



    
    public void addTerm(Term t)
    {
        Term term = new Term(t);

        if(term.getCoefficient() == 0)
        {
            //Do nothing
            return;

        }else if(getNumTerms() == 0)
        {
            polynomial.add(term.clone());
            return;

        }else
        {
            for(int i = 0; i < polynomial.size(); i++)
            {
                if(term.compareTo(polynomial.get(i)) > 0)
                {
                    
                    polynomial.add(i, term.clone()); 
                    break;
                    
                }else if(term.compareTo(polynomial.get(i)) == 0)
                {
                    int coefficientSum = term.getCoefficient() + polynomial.get(i).getCoefficient();

                    if(coefficientSum == 0)
                    {
                        polynomial.remove(i);
                        break;
                    }else
                    {
                        term.setCoefficient(coefficientSum);
                        polynomial.set(i, term.clone());
                        break;
                    }        

                }else if(i == polynomial.size() -1)
                {
                    polynomial.add(term.clone());
                    break;
                } 
            }
        }
        //polynomial.add(term);
        for(int i = 0; i < polynomial.size(); i++)
        {
            System.out.print(polynomial.get(i).toString());
        }
        System.out.println();
        
    }
    

    public Term getTerm(int index)
    {
        return polynomial.get(index);
    }


    public int getNumTerms()
    {
        return polynomial.size();
    }
    
    
    public void clear()
    {
        polynomial.clear();
    }

    @Override
    public String toString()
    {
        String toString;

       if(getNumTerms() == 0)
       {
            return "0";
       }
       else
       {
        for(int i = 0; i < getNumTerms();i++)
        {
           // if(toString.(this.concat(getTerm(0).getCoefficient() > 0))
            {

            }
        }
       }
       

       
       
        return "";
    }
    
}
