//-----------------------------------------------------------------------------
// MergeSort.java
//-----------------------------------------------------------------------------

public class MergeSort {

   // mergeSort()
   // sort subarray A[p...r]
   public static void mergeSort(String[] word, int[] lineNumber, int p, int r){
      int q;
      if(p < r) {
         q = (p+r)/2;
         // System.out.println(p+" "+q+" "+r);
         mergeSort(word, lineNumber, p, q);
         mergeSort(word, lineNumber, q+1, r);
         merge(word, lineNumber, p, q, r);
      }
   }

   // merge()
   // merges sorted subarrays A[p..q] and A[q+1..r]
   public static void merge(String[] word, int[] lineNumber, int p, int q, int r){
      int n1 = q-p+1;
      int n2 = r-q;
      String[] L = new int[n1];
      String[] R = new int[n2];
      int i, j, k;
      int[] left = new int [n1];
      int[] right = new int [n2];

      //copying word array to left and right arrays
      for(i=0; i<n1; i++){
         L[i] = word[p+i];
         left[i] = lineNumber[p+i];
      }
      for(j=0; j<n2; j++){ 
         R[j] = word[q+j+1];
         right[i] = lineNumber[q+1+j];
      }

      //merging the arrays back together
      i = 0; j = 0;
      for(k=p; k<=r; k++){
         if( i<n1 && j<n2 ){
            if(L[i].compareTo(R[j]) < 0){
               word[k] = L[i];
               lineNumber[k] = left[i];
               i++;
            }else{
               word[k] = R[j];
               lineNumber[k] = right[j];
               j++;
            }
         }else if( i<n1 ){
            word[k] = L[i];
            lineNumber[k] = left[i];
            i++;
         }else{ // j<n2
            word[k] = R[j];
            lineNumber[k] = right[j];
            j++;
         }
      }
   }

   public static void main(String[] args) {

      int[] B = {9,8,7,6,5,4,3,2,1};

      mergeSort(B, 0, B.length-1);
      for(int i=0; i<B.length; i++) 
         System.out.print(B[i]+" ");
      System.out.println();
   }
}