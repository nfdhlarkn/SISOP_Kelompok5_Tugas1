import java.util.Scanner;

public class PriorityScheduling {

    public static void run(Process[] processes, int n, Scanner sc) {
        for (int i = 0; i < n; i++) processes[i].reset();

        System.out.println("\nMasukkan priority tiap proses (angka terkecil = prioritas tertinggi):");
        for (int i = 0; i < n; i++) {
            System.out.print("  Priority " + processes[i].id + ": ");
            processes[i].priority = readInt(sc);
        }

        boolean[] done = new boolean[n];
        Process[] order = new Process[n];
        String[] gantt = new String[n];
        int currentTime = 0;
        int completed = 0;

        while (completed < n) {
            int idx = -1;
            int highestPrio = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!done[i] && processes[i].arrivalTime <= currentTime) {
                    if (processes[i].priority < highestPrio ||
                        (processes[i].priority == highestPrio && processes[i].arrivalTime < processes[idx].arrivalTime)) {
                        highestPrio = processes[i].priority;
                        idx = i;
                    }
                }
            }

            if (idx == -1) {
                currentTime++;
                continue;
            }

            Process p = processes[idx];
            p.startTime = currentTime;
            p.responseTime = p.startTime - p.arrivalTime;
            p.finishTime = currentTime + p.burstTime;
            p.turnaroundTime = p.finishTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
            currentTime = p.finishTime;
            done[idx] = true;
            gantt[completed] = p.id;
            order[completed] = p;
            completed++;
        }

        Process.printTableWithPriority(order, n);
        System.out.println("\n=== Priority Scheduling (non-preemptive) ===");
        System.out.println("(Priority terkecil = prioritas tertinggi)");
        System.out.println("\nGantt Chart:");
        for (int i = 0; i < n; i++) {
            System.out.print(gantt[i]);
            if (i < n - 1) System.out.print(" | ");
        }
        System.out.println();

        System.out.printf("\n%-8s %-10s %-8s %-8s %-10s %-12s %-10s%n",
                "Proses", "Arrival", "Burst", "Prio", "Waiting", "Turnaround", "Response");

        double totalWT = 0, totalTAT = 0;
        for (int i = 0; i < n; i++) {
            Process p = order[i];
            System.out.printf("%-8s %-10d %-8d %-8d %-10d %-12d %-10d%n",
                    p.id, p.arrivalTime, p.burstTime, p.priority,
                    p.waitingTime, p.turnaroundTime, p.responseTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("\nRata-rata Waiting Time    : %.2f%n", totalWT / n);
        System.out.printf("Rata-rata Turnaround Time : %.2f%n", totalTAT / n);
    }

    static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) { sc.next(); }
        return sc.nextInt();
    }
}
