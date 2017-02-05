package reverse.string;

import java.io.*;
import java.util.*;

public class ReverseString {
    String input;
    ReverseString(){
    }
    ReverseString(String i){
        input = i;
    }
    //Iterative Method
    public void reverse(String str1){
        for(int i = str1.length()-1; i>=0;i-- ){
            System.out.print(str1.charAt(i));
        }
        System.out.println();
    }
    //Recursive Method
    public void rec(String st,int i){
        if(i!=st.length()){
            rec(st,i+1);
        }
        if(i<st.length()){
        System.out.print(st.charAt(i));
        }
    }
    //Resursive Method 2
    public void rec2(String st,int i){
        if(i==st.length()){
            return;
        }else {
            rec2(st,i+1);
         System.out.print(st.charAt(i));
        }
    }
    //Resulting ArrayList
    public void codecamp(){
        ArrayList<Character> rslt = new ArrayList<Character>();
        for(int x=input.length()-1;x>=0;x--){
            rslt.add(input.charAt(x));
        }
        printarray(rslt);
    }
    //Using Stack
    public void stack(){
        input = "I'm a stack";
        Stack a = new Stack();
        int limit = 0;
        while(limit!=(input.length())){
            char ch = input.charAt(limit);
            a.push((Character) ch);
        limit++;
        }
        limit = 0;
        System.out.println();
        while(!a.empty()){
            System.out.print(a.pop());
        }

    }
    public void printarray(ArrayList<Character> ch){
     for(int z = 0; z<ch.size();z++){
         System.out.print(ch.get(z));
     }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter the string to reverse\n");
        String result = scan.nextLine();

        ReverseString obj = new ReverseString();
        obj.reverse(result);//Iterative Method
        obj.rec(result, 0);//Recursive Method
        System.out.println();
        obj.rec2(result, 0);//Resursive Method 2
        System.out.println();
        ReverseString reader = new ReverseString("The fox jumps over the fence");
        reader.codecamp();
        obj.stack();

    }

}
