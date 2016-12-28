package merge.two.array;
import java.io.*;
import java.util.*;

public class MergeTwoArray {
    
    void merge(int[] ar1, int[] ar2){
     int p1;
     int p2;
     p1=p2=0;
     ArrayList<Integer> result= new ArrayList<Integer>(); 
     
     while(p1<ar1.length && p2 < ar2.length){
         if(ar1[p1]<ar2[p2]){
          result.add(ar1[p1]);
          p1++;
         } else {
             result.add(ar2[p2]);
             p2++;
         }
     }
     
   
         while(p1<ar1.length){
             result.add(ar1[p1]);
             p1++;
         }
     
     
  
         while(p2<ar2.length){
             result.add(ar1[p2]);
             p2++;
         }
    
     printResult(result);
    }
    void printResult(ArrayList<Integer> result){
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,4,7,9};
        int[] b = new int[]{1,3,5};
        
        MergeTwoArray obj = new MergeTwoArray();
        obj.merge(a,b);
    }
}