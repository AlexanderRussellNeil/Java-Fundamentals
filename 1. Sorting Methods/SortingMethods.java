import java.util.Random;

public class SortingMethods {

    public static void main(String[] args) {
        Random random = new Random();
        int numOfArrays = 4;
        int sizeOfArrays = 10;
        int[][] myArray = FillMyArray(numOfArrays, sizeOfArrays, random);

        System.out.println("Initial Arrays");
        for(int i = 0; i < numOfArrays; i++)
        {
            System.out.print((i+1) + " : ");
            for (int j = 0; j< sizeOfArrays; j++)
            {
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();


        System.out.println("Buble Sort:");
        for(int i = 0; i < numOfArrays; i++)
        {
            System.out.print((i+1) + " : ");
            BubleSort(myArray[i], sizeOfArrays);
            System.out.println();
        }
        System.out.println();

        System.out.println("Selection Sort:");
        for(int i = 0; i < numOfArrays; i++)
        {
            System.out.print((i+1) + " : ");
            SelectionSort(myArray[i], sizeOfArrays);
            System.out.println();
        }
        System.out.println();

        System.out.println("Insertion Sort:");
        for(int i = 0; i < numOfArrays; i++)
        {
            System.out.print((i+1) + " : ");
            InsertionSort(myArray[i], sizeOfArrays);
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

    public static void BubleSort(int[] array, int arraySize)
    {
        long startTime = System.nanoTime();
        for(int i = arraySize; i >= 0; i--)
        {
            for(int j = 1; j < i; j++)
            {
                if(array[j] < array[j-1])
                {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        for(int i = 0; i < arraySize; i++)
        {
            System.out.print(array[i] + "\t");
        }
        System.out.print(" Time: " + elapsedTime);
    }

    public static void SelectionSort(int[] array, int arraySize)
    {
        long startTime = System.nanoTime();       
        for(int i = arraySize; i > 0; i--)
        {
            int indexOfMaxValue = 0;
            for(int j = 1; j < i; j++)
            {
                if(array[indexOfMaxValue] <= array[j])
                {
                    indexOfMaxValue = j;
                }
            }
            int temp = array[i-1];
            array[i-1] = array[indexOfMaxValue];
            array[indexOfMaxValue] = temp;
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        for(int i = 0; i < arraySize; i++)
        {
            System.out.print(array[i] + "\t");
        }
        System.out.print(" Time: " + elapsedTime);
    }

    public static void InsertionSort(int[] array, int arraySize)
    {
        long startTime = System.nanoTime();       
        for(int i = 0; i < arraySize - 1; i++)
        {
            if(array[i]>array[i+1])
            {
                for(int j = i + 1; (array[j-1] > array[j]) && (j > 0); j--)
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        for(int i = 0; i < arraySize; i++)
        {
            System.out.print(array[i] + "\t");
        }
        System.out.print(" Time: " + (long)(elapsedTime));

    }
}
