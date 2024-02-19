import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersOfHanoi {

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt();

        System.out.println("\ntowers(" + n + ", 1, 3)\n");
        towers(n, 1, 3, 1);
    }


    public static void moveDisk(int n, int src, int dest, int recursionLevel) {
        String spaces = "  ".repeat(recursionLevel);
        System.out.println(spaces + "Moving Disk " + n + " from Source " + src + " to Destination " + dest +
                " n=" + n + ", src=" + src + ", dest=" + dest);
    }

    public static void towers(int n, int src, int dest, int recursionLevel) {
        if (n == 1) {
            moveDisk(1, src, dest, recursionLevel);
        } else {
            // Calculate the intermediate peg
            int intermediatePeg = 6 - src - dest;

            // Move n-1 disks from source to intermediate peg
            towers(n - 1, src, intermediatePeg, recursionLevel + 1);

            // Move the nth disk from source to destination
            moveDisk(n, src, dest, recursionLevel);

            // Move the n-1 disks from intermediate peg to destination
            towers(n - 1, intermediatePeg, dest, recursionLevel + 1);
        }
    }
}