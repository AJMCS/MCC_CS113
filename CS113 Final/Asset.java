public class Asset implements Comparable<Asset>
{
    private String name;
    private int quantity;

    Asset(String name, int quantity)
    {
        setName(name);
        setQuantity(quantity);
    }

    Asset(Asset asset)
    {
        name = asset.getName();
        quantity = asset.getQuantity();
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

    @Override
    public int compareTo(Asset o) 
    {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString()
    {
        return "Asset{name='" + name + "' quantity=" + quantity + "}";
    }
}
