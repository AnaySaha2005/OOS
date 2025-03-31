class Series {
    int n;
    int v = 0;
    double val = 1.0;

    Series(int n) {
        this.n = n;
    }

    synchronized void denominator() {
        while (n > 0) {
            v = 1;
            for (int i = 1; i <= n; i++)
                v *= i;
            notify();
            try {
                wait(1000, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void sum() {
        while (n > 0) {
            try {
                wait(1000, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(v);
            val += 1.0 / v;
            n--;
            notify();
        }

    }
}

class Main {

    public static void main(String[] args) {
        Series s = new Series(10);
        Thread t1 = new Thread(() -> s.denominator());
        Thread t2 = new Thread(() -> s.sum());
       
        t2.start();
        t1.start();
        try {
            t2.join();
            t1.join();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s.val);
    }
}