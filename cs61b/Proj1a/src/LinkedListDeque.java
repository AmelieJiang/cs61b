//import java.awt.event.ItemEvent;
//
//import org.junit.runner.Runner;
//
//import javafx.util.converter.NumberStringConverter;

public class LinkedListDeque<BiliBili>
{
   private class StuffNode
   {
      public StuffNode prev;
      public BiliBili item;
      public StuffNode next; 

      public StuffNode(StuffNode p, BiliBili i, StuffNode n) {
          prev = p;
          item = i;
          next = n;
      }

   }
   
   private StuffNode sentinel;
   private int size = 0;
   
   
   public LinkedListDeque(){
      this.sentinel = new StuffNode(null,null, null);
      this.sentinel.next = this.sentinel;
      this.sentinel.prev = this.sentinel;
   }
   
   
   /* public LinkedListDeque(BiliBili x) {
      sentinel = new StuffNode(null,null, null);
      sentinel.next = new StuffNode(sentinel,x, sentinel);
      sentinel.prev = sentinel;
      size = 1;
   }
   */
   
   public void addFirst(BiliBili x){
      StuffNode first = new StuffNode(this.sentinel,x, this.sentinel.next);
      sentinel.next.prev = first; 
      sentinel.next = first;
      this.size += 1;
   }
   
 
   public void addLast(BiliBili x){
      StuffNode last = new StuffNode(this.sentinel.prev, x, this.sentinel);  
      sentinel.prev.next = last;
      sentinel.prev = last;
      this.size += 1;
   }

   public boolean isEmpty(){
      if (this.size == 0){
         return true;
      }
      return false;
   }
   
   
   public int size(){
      return size;   
         
   }
  
   public void printDeque(){
      
      StuffNode p = this.sentinel.next;
         
      while (true){
         System.out.print(p.item + " ");
         if (p == sentinel.prev){
            break;
         }
         p = p.next; 
      }      
   }
  
   
 

   
   public BiliBili removeFirst(){
      if (this.size() == 0 ){
         return null;
      }else{
         this.size -= 1;
         StuffNode holder = this.sentinel.next;
      this.sentinel.next = this.sentinel.next.next;
      this.sentinel.next.prev = sentinel; 
      
      holder.prev = null;
      holder.next = null;
      
      return holder.item;
      }
      
   }
   
   public BiliBili removeLast(){
      if(this.size() == 0){
         return null;
      }else{
         this.size -= 1;
         StuffNode holder = this.sentinel.prev;
      this.sentinel.prev = this.sentinel.prev.prev;
      this.sentinel.prev.next = this.sentinel; 
      
      holder.prev = null;
      holder.next = null;
      
      return holder.item;
      }
      
   }
   
   
  
   
   public BiliBili get(int index){
      
      if (this.size() == 0){
         return null;
      }else if (index <= this.size()){
         StuffNode p = this.sentinel.next;
         
         while (index != 0){
            
            p = p.next;
            index--;
         }
         return p.item;
         }else{
            return null;
                  
      }
      
      
     
      
   }
   
   //???????
   public BiliBili getRecursive(int index) {
      //Same as get, but uses recursion.
      //no need to check if null since we have the sentinel, so even a list of length 0 is not null;

      if (index == 0){
          return this.sentinel.next.item;
      }

      StuffNode runner = this.sentinel.next;
      return this.helper(index, runner);
  }

  private BiliBili helper(int ind, StuffNode runner) {
      //base case
      if (ind == 0){
          return runner.item;
      }

      else {
          runner = runner.next;
          return this.helper(ind - 1, runner);
      }
  }
 
    
   
   
  /*
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
   */
   
  

}
