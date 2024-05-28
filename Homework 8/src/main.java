import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List <String[]> edges = new ArrayList<>();
        String vert1;
        String vert2;

        if(!file.exists() || file.length() == 0) //If file does not exist or there is nothing on the file
        {
            throw new FileNotFoundException(fileName + " does not exists"); //throw exception
        }
        else
        {
            
            while(fileReader.hasNextLine() == true && !line.equals("EDGES")) //while file is not over and have not reached the edges
            {
                line = fileReader.nextLine().trim(); //read line and trim whitespace

                if(!line.equals("EDGES")); //do this when line read doesn't say 'edges'
                {
                    vertices.put(line, index); //add vertices to hashmap
                    index++; //increase hashmap
                }
            }
            vertices.remove("EDGES"); //remove erroneous "EDGE" key from map
            index--; // decrease size of erroneous entry

            Matrix matrix = new Matrix(vertices.size());

            
            int i = 0;
            while(fileReader.hasNextLine())
            {
                line = fileReader.nextLine().trim(); //read from file

                edges.add(line.split("\\s+")); //add edges to arraylist
                matrix.addEdge(vertices.get(edges.get(i)[0]), vertices.get(edges.get(i)[1])); //add edge associations
                i++;
            }

            matrix.print();

            while(exit != 1)
            {

                System.out.println("Enter first vertex:");
                vert1 = userInput.nextLine(); //save userinput for vertices q

                System.out.println("Enter second vertex:");
                vert2 = userInput.nextLine(); //save userinput for vertex 2

                System.out.println(matrix.checkEdge(vertices.get(vert1), vertices.get(vert2))); //print true of false if that association exists


                System.out.println("quit? yes = 1, no = 0"); //prompt user if they would like to end the program
                exit = userInput.nextInt();
                userInput.nextLine();
            }
        }
    }
}