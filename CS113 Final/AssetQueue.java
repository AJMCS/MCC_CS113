import java.util.*;

public class AssetQueue 
{
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
        assetQ = new LinkedList<>();
        priorityQ = new PriorityQueue<>(Comparator.comparingInt(Asset::getQuantity));

        sortedAssets = new ArrayList<>();

        assetNames = new HashSet<>();
        assetTree = new TreeSet<>();

        assetMap = new HashMap<>();
        assetIndexMap = new HashMap<>();

        matrix = new boolean[maxAssets][maxAssets];
        numberOfAssets = 0;
    }

    public void addAsset(Asset asset)
    {
        if(assetNames.add(asset.getName()))
        {
            assetQ.add(asset);
            priorityQ.offer(asset);

            assetNames.add(asset.getName());
            assetTree.add(asset);

            assetMap.put(asset.getName(), asset);
            assetIndexMap.put(asset.getName(), numberOfAssets++);

            Collections.sort(sortedAssets);
        }
        else
        {
            System.out.println("Asset already exists");
        }
    }

    public void removeAsset(String name)
    {
        Asset asset = assetMap.remove(name);

        if(asset == null)
        {
            System.out.println("Asset does not exist");
        }
        else
        {
            assetQ.remove(asset);
            priorityQ.remove(asset);

            assetNames.remove(asset.getName());
            assetTree.remove(asset);

            int index = assetIndexMap.remove(asset);

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
        Asset asset = assetQ.poll();

        if(asset == null)
        {
            System.out.println("Asset does not exist");
            return null;
        }
        else
        {
            priorityQ.remove(asset);

            assetNames.remove(asset.getName());
            assetTree.remove(asset);

            assetMap.remove(asset);
            int index = assetIndexMap.remove(asset);

            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][index] = false;
                matrix[index][i] = false;
            }
            numberOfAssets--;

            return asset;
        }
    }

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

    }

    public boolean canRetrieveAsset(String assetName)
    {
        return assetNames.contains(assetName);
    }
}
