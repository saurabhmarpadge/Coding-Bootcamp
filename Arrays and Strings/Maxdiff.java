//package maxdiff;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Maxdiff {

    private int[] arr;
    private int maxDif,maxPos;
    private int minVal,minPos;
    private Stack<Integer> buysell;
    Maxdiff(){
    }
    Maxdiff(int[] input){
        buysell = new Stack<Integer>();
        arr = new int[input.length];
        for(int i=0;i<input.length;i++){
            arr[i]=input[i];
        }
        maxDif=minPos=maxPos=0;
        minVal = arr[0];
    }

    public void solve(){
        int newMax,newMin,diff;
        for(int i=0;i<arr.length;i++){
            newMin = mini(arr[i],minVal);
            if(newMin<minVal){
             minVal=newMin;
             minPos=i;
            }
            diff = arr[i]-minVal;
            newMax = mini(arr[i],diff);
            if(newMax>maxDif){
             maxDif=newMax;
             maxPos=i;
             buysell.push(maxPos);
             buysell.push(minPos);
            }
        }
        printresult();
    }

    public int maxi(int a, int b){
        if(a>b){return a;}else if(a<=b){return b;}
        return -1;
    }

    public int mini(int a, int b){
        if(a<b){return a;}else if(a>=b){return b;}
        return -1;
    }

    public void printresult(){
        System.out.println("Max Diff "+maxDif);
        System.out.println("Max position "+buysell.pop());
        System.out.println("Mix position "+buysell.pop());
    }

    public static void main(String[] args) {
      //Method 1
      ArrayList<Integer> integerArray = new ArrayList<Integer>();
      integerArray.add(-1);
      integerArray.add(5);
      integerArray.add(0);
      integerArray.add(7);
      integerArray.add(2);
      integerArray.add(-3);
      int cost,max,l,h;
      l=h=0;
      max = -999;
      for(int i=0;i<integerArray.size() ;i++){
          for(int j=i+1;j<integerArray.size();j++){
              cost = (integerArray.get(j)-integerArray.get(i));
              if(cost > max){
                  max = cost;
                  l=i;
                  h=j;
              }
          }
      }
      System.out.println("Max profit is "+max+" at days "+(l+1)+" to "+(h+1));

      //Method 2 Using Stack
      Maxdiff obj1 = new Maxdiff(new int[]{-1,5,0,1,2,-3});
      obj1.solve();
    }
  }
