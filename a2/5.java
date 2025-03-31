
class Series{
    int n;
    int osum=0,esum=0;
    Series(int n){
        this.n=n;
    }
    synchronized void oddSum(){
        for(int i=1;i<=n;i+=2){
            osum+=i;
            notify();
            try {
                if(i<n)
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    synchronized void evenSum(){
        for(int i=2;i<=n;i+=2){
            esum+=i;
            notify();
            try {
                if(i<n)
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
  class Main {
    public static void main(String[] args) {
        Series sr=new Series(100);
        Thread t1=new Thread(()->sr.oddSum());
        Thread t2=new Thread(()->sr.evenSum());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(sr.esum+sr.osum);
    }
}
