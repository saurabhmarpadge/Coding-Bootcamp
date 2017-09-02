import java.util.*;
import java.lang.*;

public class Hanoi {
    private Stack<Integer> disks;

    Hanoi(int n){
        disks = new Stack<Integer>();
    }
    public void add(int value){
        if(disks.isEmpty()){
            disks.push(value);
        } else if(disks.peek() >= value){
            disks.push(value);
        }
    }

    public void transferDisk(Hanoi tower){
        int top = disks.pop();
        tower.add(top);
    }
    public void solve(int n, Hanoi dest, Hanoi spare){
        if(n>0){
            solve(n-1,spare,dest);
            transferDisk(dest);
            spare.solve(n-1, dest, this);
        }
    }
    public void printDisks(String towerName){
        Integer curr = null;
        System.out.print(towerName + " ");
        if(disks.isEmpty()){
            System.out.print("Empty\n");
        } else {
            while(!disks.isEmpty()){
                curr = disks.pop();
                System.out.print(curr + " ");
            }
        }
    }
    public static void main(String[] args) {
        int numDisks = 5;
        Hanoi[] towers = new Hanoi[numDisks];
        for(int i=0;i<3;i++){
            towers[i] = new Hanoi(i);
        }
        for(int i = numDisks -1;i>=0;i--){
            towers[0].add(i);
        }

        towers[0].solve(numDisks, towers[2], towers[1]);

        System.out.println("After moving:");
        towers[0].printDisks("Tower 1");
        towers[1].printDisks("Tower 2");
        towers[2].printDisks("Tower 3");
    }

}
