import java.util.Scanner;

public class BankersAlgorithm {

    public static void run(Scanner sc) {
        System.out.print("Jumlah proses : ");
        int n = sc.nextInt();
        System.out.print("Jumlah resource: ");
        int m = sc.nextInt();

        int[][] allocation = new int[n][m];
        int[][] maximum = new int[n][m];
        int[][] need = new int[n][m];
        int[] available = new int[m];

        System.out.println("\nMasukkan matriks Allocation (" + n + " proses x " + m + " resource):");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + i + " : ");
            for (int j = 0; j < m; j++) allocation[i][j] = sc.nextInt();
        }

        System.out.println("\nMasukkan matriks Maximum (" + n + " proses x " + m + " resource):");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + i + " : ");
            for (int j = 0; j < m; j++) maximum[i][j] = sc.nextInt();
        }

        System.out.print("\nMasukkan vektor Available (" + m + " resource): ");
        for (int j = 0; j < m; j++) available[j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                need[i][j] = maximum[i][j] - allocation[i][j];

        System.out.println("\n=== Banker's Algorithm ===");
        System.out.println("\nNeed Matrix:");
        System.out.printf("%-8s", "");
        for (int j = 0; j < m; j++) System.out.printf("R%-4d", j);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8s", "P" + i);
            for (int j = 0; j < m; j++) System.out.printf("%-5d", need[i][j]);
            System.out.println();
        }

        boolean[] finished = new boolean[n];
        int[] work = new int[m];
        for (int j = 0; j < m; j++) work[j] = available[j];

        int[] safeSeq = new int[n];
        int count = 0;

        while (count < n) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (finished[i]) continue;

                boolean canAllocate = true;
                for (int j = 0; j < m; j++) {
                    if (need[i][j] > work[j]) { canAllocate = false; break; }
                }

                if (canAllocate) {
                    for (int j = 0; j < m; j++) work[j] += allocation[i][j];
                    finished[i] = true;
                    safeSeq[count++] = i;
                    found = true;
                }
            }
            if (!found) break;
        }

        if (count == n) {
            System.out.print("\nSafe Sequence : ");
            for (int i = 0; i < n; i++) {
                System.out.print("P" + safeSeq[i]);
                if (i < n - 1) System.out.print(" -> ");
            }
            System.out.println("\nStatus Sistem : SAFE");
        } else {
            System.out.println("\nStatus Sistem : UNSAFE (potensi deadlock!)");
        }
    }
}
