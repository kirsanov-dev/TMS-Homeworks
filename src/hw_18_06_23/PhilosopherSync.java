package hw_18_06_23;

// Сделать задачу с философами, при условии, что за столом может сидеть только 1 философ,
// синхронизировать доступ к критической секции через synchronized

class DiningTable {
    int availableSeats = 1;
}

class PhilosopherSync extends Thread {
    DiningTable diningTable;
    int num = 1;
    int id;
    PhilosopherSync(DiningTable diningTable, int id) {
        this.diningTable = diningTable;
        this.id = id;
    }

    public void run() {

            try {
                // пока количество приемов пищи не достигнет 3
                while (num < 4) {
                    synchronized (diningTable) {
                        while (diningTable.availableSeats == 0) {
                            diningTable.wait();
                        }
                        diningTable.availableSeats--;
                        System.out.println("Философ " + id + " садится и совершает " + num + "-й прием пищи");
                    }

                    // философ ест
                    sleep(5000);
                    num++;

                    synchronized (diningTable) {
                        System.out.println("Философ " + id + " закончил кушать и пошел на прогулку");
                        diningTable.availableSeats++;
                        diningTable.notifyAll();
                    }

                    // философ гуляет
                    sleep(5000);
                }
            } catch (InterruptedException e) {
                System.out.println("у философа " + id + " проблемы со здоровьем");
            }
    }
}
