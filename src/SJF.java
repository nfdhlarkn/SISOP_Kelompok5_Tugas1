public class SJF {

    public static void run(Process[] processes, int n) {
        for (int i = 0; i < n; i++) processes[i].reset();

        boolean[] done = new boolean[n];
        Process[] order = new Process[n];
        String[] gantt = new String[n];
        int currentTime = 0;
        int completed = 0;

        while (completed < n) {
            int idx = -1;
            int shortest = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!done[i] && processes[i].arrivalTime <= currentTime) {
                    if (processes[i].burstTime < shortest ||
                        (processes[i].burstTime == shortest && processes[i].arrivalTime < processes[idx].arrivalTime)) {
                        shortest = processes[i].burstTime;
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

        Process.printTable(order, n);
        FCFS.printResult("SJF Non-Preemptive", order, gantt, n);
    }
}
