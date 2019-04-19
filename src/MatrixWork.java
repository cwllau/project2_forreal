import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class MatrixWork
{
    public static int[][] matrixProduct(int[][] A, int[][] B)
    {
        // you can assume that A and B are valid arrays with > 0 number of rows and columns.

        int k = B.length;
        int[][] C = new int[A.length][B[0].length];

        if(A[0].length != B.length)
        {
            System.err.println("A and B are not the same length..");
            System.exit(1);
//            throw new IllegalArgumentException();
        }
        else {



            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    for (int l = 0; l < k; l++) {
                        C[i][j] += (A[i][l]) * (B[l][j]);
                    }
                }
            }


        }
        return C;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter input file name: ");
        String filename = scan.nextLine();

        File f = new File(filename);


        Scanner file = null;
        try
        {
            file = new Scanner(f);
            int ACol = file.nextInt();
            int ARow = file.nextInt();

            int[][] A = new int[ACol][ARow];


            for(int i = 0; i < A.length; i ++)
            {
                for(int j = 0; j < A[0].length; j++)
                {
                    A[i][j] = file.nextInt();
                }
            }

            int BCol = file.nextInt();
            int BRow = file.nextInt();

            int[][] B = new int[BCol][BRow];

            for(int i = 0; i < B.length; i ++)
            {
                for(int j = 0; j < B[0].length; j++)
                {
                    B[i][j] = file.nextInt();
                }
            }
            file.close();



            int[][] C = matrixProduct(A,B);

            System.out.println("Product Matrix:");

            for(int i = 0; i < C.length; i++)
            {
                for(int j = 0; j < C[0].length; j++)
                {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();

            }

        }
        catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + filename);
        }





    }
}
