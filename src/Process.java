public class Process {
    String id;
    int arrivalTime;
    int burstTime;
    int priority;
    int remainingTime;

    int startTime;
    int finishTime;
    int waitingTime;
    int turnaroundTime;
    int responseTime;
    boolean started;

    public Process(String id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.started = false;
    }

    public void reset() {
        this.remainingTime = burstTime;
        this.started = false;
        this.startTime = 0;
        this.finishTime = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.responseTime = 0;
    }

    public static void sortByArrival(Process[] p, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (p[j].arrivalTime > p[j + 1].arrivalTime) {
                    Process tmp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = tmp;
                }
            }
        }
    }

    public static void printTable(Process[] processes, int n) {
        System.out.println("\nDaftar Proses:");
        System.out.printf("%-8s %-12s %-10s%n", "Proses", "Arrival Time", "Burst Time");
        System.out.println("------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8s %-12d %-10d%n",
                    processes[i].id, processes[i].arrivalTime, processes[i].burstTime);
        }
        System.out.println("------------------------------");
    }

    public static void printTableWithPriority(Process[] processes, int n) {
        System.out.println("\nDaftar Proses:");
        System.out.printf("%-8s %-12s %-10s %-8s%n", "Proses", "Arrival Time", "Burst Time", "Priority");
        System.out.println("--------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8s %-12d %-10d %-8d%n",
                    processes[i].id, processes[i].arrivalTime, processes[i].burstTime, processes[i].priority);
        }
        System.out.println("--------------------------------------");
    }
}
