import java.util.Random;

public class SortTechniques {

    public static void main(String[] args) {
        Random random = new Random();
        int numOfArrays = 4;
        int sizeOfArrays = 10;
        int[][] myArray = FillMyArray(numOfArrays, sizeOfArrays, random);

        for(int i = 0; i < numOfArrays; i++)
        {
            for (int j = 0; j< sizeOfArrays; j++)
            {
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] FillMyArray(int numOfArrays, int sizeOfArrays, Random random) {
        int[][] temp = new int[numOfArrays][sizeOfArrays];
        temp[0] = fillArrayAscending(sizeOfArrays, random);
        temp[1] = fillArrayDescending(sizeOfArrays, random);
        temp[2] = fillArrayRandom(sizeOfArrays, random);
        temp[3] = fillArrayNearlySorted(sizeOfArrays, random);
        return temp;
    }

    public static int[] fillArrayAscending(int sizeOfArrays, Random random) {
        int[] tempArray = new int[sizeOfArrays];
        int numRand = random.nextInt(10);
        for (int i = 0; i < sizeOfArrays; i++) {
            tempArray[i] = numRand;
            numRand += random.nextInt(10);
        }
        return tempArray;
    }

    public static int[] fillArrayDescending(int sizeOfArrays, Random random) {
        int[] tempArray = new int[sizeOfArrays];
        int numRand = random.nextInt(100);
        for (int i = 0; i < sizeOfArrays; i++) {
            tempArray[i] = numRand;
            numRand -= random.nextInt(10);
        }
        return tempArray;
    }

    public static int[] fillArrayRandom(int sizeOfArrays, Random random) {
        int[] tempArray = new int[sizeOfArrays];
        for (int i = 0; i < sizeOfArrays; i++) {
            tempArray[i] = random.nextInt(100);
        }
        return tempArray;
    }

    public static int[] fillArrayNearlySorted(int sizeOfArrays, Random random) {
        int[] tempArray = new int[sizeOfArrays];
        int threshold = (int) (0.9 * (sizeOfArrays - 1));
        int numRand = random.nextInt(10);

        for (int i = 0; i < sizeOfArrays; i++) {
            tempArray[i] = numRand;
            numRand = (i < threshold) ? numRand + random.nextInt(10) : random.nextInt(10);
        }
        return tempArray;
    }
}
