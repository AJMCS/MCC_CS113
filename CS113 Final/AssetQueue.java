import java.util.*;

public class AssetQueue 
{
    //------ Declare all data structures ------\\

    private Queue<Asset> assetQ;
    private PriorityQueue<Asset> priorityQ;

    private List<Asset> sortedAssets;

    private Set<String> assetNames;
    private TreeSet<Asset> assetTree;

    private Map<String, Asset> assetMap;
    private Map<String, Integer> assetIndexMap;

    private boolean[][] matrix;
    private int numberOfAssets;


    public AssetQueue(int maxAssets)
    {
        //Initialize all data structures
        assetQ = new LinkedList<>();
        priorityQ = new PriorityQueue<>(Comparator.comparingInt(Asset::getQuantity));
        sortedAssets = new ArrayList<>();
        assetNames = new HashSet<>();
        assetTree = new TreeSet<>();
        assetMap = new HashMap<>();
        assetIndexMap = new HashMap<>();
        matrix = new boolean[maxAssets][maxAssets]; //set dependency matrix demensions
        numberOfAssets = 0;
    }

    public void addAsset(Asset asset)
    {
        //add boolean method - returns true or false if the element was added. 
        //cannot add multiple instances of the same element in a hashet so it prevents copies from entering the data structures
        if(assetNames.add(asset.getName())) 
        {
            //add asset to all elements
            assetQ.add(asset);
            priorityQ.offer(asset);
            assetNames.add(asset.getName());
            assetTree.add(asset);
            assetMap.put(asset.getName(), asset);
            assetIndexMap.put(asset.getName(), numberOfAssets++);
            sortedAssets.add(asset);

            //sort the sorted assets data structure after the addition of each element
            Collections.sort(sortedAssets);
        }
        else
        {
            //will print if you try to add the same element twice
            System.out.println("Asset already exists");
        }
    }

    public void removeAsset(String name)
    {
        
        Asset asset = assetMap.remove(name); //store the removed asset

        if(asset == null) //see if the asset exists in the map. if it doesn't it will return null.
        {
            System.out.println("Asset does not exist");
        }
        else if(canRetrieveAsset(name) == false) //Check if the asset is dependent on another asset. 
        {
            //If it is, it cannot be removed from the matrix until the asset is it dependent on is removed first.
            System.out.println("Asset is dependent on another asset. Cannot be removed from the matrix.");
        }
        else
        {
            //remove asset from all data structures
            assetQ.remove(asset);
            priorityQ.remove(asset);

            assetNames.remove(asset.getName());
            assetTree.remove(asset);
            sortedAssets.remove(asset);

            int index = assetIndexMap.remove(asset.getName());

            //remove the asset from the dependency matrix
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][index] = false;
                matrix[index][i] = false;
            }
            numberOfAssets--;
        }
    }

    public Asset retrieveAsset()
    {
        Asset asset = assetQ.poll(); //remove the asset at the front of the queue and store it

        if(asset == null) //if there is no asset to return, it will be null
        {
            System.out.println("Asset does not exist"); //tell the user that there was no assets in the queue
            return null; //return null
        }
        else
        {
            //remove asset from all data structures
            priorityQ.remove(asset);
            assetNames.remove(asset.getName());
            assetTree.remove(asset);
            sortedAssets.remove(asset);

            assetMap.remove(asset.getName());
            int index = assetIndexMap.remove(asset.getName());

            //remove asset from dependency matrix
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][index] = false;
                matrix[index][i] = false;
            }
            numberOfAssets--; //decrease the number of assets

            return asset; //return the removed asset
        }
    }

    //------ Return all data structures ------\\

    public int getQueueSize()
    {
        return assetQ.size();
    }

    public Queue<Asset> getQueue()
    {
        return assetQ;
    } 

    public Set<String> getAssetNames()
    {
        return assetNames;
    }

    public Map<String, Asset> getAssetMap()
    {
        return assetMap;
    }

    public PriorityQueue<Asset> getPriorityQueue()
    {
        return priorityQ;
    }

    public TreeSet<Asset> getAssetTree()
    {
        return assetTree;
    }

    List<Asset> getSortedAssets()
    {
        return sortedAssets;
    }

    public void addDependency(String assetName1, String assetName2)
    {
        //Check if both assetnames exist in the map index
        if(assetIndexMap.get(assetName1) == null)
        {
            System.out.println(assetName1 + " does not exist in the queue.");
        }
        else if(assetIndexMap.get(assetName2) == null)
        {
            System.out.println(assetName2 + " does not exist in the queue.");
        }
        else
        {
            //Create one-way dependency
            matrix[assetIndexMap.get(assetName1)][assetIndexMap.get(assetName2)] = true;
        }
    }


    public boolean canRetrieveAsset(String assetName)
    {
        if(assetIndexMap.get(assetName) != null) //Check if the asset exists
        {
            for(int i = 0; i < matrix.length; i++)
            {
                if(matrix[assetIndexMap.get(assetName)][i]) //Checks if the asset is dependent on any of the other assets in the dependecy matrix
                {
                    return false; //If it is dependent, return false
                }
            }
            return true;//Otherwise, return true
        }
        return false; //Return false if the asset does not exist
    }
}
 