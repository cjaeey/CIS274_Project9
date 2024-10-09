// Carlos John Escala
// September 18th 2024
// Lab 9, File compression
// This lab determines compression of a file

// Carlos John Escala
// September 25th 2024
// Lab 10, File compression
// This lab determines compression of a file

import java.util.Scanner;

public class CompressedFile
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many 512-byte blocks are available on the storage device? ");
        int blocksOwned = input.nextInt();
        int blockSize = 512;
        System.out.print("How big is the file in bytes? ");
        int fileSize = input.nextInt();
        while (blocksOwned > 0)
        {
            int compressed = (int)(fileSize * 0.8);
            int missingBlocks = (compressed + blockSize - 1) / blockSize;
            if (missingBlocks <= blocksOwned)
            {
                System.out.println("The file will compress to " + compressed + " bytes");
                System.out.println("That will take " + missingBlocks + " blocks.");
                blocksOwned -= missingBlocks;
                System.out.println("You have " + blocksOwned + " blocks available");
                System.out.print("How big is the file in bytes? ");
                fileSize = input.nextInt();
            }
            else
            {
                System.out.println("The file will be compressed to " + compressed + " bytes.");
                System.out.println("That will take " + missingBlocks + " blocks.");
                System.out.println("You have only " + blocksOwned + " blocks. The file cannot be compressed and stored.");
                break;
            }
        }

        System.exit(0);
    }
}
