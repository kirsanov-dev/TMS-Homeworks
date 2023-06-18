package hw_18_06_23;

public class Main {

    public static void main(String[] args) {

        DiningTable diningTable = new DiningTable();

        for (int i = 1; i < 6; i++) {
            new PhilosopherSync(diningTable, i).start();
        }
    }
}