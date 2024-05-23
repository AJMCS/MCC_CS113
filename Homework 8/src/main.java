import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class main 
{
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        String fileName = "vertex_edge_list.txt";
        HashMap<String, Integer> vertices = new HashMap();
        
        File file = new File(fileName);

        Scanner fileReader = new Scanner(file);
        Scanner userInput = new Scanner(System.in);
        int exit = 0;
        
        
        int index = 0;
        String line = "";
        String vert1;
        String vert2;

        if(!file.exists() || file.length() == 0) //If file does not exist or there is nothing on the file
        {
            throw new FileNotFoundException(fileName + " does not exists"); //throw exception
        }
        else
        {
            System.out.println("Hashmap");
            while(fileReader.hasNextLine() && line != "EDGES") //while file is not over and have not reached the edges
            {
                line = fileReader.nextLine();
                System.out.println(line);
                vertices.put(line, index); //add vertices to hashmap
                index ++;
            }

            Matrix matrix = new Matrix(index);

            System.out.println("addEdge");
            while(fileReader.hasNextLine())
            {
                String line1;
                String line2;


                line = fileReader.nextLine(); //read from file

                line1 = line.substring(0,1);
                line2 = line.substring(2);
                System.out.println(line1);
                System.out.println(line2);
                matrix.addEdge(vertices.get(line.substring(0,1)), vertices.get(line.substring(2))); //add edge associations
            }

            matrix.print();

            while(exit != 1)
            {

                System.out.println("Enter first vertex:");
                vert1 = userInput.nextLine(); //save userinput for vertices q

                System.out.println("Enter second vertex:");
                vert2 = userInput.nextLine(); //save userinput for vertex 2

                System.out.println(matrix.checkEdge(vertices.get(vert1), vertices.get(vert2))); //print true of false if that association exists


                System.out.println("quit? yes = 1, no = 0"); //primpt user f they would liek to end the program
                exit = userInput.nextInt();
                System.out.println();
            }
        }
    }
}