import java.util.List;

public class main 
{

    public static <E> List <E> addItems(E[] terms)
    {

        //-------- Sanity Check --------\\



        List <E> list = new DoubleLinkedList<E>();
        for(E e : terms)
        {
            list.addLast(e);
        }

        return list;
    }

    public static void main(String[] args) 
    {
        

        Integer[] intTerms = {1, 2, 3, 4, 5};
    String[] stringTerms = {"one", "two", "three", "four", "five"};
    Character[]  charTerms = {'a', 'b', 'c', 'd', 'e'};
    Double[] doubleTerms = {1.5, 2.5, 3.5, 4.5, 5.5};

    

    List<Integer> newList = new DoubleLinkedList<Integer>();
        newList = addItems(intTerms);
        var iter = newList.iterator();
        

        for(int i = 0; i < newList.size(); i++)
        {
            System.out.print(intTerms[i]);
        }

        System.out.println();

        for(int i = 0; i < newList.size(); i++)
        {
            
            System.out.print(iter.next());
        }
    }
}
