//import LinkedListDeque.StuffNode;

public class ArrayDeque<Bili>
{
   
   private Bili[] items;
   private int size;
   private Bili sentinel; 
   
    /** Creates an empty list. */
    public ArrayDeque() {
       
       items = (Bili[])new Object[100];
       sentinel = items[0];
       size = 0;
    }
    
    
    public void resize(int capacity, int newIndex){
       Bili[] a = (Bili[])new Object[capacity];
       System.arraycopy(items, 0, a, newIndex, size);
       items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Bili x) {
       if (size == items.length){
          resize(size * 2,0);       
       }

       items[size] = x; 
       size ++;
    }
    
    public void addFirst(Bili x){
       if (size != 0)
          resize(size,1);      
       items[0] = x; 
       
    }

    /** Returns the item from the back of the list. */
    public Bili getLast() {
     
        return items[size-1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public Bili get(int i) {
    
        return items[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Bili removeLast() {
       Bili last = getLast();
       items[size] = null; // avoid loitering. 
       size = size - 1;
        return last;
    }
    
   

   public static void main(String[] args){
      
      //LinkedListDeque<Integer> list = new LinkedListDeque<>();
      LinkedListDeque<Integer> list = new LinkedListDeque<>();
      list.addFirst(10);
      list.addFirst(5);
      list.addLast(20);

      int count = list.size();
      System.out.println(count);
      
      
      list.printDeque();
      
      System.out.println("******"+ list.get(1));
      
      list.removeLast();
      list.removeFirst();
      count = list.size();
      System.out.println(count);
      list.printDeque();
      
   }
   
  

}
