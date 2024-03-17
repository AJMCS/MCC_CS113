public class Document
{

    private String name;
    private int pages;


    //Empty Constructor
    public Document()
    {
        this.name = "";
        this.pages = 0;
    }

    //Full Contructor
    public Document(String name, int pages)
    {
        this.name = name;
        this.pages = pages;
    }

    public Document(Document doc)
    {
        this.name = doc.getName();
        this.pages = doc.getPages();
    }

    public Document(int pages)
    {
        this.name = "Untitled";
        this.pages = pages;
    }


    public void setPages(int pages)
    {
        this.pages = pages;
    }
    public int getPages()
    {
        return pages;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return "Document name: " + name + " | Page Count: " + pages;
    }






}