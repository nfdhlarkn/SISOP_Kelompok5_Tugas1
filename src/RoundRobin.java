public class RoundRobin {

    public static void run(Process[] processes, int n, int quantum) {
        for (int i = 0; i < n; i++) processes[i].reset();

        Process[] sorted = new Process[n];
        for (int i = 0; i < n; i++) sorted[i] = processes[i];
        Process.sortByArrival(sorted, n);

        int maxGantt = n * 100;
        int[] queue = new int[maxGantt];
        int head = 0, tail = 0;

        String[] gantt = new String[maxGantt];
        int ganttSize = 0;

        Process[] done = new Process[n];
        int doneCount = 0;

        int currentTime = 0;
        int nextIdx = 0;

        queue[tail++] = nextIdx++;

        while (head < tail) {
            int i = queue[head++];
            Process p = sorted[i];

            if (!p.started) {
                p.startTime = currentTime;
                p.responseTime = p.startTime - p.arrivalTime;
                p.started = true;
            }

            int execTime = Math.min(quantum, p.remainingTime);
            gantt[ganttSize++] = p.id + "(" + execTime + ")";
            p.remainingTime -= execTime;
            currentTime += execTime;

            while (nextIdx < n && sorted[nextIdx].arrivalTime <= currentTime) {
                queue[tail++] = nextIdx++;
            }

            if (p.remainingTime > 0) {
                queue[tail++] = i;
            } else {
                p.finishTime = currentTime;
                p.turnaroundTime = p.finishTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
                done[doneCount++] = p;
            }

            if (head == tail && nextIdx < n) {
                currentTime = sorted[nextIdx].arrivalTime;
                queue[tail++] = nextIdx++;
            }
        }

        Process.printTable(sorted, n);
        System.out.println("\n=== Round Robin Scheduling (Quantum = " + quantum + ") ===");
        System.out.println("\nGantt Chart:");
        for (int i = 0; i < ganttSize; i++) {
            System.out.print(gantt[i]);
            if (i < ganttSize - 1) System.out.print(" | ");
        }
        System.out.println();

        System.out.printf("\n%-8s %-10s %-8s %-10s %-12s %-10s%n",
                "Proses", "Arrival", "Burst", "Waiting", "Turnaround", "Response");

        double totalWT = 0, totalTAT = 0;
        for (int i = 0; i < doneCount; i++) {
            Process p = done[i];
            System.out.printf("%-8s %-10d %-8d %-10d %-12d %-10d%n",
                    p.id, p.arrivalTime, p.burstTime, p.waitingTime, p.turnaroundTime, p.responseTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("\nRata-rata Waiting Time    : %.2f%n", totalWT / n);
        System.out.printf("Rata-rata Turnaround Time : %.2f%n", totalTAT / n);
    }
}
