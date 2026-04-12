import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println("   SIMULATOR SISTEM OPERASI");
            System.out.println("========================================");
            System.out.println("1. CPU Scheduling");
            System.out.println("2. Deadlock Handling (Banker's Algorithm)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    menuScheduling();
                    break;
                case 2:
                    BankersAlgorithm.run(sc);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    static void menuScheduling() {
        Process[] processes = inputProcesses();
        if (processes == null) return;
        int n = processes.length;

        int choice;
        do {
            System.out.println("\n--- CPU Scheduling ---");
            System.out.println("1. FCFS");
            System.out.println("2. SJF Non-Preemptive");
            System.out.println("3. Round Robin");
            System.out.println("4. Priority Scheduling");
            System.out.println("5. Bandingkan semua algoritma");
            System.out.println("0. Kembali");
            System.out.print("Pilih algoritma: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    FCFS.run(processes, n);
                    break;
                case 2:
                    SJF.run(processes, n);
                    break;
                case 3:
                    System.out.print("Masukkan nilai Quantum: ");
                    int q = readInt();
                    RoundRobin.run(processes, n, q);
                    break;
                case 4:
                    PriorityScheduling.run(processes, n, sc);
                    break;
                case 5:
                    System.out.print("Masukkan nilai Quantum untuk RR: ");
                    int qAll = readInt();
                    FCFS.run(processes, n);
                    SJF.run(processes, n);
                    RoundRobin.run(processes, n, qAll);
                    PriorityScheduling.run(processes, n, sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    static Process[] inputProcesses() {
        System.out.print("\nJumlah proses: ");
        int n = readInt();
        if (n <= 0) {
            System.out.println("Jumlah proses harus > 0.");
            return null;
        }

        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nProses ke-" + (i + 1) + ":");
            System.out.print("  ID           : ");
            String id = sc.next();

            System.out.print("  Arrival Time : ");
            int at = readInt();

            System.out.print("  Burst Time   : ");
            int bt = readInt();
            if (bt <= 0) {
                System.out.println("Burst time harus > 0, ulangi.");
                i--;
                continue;
            }

            processes[i] = new Process(id, at, bt);
        }

        return processes;
    }

    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Input tidak valid, masukkan angka: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
