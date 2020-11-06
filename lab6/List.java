/*------------------------------------------------------------------------------
Ly Phung 
lynphung
12M
5/19/19
List.java that creates the List ADT with the necessary operators and states.
List.java
------------------------------------------------------------------------------*/

@SuppressWarnings("overrides")
class List<T> implements ListInterface<T>
{
   private class Node
   {
      private T item;
      private Node next;

      Node(T x)
      {
         item = x;
         next = null;
      }
   }

   private Node head;
   private int numItems;

   public List()
   {
      head = null;
      numItems = 0;
   }

   public boolean isEmpty()
   {
      return (numItems == 0);
   }

   public int size()
   {
      return numItems;
   }

   public T lookup(T search)
   {
      Node N = head;
      for(; N!= null; N= N.next)
      {
         if (N.item.equals(search))
            return N.item;
      }
      return null;
   }

   public T get(int index) throws ListIndexOutOfBoundsException
   {
      if (index<1 || index>numItems)
      {
         throw new ListIndexOutOfBoundsException("List Error: get() called on invalid index: " + index);
      }

      Node N = head;
      for(int x = 1; x < index; x++)
      {
         N = N.next;
      }
      return N.item;
   }

   // add
   // inserts newItem in this List at position index
   // pre: 1 <= index <= size()+1
   // post: !isEmpty(), items to the right of newItem are renumbered
   public void add(int index, T newItem) throws ListIndexOutOfBoundsException
   {
      if (index<1 || index > (numItems+1))
      {
         throw new ListIndexOutOfBoundsException("List Error: get() called on invalid index: " + index);
      }

      if (index==1)
      {
         Node N = new Node(newItem);
         N.next = head;
         head = N;
      }
      else
      {
         Node before = head;
         Node N = head;
         for(int x = 1; x < index; x++)
         {
            before = N;
            N = N.next;
         }
         before.next = new Node(newItem);
         before.next.next = N;
      }

      numItems++;
   }

   public void remove(int index) throws ListIndexOutOfBoundsException
   {
      if (index<1 || index > numItems)
      {
         throw new ListIndexOutOfBoundsException("List Error: get() called on invalid index: " + index);
      }

      if (index==1)
      {
         Node N = head;
         head = head.next;
         N.next = null;
      }
      else
      {
         Node before = head;
         Node N = head;
         for(int x = 1; x < index; x++)
         {
            before = N;
            N = N.next;
         }
         before.next = N.next;
         N.next = null;
      }

      numItems--;
   }

   public void removeAll()
   {
      head = null;
      numItems = 0;
   }

   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      Node N = head;

      for(; N!= null; N = N.next)
      {
         sb.append(N.item).append(" ");
      }

      return new String(sb);
   }

   @SuppressWarnings("unchecked")
   public boolean equals(Object rhs)
   {
      List<T> R = null;

      if (this.getClass()==rhs.getClass())
      {
         R = (List<T>) rhs;
         Node N = this.head;
         Node P = R.head;

         if(this.numItems!=R.numItems)
            return false;

         if(this.numItems==0)
            return true;

         for(; N!= null || P!= null;)
         {
            if (!N.item.equals(P.item))
               return false;
            N = N.next;
            P = P.next;
         }
         return true;
      }
      return false;
   }

}