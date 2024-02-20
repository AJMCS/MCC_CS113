
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class DirectoryEntry 
{
  
  //instantiate relevant variables
  private String name;
  private String number;


    
    //Add constructor that assigns name and number
    public DirectoryEntry(String name, String number)
    {
        this.name = name;
        this.number = number;

    }

    //Add empty constructor
    public DirectoryEntry()
    {
        this.name = null;
        this.number = null;
        
    }

    
    
    //Update stored data
    public void setName(String name)
    {
          this.name = name;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    
    
    //Retrieve stored data
    public String getName()
    {
        return name;
    }
    
    public String getNumber()
    {
        return number;
    }

    public String toString()
    {
        return "\n\n" + name + "\n" + number + "\n\n";
    }

}

