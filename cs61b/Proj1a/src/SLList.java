/**
 * Created by mia on 05/01/2018.
 * SLList hides the truth of the nakedness within IntList.
 */
public class SLList {

    private static class IntNode {
        // static: never looks outwards, never uses any of SLList's instance variables or methods.

        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }

    }

    private IntNode first;

    public SLList (int x){
        first = new IntNode(x, null);
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x){

        IntNode p = first;

       while(p.next != null ){
           p = p.next;
       }

       p.next = new IntNode(x,null);

    }

    private static int size(IntNode p){
        if(p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size(){

        return size(first);

        // This method is similar to the addLast();
        //        int size = 0;
//        IntNode p = first;
//        while(p.next != null ){
//            p = p.next;
//            size ++;
//        }
//
//        return size + 1;

        // Test...
//        IntNode p = first;
//        if(p.next == null){
//            return 1;
//        }
//        return 1 + p.next.size();
    }



    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
    }

}
