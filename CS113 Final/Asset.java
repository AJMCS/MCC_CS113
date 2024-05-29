public class Asset implements Comparable<Asset>
{
    //Declare private variables
    private String name;
    private int quantity;

    //Create asset from name and quantity given
    Asset(String name, int quantity)
    {
        //use setters to set the name and quanitity
        setName(name);
        setQuantity(quantity);
    }

    //Create asset from another asset
    Asset(Asset asset)
    {
        //use getters to set the name and quantity
        name = asset.getName();
        quantity = asset.getQuantity();
    }

    @Override
    public int compareTo(Asset o) 
    {
        return this.name.compareTo(o.name);
    }

    //toString for printing out to user
    @Override
    public String toString()
    {
        return "Asset{name='" + name + "' quantity=" + quantity + "}";
    }

    //------ Getters ------\\
    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    //------ Setters ------\\
    public void setName(String name)
    {
        this.name = name;
    }
    

    public void setQuantity(int quantity) throws IllegalArgumentException
    {
        if(quantity <= 0) //check if the quanitity is less than or equal to zero
        {
            throw new IllegalArgumentException("Quantity must be greater than zero."); //throw exception
        }
        else
        {
            this.quantity = quantity; //else set the quanitity
        }
    }

}
