public class FCFS {

    public static void run(Process[] processes, int n) {
        for (int i = 0; i < n; i++) processes[i].reset();

        Process[] sorted = new Process[n];
        for (int i = 0; i < n; i++) sorted[i] = processes[i];
        Process.sortByArrival(sorted, n);

        String[] gantt = new String[n];
        int currentTime = 0;

        for (int i = 0; i < n; i++) {
            Process p = sorted[i];
            if (currentTime < p.arrivalTime) currentTime = p.arrivalTime;
            p.startTime = currentTime;
            p.responseTime = p.startTime - p.arrivalTime;
            p.finishTime = currentTime + p.burstTime;
            p.turnaroundTime = p.finishTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
            currentTime = p.finishTime;
            gantt[i] = p.id;
        }

        Process.printTable(sorted, n);
        printResult("FCFS", sorted, gantt, n);
    }

    static void printResult(String label, Process[] processes, String[] gantt, int n) {
        System.out.println("\n=== " + label + " Scheduling ===");
        System.out.println("\nGantt Chart:");
        for (int i = 0; i < n; i++) {
            System.out.print(gantt[i]);
            if (i < n - 1) System.out.print(" | ");
        }
        System.out.println();

        System.out.printf("\n%-8s %-10s %-8s %-10s %-12s %-10s%n",
                "Proses", "Arrival", "Burst", "Waiting", "Turnaround", "Response");

        double totalWT = 0, totalTAT = 0;
        for (int i = 0; i < n; i++) {
            Process p = processes[i];
            System.out.printf("%-8s %-10d %-8d %-10d %-12d %-10d%n",
                    p.id, p.arrivalTime, p.burstTime, p.waitingTime, p.turnaroundTime, p.responseTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("\nRata-rata Waiting Time    : %.2f%n", totalWT / n);
        System.out.printf("Rata-rata Turnaround Time : %.2f%n", totalTAT / n);
    }
}
