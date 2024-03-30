public class Document
{
    //private variables
    private String name;
    private int pages;


    //Empty Constructor
    public Document()
    {
        this.name = "Untitled";
        this.pages = 1;
    }

    //Full Contructor
    public Document(String name, int pages)
    {
        
        if(pages <= 0)
        {
            throw new IllegalArgumentException("The number of pages cannot be less the or equal to zero.");
        }else
        {
            this.name = name;
            this.pages = pages;
        }   
    }

    //add document via object
    public Document(Document doc)
    {
        this.name = doc.getName();
        this.pages = doc.getPages();
    }

    //Add document via number of pages
    public Document(int pages)
    {
        
        if(pages <= 0)
        {
            throw new IllegalArgumentException("The number of pages cannot be less the or equal to zero.");
        }else
        {
            this.name = "Untitled";
            this.pages = pages;
        }
        
    }


    //Page setter
    public void setPages(int pages)
    {
        this.pages = pages;
    }
    
    //Page getter
    public int getPages()
    {
        return pages;
    }

    //Name setter
    public void setName(String name)
    {
        this.name = name;
    }
    
    //Name getter
    public String getName()
    {
        return name;
    }

    //Printout
    public String toString()
    {
        return "Document name: " + name + " | Page Count: " + pages;
    }
}