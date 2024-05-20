public class Matrix 
{
    boolean [][] matrix;

    Matrix(int size)
    {
        matrix = new boolean[size][size];
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
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
