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
        Scanner fileReader = new Scanner(fileName);
        Scanner userInput = new Scanner(System.in);
        int exit = 0;
        
        
        int index = 0;
        String line = "";

        if(!file.exists() || file.length() == 0) //If file does not exist or there is nothing on the file
        {
            throw new FileNotFoundException(fileName + " does not exists"); //throw exception
        }
        else
        {
            while(fileReader.hasNextLine() && line != "EDGES") //while file is not over and have not reached the edges
            {
                line = fileReader.nextLine();

                vertices.put(line, index); //add vertices to hashmap
                index ++;
            }

            Matrix matrix = new Matrix(index);

            while(fileReader.hasNextLine())
            {
                line = fileReader.nextLine(); //read from file
                matrix.addEdge(vertices.get(line.substring(0,1)), vertices.get(line.substring(2))); //add edge associataions
            }

            matrix.print();

            while(exit != 1)
            {
                String vert1;
                String vert2;

                System.out.println("Enter first vertex:");
                vert1 = userInput.nextLine(); //save userinput for vertices q

                System.out.println("Enter second vertex:");
                vert2 = userInput.nextLine(); //save userinput for vertex 2

                System.out.println(matrix.checkEdge(vertices.get(vert1), vertices.get(vert2))); //print true of false if that association exists


                System.out.println("quit? yes = 1, no = 0"); //primpt user f they would liek to end the program
                exit = userInput.nextInt();
            }
        }
    }
}
