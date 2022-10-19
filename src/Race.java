public class Race implements Runnable {
    private static String winner = null;

    @Override
    public void run() {
        for (int i = 1; i <= 150; i++) {
            // Регулируем скорость игры
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Имитация сна кролика
            if ("кролик".equals(Thread.currentThread().getName()) && i % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "Убежать" + i + "m");
        }
    }

    public boolean gameOver(int meters) {
        // Уже разделено
        if (winner != null) {
            return true;
        }
        // дошел до конца
        if (meters == 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Победитель есть" + "победитель");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        Race Race = new Race();
        thread1 thread1 = new thread1("раса", "Черепаха");
        thread2 thread2 = new thread2("гонка", "кролик");
        thread1.start();
        thread2.start();
    }
}

