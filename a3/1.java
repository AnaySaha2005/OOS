import java.util.ArrayList;

class Main {
    <T extends Comparable<T>> void sort(int s, int e,T arr[]) {
        if (s == e)
            return;
        int mid = (s + e) / 2;
        sort(s, mid,arr);
        sort(mid + 1, e,arr);
        merge(s, mid, mid + 1, e, arr);
    }

    <T extends Comparable<T>> void merge(int si, int ei, int sj, int ej, T arr[]) {
        ArrayList<T> a = new ArrayList<>();
        int k = si;
        while (si <= ei && sj <= ej) {
            if (arr[si].compareTo(arr[sj]) < 0) {
                a.add(arr[si]);
                si++;
            } else {
                a.add(arr[sj]);
                sj++;
            }
        }
        while (si <= ei) {
            a.add(arr[si]);
            si++;
        }
        while (sj <= ej) {
            a.add(arr[sj]);
            sj++;
        }
        for (int i = 0; i < a.size(); i++)
            arr[k++] = a.get(i);
    }

    public static void main(String[] args) {
        Integer arr[] = (new Integer[] { 4, 5, 7, 3, 2, 5, 9, 1 });
        Main ob=new Main();
        ob.sort(0, arr.length-1,arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
