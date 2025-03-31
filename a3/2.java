import java.util.HashMap;
class Main {
    <T> void findMax(T arr[]) {
        HashMap<T, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        T max = arr[0];
        for (T key : map.keySet()) {
            if (map.get(key) > map.get(max))
                max = key;
        }
        System.out.println(max + " : " + map.get(max));
    }
    public static void main(String[] args) {
        Integer[]arr=(new Integer[] { 2, 3, 4, 5, 6, 4, 3, 2, 1, 4, 6, 3, 8, 4,4 });
        Main ob=new Main();
        ob.findMax(arr);
        ob.findMax(new Character[]{'a','e','r','t','r'});
    }
}