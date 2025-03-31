import java.io.BufferedReader;
import java.io.FileReader;

class FileThread extends Thread {
    int sum;

    FileThread() {
        sum = 0;
    }

    synchronized void display() {
        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
            String str = br.readLine();
            while (str != null) {
                System.out.println(str);
                str = br.readLine();
                notify();
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            notify();
        }
    }

    synchronized void sum() {
        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
            String str = br.readLine();
            while (str != null) {
                sum += Integer.parseInt(str);
                str = br.readLine();
                notify();
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            notify();
        }
    }
}

class Main {
    public static void main(String[] args) {
        FileThread ft = new FileThread();
        Thread producer = new Thread(new Runnable() {
            public void run() {
                ft.display();
            }
        });
        Thread consumer = new Thread(new Runnable() {
            public void run() {
                ft.sum();
            }
        });
        producer.start();
        consumer.start();
    }
}
