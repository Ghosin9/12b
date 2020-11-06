//-----------------------------------------------------------------------------
// BinarySearch.java
//-----------------------------------------------------------------------------

class BinarySearch {

   // binarySearch()
   // pre: Array A[p..r] is sorted
   static int binarySearch(String[] A, int p, int r, String t){
      int q;
      if(p > r) {
         return -1;
      }else{
         q = (p+r)/2;
         if(t.equals(A[q]){
            return q;
         }else if(t.compareTo(A[q]) < 0){
            return binarySearch(A, p, q-1, t);
         }else{ // t.compareTo(A[q]) > 0 aka t>A[q]
            return binarySearch(A, q+1, r, t);
         }
      }
   }

   public static void main(String[] args) {
   
      int[] B = {1,2,3,4,5,6,7,8,9,10};

      System.out.println(binarySearch(B, 0, B.length-1, 7));
      System.out.println(binarySearch(B, 0, B.length-1, 2));
      System.out.println(binarySearch(B, 0, B.length-1, 11));
   }
}