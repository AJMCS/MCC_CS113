public class Asset implements Comparable<Asset>
{
    private String name;
    private int quantity;

    Asset(String name, int quantity)
    {
        this.name = name;
        this.quanitity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setQuantity(int quantity)
    {
        if(quantity < 0)
        {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        else
        {
            this.quantity = quantity;
        }
    }
}
