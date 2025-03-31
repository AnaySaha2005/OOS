class ParallelSort {
    int arr[];
    ParallelSort(int[] arr){
        this.arr=arr;
    }
    synchronized void search(int s,int target){
        int e=s+9;
        while(s<e){
            int mid=(s+e)/2;
            if(arr[mid]==target){
                System.out.println("Present at "+mid);
                break;
            }
            if(arr[mid]<target)s=mid+1;
            else e=mid-1;
            notify();
            try {
                wait(1000,0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        notify();
    }
}
 class Main {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,18,23,34,46,57,68,89,90,92,98,99,100};
        ParallelSort ps=new ParallelSort(arr);
        for(int i=0;i<arr.length;i+=10){
            int x=i;
            new Thread(()->ps.search(x, 46)).start();
        }

    }
    
}
