import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapBasics
{
    public static void main(String[] args) 
    {
        
        HashMap<String, Integer> fruitStock = new HashMap<>();

        //Initializing HashMap keys in an ArrayList
        ArrayList<String> fruitNames = new ArrayList<String>()
        {
            {
                add("Apple");
                add("Orange");
                add("Banana");
                add("Grape");
            }
        };

        //Initializing HashMap values in an ArrayList
        ArrayList<Integer> fruitInt = new ArrayList<Integer>()
        {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };

        //------ isEmpty() Method (False) ------\\

        System.out.println("Java Maps: HashMap\n\n");

        System.out.println("We have created a HashMap called fruitStock. Currently it is empty, we'll use the isEmpty() method to veryfy:");
        System.out.println("Is fruitStock Empty?: " + fruitStock.isEmpty());


        //------ Adding Initial Values to HashMap ------\\


        System.out.println("\nNow we will add values to fruitStock: ...");

        //Add each item to the HashMap by looping through are key and value arraylists.
        for(int i = 0; i < fruitInt.size(); i++)
        {
            fruitStock.put(fruitNames.get(i), fruitInt.get(i));
        }

        System.out.println("Success!");
        System.out.println("Here is our current HashMap: " + fruitStock); //Print out the current HashMap
        System.out.println("The current size of the HashMap is: " + fruitStock.size()); //Print out the current size of the HashMap



        //------ containsKey() Method ------\\



        System.out.println("\nNow we will search fruitStock to find out if it contains certain keys(fruit names) using the containsKey() method");
        System.out.println("Does a fruit in fruitStock contain \"" + fruitNames.get(0) + "\"?: " + fruitStock.containsKey(fruitNames.get(0))); //Returns true
        System.out.println("Does fruitStock contain \"Dragonfruit\"?: " + fruitStock.containsKey("Dragonfruit")); //Returns False



        //====== containsValue() Method ------\\



        System.out.println("\nLikewise, we can search fruitStock to find out if it contains certain values(number of fruit in stock) using the containsValue() method");
        System.out.println("Does any fruit in the Hashmap contain 4 items in stock?: " + fruitStock.containsValue(4)); //Returns true
        System.out.println("Does any fruit in the Hashmap contain 20 items in stock?: " + fruitStock.containsValue(20)); //Returns False



        //------ Update, Add, and Remove Elements ------\\

        //Set Method
        System.out.println("\nNow we add will update \"Banana\" to have a stock of 5 using the put() Method");
        fruitStock.put("Banana", 5);
        System.out.println("Success!");
        System.out.println("Here is the current value of Bananas: " + fruitStock.get("Banana")); //Print out the desired set

        //Add Method
        System.out.println("\nLet's add a new set, Mango, with an in-stock quanitity of 6");
        fruitStock.put("Mango", 6);
        System.out.println("Success!");
        System.out.println("Here is the current value of Mangos: " + fruitStock.get("Mango")); //Print out the desired set

        //Remove Method
        System.out.println("\nFinally, let's remove grapes from the HashMap.");
        fruitStock.remove("Grape");
        System.out.println("Success!");
        System.out.println("Does our HashMap contain Grapes?: " + fruitStock.containsKey("Grape")); //Returns False

        //Print current HashMap and Size
        System.out.println("\nThe current HashMap is: " + fruitStock);
        System.out.println("The current size of the HashMap is: " + fruitStock.size()); //Print out the current size of the HashMap



        //------ Iteration Using keySet() and entrySet() ------\\



        //keySet()
        System.out.println("\nWe are now going to iterate over the hashmap using the keySet() method.");
        for(String key : fruitStock.keySet())
        {
            System.out.println(key + " = " + fruitStock.get(key)); //Print out Keys and Values for fruitStock
        }

        //entrySet()
        System.out.println("\nNow for iteration over the Map using entrySet().");
        for(Map.Entry<String, Integer> entry : fruitStock.entrySet())
        {
            System.out.println(entry.getKey() + " = " + entry.getValue()); //Print out Keys and Values for fruitStock
        }



        //------ Create Collection View of Map & Print, Search for number 3 in values ------\\



        System.out.println("\nValues: " + fruitStock.values());
        System.out.println("Does the collection hold the value 3?: " + fruitStock.containsValue(3));

        
        System.out.println("\n\nEnding program...");
    }
}