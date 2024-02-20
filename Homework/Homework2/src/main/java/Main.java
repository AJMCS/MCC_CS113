import java.util.Scanner;
import java.util.ArrayList;
public class Main{

    public static void main(String[] args)
    {
        String name;
        String number;
        String flag = "y";
        Scanner input = new Scanner(System.in);

        AddressBook addressbook = new AddressBook();

        do
        {
            addressbook.addEntry("John", "112-334-5678");
        

        }while(flag.charAt(0) == 'y');

    }
}