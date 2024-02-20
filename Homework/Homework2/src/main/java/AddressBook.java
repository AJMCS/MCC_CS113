import java.util.ArrayList;
import java.util.Scanner;



public class AddressBook
    {
        //Instantiate the ArrayList
        private ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();

        
        //Implement AddEntry Method
        public void addEntry(String name, String number)
        {
            theDirectory.add(new DirectoryEntry(name, number));
        }

        public void setName(int index, String name)
        {
            theDirectory.get(index).setName(name);
        }


        //Implement FindEndtryIndex Method
        public int findEntryIndex(String name)
        {
            for(int i=0; i < theDirectory.size(); i++)
                {
                    if(theDirectory.get(i).equals(name))
                    {
                        return i;
                    }
                }
            return -1;
        }

        public String toString()
        {
           return theDirectory.toString();
            
        }
        
    }