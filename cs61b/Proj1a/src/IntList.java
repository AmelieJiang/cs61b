/**
 * Created by mia on 05/01/2018.
 */

// The difference btw a list and an array is that a list is going to be able to grow arbitrary large, unlike java array, which is a fixed size.
public class IntList {

    public int first;
    public IntList rest;

    public IntList(int first, IntList rest){
        this.first = first;
        this.rest = rest;
    }

    public int size(){
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int interativeSize(){
        IntList p = this;
        int size = 0;
        while(p != null){
            size += 1;
            p = p.rest;
        }
        return size;
    }

    public int get(int i){
        if (i == 0){
            return first;
        }
        return rest.get(i - 1);
    }


    public static void main(String[] args) {
//        IntList L = new IntList(5, null);
//        L.rest = new IntList(10, null);
//        L.rest.rest = new IntList(15, null);

        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.get(2));

    }

}
