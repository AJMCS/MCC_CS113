import java.util.Scanner;

public class AssetQueueDriver 
{
    //Display the menu to the user
    public static void displayMenu(int[] options, String[] items)
    {
        System.out.println("Asset Queue Menu");
        System.out.println("==================");
        
        for(int i = 0; i < options.length; i++)
        {
            System.out.printf("%d. %s\n", options[i], items[i]);
        }
    }


    public static void main(String[] args) 
    {
        //Initialize variables
        int userChoice = 0;
        int[] menuOptions = {1, 2, 3, 4, 5, 6, 7, 8};
        String[] menuItems = {"Add Asset", "Remove Asset", "Retrieve Asset", "Get Queue Size", "Diplay Sorted Assets", "Add Dependency","Can Asset Be Retrieved", "Exit Program"};
        AssetQueue queue = new AssetQueue(10);
        int exit = menuOptions.length; //exit is the length of the menuOptions because it will always be the last item on the menu. Written this way for extensibility
        String assetName = "";
        int quantity = 0;


        displayMenu(menuOptions, menuItems); //display menu items

        Scanner keyboard = new Scanner(System.in); //Create scanner

        userChoice = keyboard.nextInt();
        keyboard.nextLine();


        //If the last user input was to exit the program, this while loop will stop running and end the program
        while(userChoice != exit)
        {

            switch(userChoice)
            {
                case 1:
                System.out.println("\n---- " + menuItems[userChoice - 1] + " ----"); //first case returns first index in array by subtracting 1
                
                //collects name and quantity of the new asset from user
                System.out.println("Enter name of asset:");
                assetName = keyboard.nextLine();
                System.out.println();

                System.out.println("Enter quantity of asset:");
                quantity = keyboard.nextInt();
                System.out.println();

                //Creates asset object
                Asset asset1 = new Asset(assetName, quantity);
                //Call the addAsset method
                queue.addAsset(asset1);
                System.out.println("Add function has been completed on asset.\n"); //tell user the operation is complete
                System.out.println("The size of the queue is now: " + queue.getQueueSize()); //help user determine if the asset was added or not. (cannot add multiple instances of the same asset)
                System.out.println();
                break;



                case 2:
                System.out.println("\n---- " + menuItems[userChoice - 1] + " ----");

                //Ask user for the name of the asset
                System.out.println("Enter name of asset:");
                assetName = keyboard.nextLine();
                System.out.println();

                //call the removeAsset method
                queue.removeAsset(assetName);
                System.out.println("The document has been removed.\n");//tell user the operation is complete
                System.out.println("The size of the queue is now: " + queue.getQueueSize()); //help user determine if the asset was removed or not. (cannot an asset that does not exist)
                System.out.println();
                break;



                case 3:
                System.out.println("\n---- " + menuItems[userChoice - 1] + " ----");

                Asset retrievedAsset = queue.retrieveAsset(); //call the retrieveAsset function and store it in a new asset
                System.out.println("The retrieved asset is: " + retrievedAsset); //print the retrieved asset to the user (will be null if the asset does not exist)
                break;



                case 4:
                System.out.println("\n---- " + menuItems[userChoice - 1] + " ----");

                System.out.println("The size of the queue is: " + queue.getQueueSize()); //print the queue size to the user
                System.out.println();
                break;



                case 5:
                System.out.println("\n---- " + menuItems[userChoice - 1] + " ----");

                System.out.println("Sorted assets are as follows: ");
                System.out.println(queue.getSortedAssets() + "\n"); //return the sorted list to the user
                System.out.println();
                break;



                case 6:
                System.out.println("\n---- " + menuItems[userChoice - 1] + " ----");
                String dep1, dep2;

                //Ask user to enter the name of the asset that is dependent
                System.out.println("Enter first dependent:");
                dep1 = keyboard.nextLine(); 

                System.out.println("Enter second dependent:");
                dep2 = keyboard.nextLine(); 

                //Call the addDependecyMethod
                queue.addDependency(dep1, dep2);
                System.out.println(dep1 + " is now dependent on " + dep2); //print to user that the dependency is complete
                break;



                case 7:
                String checkAsset;
                
                System.out.println("Enter asset to check:");
                checkAsset = keyboard.nextLine();

                System.out.println("Can " + checkAsset + " be retrieved?: " + queue.canRetrieveAsset(checkAsset));
                break;



                default:
                System.out.println("\nInvalid Entry: Valid Entries are numbers from 1 to " + menuOptions.length + "\n\nPlease try again.\n");
                System.out.println();
            }

            //redisplay the menu after a switch case has been run
            displayMenu(menuOptions, menuItems);
            
            //ask the user to make a new choice and save the selection
            userChoice = keyboard.nextInt();
            keyboard.nextLine();

            //if user chooses to quit, the int value will equal the length of the menuItems array
            if(userChoice == menuItems.length)
            {
                System.out.println("---- " + menuItems[userChoice - 1] + " ----");
                System.out.println("Ending Program...");
            }
       }

       keyboard.close();
    }
}
