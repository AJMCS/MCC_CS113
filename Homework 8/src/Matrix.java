public class Matrix 
{
    private boolean [][] matrix;
    private int size;
    private String[] vertexNames = {"A", "B", "C", "D", "E"};



    Matrix(int size)
    {
        matrix = new boolean[size][size];
        this.size = size;
    }

    public void addEdge(int row, int col)
    {
        matrix[row][col] = true;
        matrix[col][row] = true;
    }

    public boolean checkEdge(int row, int col)
    {
        return matrix[row][col] == true;
    }

    public void print()
    {
        System.out.println("      " + vertexNames[0] +  "     " + vertexNames[1] +  "    " + vertexNames[2] +  "    " + vertexNames[3] +  "    " + vertexNames[4]);
        for(int i = 0; i < matrix.length; i++)
        {
            System.out.print(vertexNames[i] +  " | ");
            for(int j = 0; j < matrix.length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
