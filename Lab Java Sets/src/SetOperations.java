import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetOperations
{

    public static void main(String[] args) 
    {
        
        Set<String> fruit = new HashSet();
        String[] fruitNames =  {"Apple", "Orange", "Banana", "Grape"};
            
        System.out.println("Java Sets: HashSet\n\n");



        //------ Empty Set (True) ------\\



        System.out.print("We have created a set called fruit. Currently, the Set is empty.");
        System.out.println("Now calling the isEmpty() funtion. Is the set empty?: " + fruit.isEmpty());



        //------ Add Strings to Set ------\\



        System.out.println("\nNext we will add Strings to the set.");

        for(int i = 0; i < fruitNames.length; i++)
        {
            System.out.println("\nAdding " + fruitNames[i] + " to the set");
            fruit.add(fruitNames[i]); //Add string to set
            System.out.println("Success!"); //Let user know the string has been added
            System.out.println("The size of the set is now: " + fruit.size()); //Show user the increased size of the set
        }

        
        
        //------ Empty Set (False) ------\\



        System.out.println("\nIs the string still empty?: " + fruit.isEmpty());



        //------ Add Duplicate Element ------\\



        System.out.println("\nNext, attempting to add a copy of \"Apple\" in the set...");
        fruit.add("Apple");
        System.out.println("Sucess!: Here the resulting set: " + fruit); //Tell user we successfully used add function for set
        System.out.println("There cannot be dupicates of the same value in a set, therefore it did not show up."); //Explain to user there are no duplicates allowed in sets



        //------ Contains Method ------\\



        System.out.println("\nUsing the contains() method we will search for \"pineapple\" and \"Banana\" respectively");
        System.out.println("Contains Pineapple?: " + fruit.contains("Pineapple")); //False
        System.out.println("Contains Banana?: " + fruit.contains("Banana")); //True



        //------- Add Element to set -------\\



        System.out.println("\nNext, let's add \"Mango\" to our set:");
        fruit.add("Mango"); //Add "Mango" to set
        System.out.println("Success");



        //------ Remove Method ------\\



        System.out.println("Now, we will use the remove() method to remove \"Grape\" from the set.");
        fruit.remove("Grape"); //Remove grape from set using remove() function
        System.out.println("Here is the set:" + fruit); //Display resulting set to user
        System.out.println("It's current size is: " + fruit.size()); //Display current size to user



        //------ Iterating Through the Set ------\\



        System.out.println("\nNext let's iterate through the set. There are several ways to accomplish this.\n1. Enhanced For-Loop\n2. Lambda println\n3. Using an iterator");

        //Method 1: Enhanced For-Loops

        System.out.println("\nNow printing using enhanced for-loop:");
        
        for(String name : fruit) //For all string elements in fruit set
        {
            System.out.println(name); //Print the string
        }

        //Method 2: Lambdas

        System.out.println("\nNow printing using a Lambda:");
        fruit.forEach(System.out::println);

        //Method 3: Iterator

        System.out.println("\nNow printing using an iterator:");
        Iterator<String> fruitIterator = fruit.iterator(); //Create iterator
        while(fruitIterator.hasNext()) //Iterate until the iterator is at the end of the set
        {
            System.out.println(fruitIterator.next()); //Print the string 
        }



        //------ Create Second Set ------\\



        System.out.println("\nCreating a second set of fruit names called fruit2.");

        Set<String> fruit2 = new HashSet(); //Create second set
        fruit2.add("Apple"); //Add all the elements wanted
        fruit2.add("Banana");
        fruit2.add("Cherry");
        fruit2.add("Date");
        System.out.println("Here is the set:" + fruit2); //Show user the set
        System.out.println("It's current size is: " + fruit2.size()); //Display the size to user



        //------ Compare Elements in two seperate sets ------\\



        System.out.println("\nNext, let's compare fruit and fruit2");

        //Initialize string with all the fruit names to loop through
        String[] compareFruitNames = {"Apple", "Orange", "Banana", "Mango", "Grape", "Cherry", "Date"};
        
        for(int i = 0; i < compareFruitNames.length ; i++)
        {
            if(fruit.contains(compareFruitNames[i]) && fruit2.contains(compareFruitNames[i])) //If the fruit exists in both sets
            {
                System.out.println("\nBoth sets contain \"" + compareFruitNames[i] + "\"."); //Tell the user it exists in both sets
            }else
            {
                System.out.println("\nBoth sets do not contain \"" + compareFruitNames[i] + "\"."); //Else tell the user the fruit does not exist in both sets
                if(fruit.contains(compareFruitNames[i])) //If the fruit exists in the set called fruit
                {
                    System.out.println(compareFruitNames[i] + " exists in the set called fruit."); //Tell the user

                }else if(fruit2.contains(compareFruitNames[i]))//Else if the fruit exists in the set called fruit2
                {
                    System.out.println(compareFruitNames[i] + " exists in the set called fruit2.");//Tell the user

                }else
                {
                    System.out.println(compareFruitNames[i] + " does not exist in the either set."); //Else tell the user the fruit does not exist in either set
                }
            }
        }



        //------ ContainsAll() Method ------\\


        
        System.out.println("\nLastly, Lets compare the sets themselves.\nWe'll check if all the elements inside of them are exactly the same using the containsAll() method.");
        
        System.out.println("\nfruit: " + fruit);//Show to the user these sets are not equal to each other
        System.out.println("fruit2: " + fruit2);

        System.out.println("\nAre the sets fruit and fruit2 the same?: " + fruit.containsAll(fruit2));//False
        System.out.println("Since the elements in fruit and fruit two do not exactly match, the result is false.");//Explain to user why it is false
        System.out.println("\nNow lets make fruit2 the same as fruit.");

        fruit2 = fruit;
        System.out.println("Success!");
        System.out.println("\nfruit: " + fruit);//Show to the user these sets are now equal to each other
        System.out.println("fruit2: " + fruit2);

        System.out.println("\nNow lets compare them again since they are equal to each other.");
        System.out.println("Are the sets fruit and fruit2 the same?: " + fruit.containsAll(fruit2));//True

        System.out.println("\nSince the elements in fruit and fruit two now exactly match, the result is true.");//Explain to user why it is true



        System.out.println("\n\nEnding program...");

    }
}