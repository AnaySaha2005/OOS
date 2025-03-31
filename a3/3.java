import java.util.HashMap;

class Duplicate<T> {
    T arr[];

    Duplicate(T arr[]) {
        this.arr = arr;
        HashMap<T,Integer>map=new HashMap<>();
        for(T a:this.arr){
            map.put(a,map.getOrDefault(a, 0)+1);
        }
        for(T key:map.keySet()){
            if(map.get(key)>1)System.out.println(key);
        }
    }
}
class Main{
    public static void main(String[] args) {
        Duplicate<Integer>dup=new Duplicate<>(new Integer[]{1,2,4,3,2,5,6,7,5,8,9,10});
    }
}
