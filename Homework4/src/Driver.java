
public class Driver 
{
    public static void main(String[] args) 
    {
        
        Term[] polyTerms1 = {
                                new Term(0, 0),
                                new Term(2,3),
                                new Term(-2, 4),
                                new Term(-3, -5)};

        Term[] polyTerms2 = {
                                new Term(-7,0),
                                new Term(0,-1),
                                new Term(2,2)};


        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        

        for(int i = 0; i < polyTerms1.length; i++)
        {
            poly1.addTerm(polyTerms1[i]);
        }

        for(int i = 0; i < polyTerms2.length; i++)
        {
            poly2.addTerm(polyTerms2[i]);
        }
        
       
        System.out.println("Output for polynomial 1: " + poly1);
        System.out.println("Output for polynomial 2: " + poly2);

        poly1.add(poly2);

        System.out.println("Polynomial 1 + polynomial 2: " + poly1);
    }
    
    
}
