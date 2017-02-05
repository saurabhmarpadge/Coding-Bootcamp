import java.io.*;
import java.util.*;
import java.lang.*;

    class Node{
        String value;
        Node next = null;
        Node(String v, Node n){
            value = v;
            next = n;
        }
    }

    class Cycles{
        void solve(Node head){
            Node result = null;
            Node fast,slow;
            Node prev = null;
            slow = head;
            fast = head;
            boolean loop = true;
            while(loop){
                slow = slow.next;
                if(fast.next != null){
                    prev = fast.next;
                    fast = fast.next.next;
                } else {
                    loop = false;
                    result = null;
                }
                if(slow == fast && loop){
                    result = prev;
                    loop = false;
                } else if(slow == null || fast == null){
                    result = null;
                    loop = false;
                }
            }
            printResult(result);
        }

        void printResult(Node result){
          if(result != null){
              System.out.println("Cycle detected at: "+result.value);
          } else {
              System.out.println("No cycle detected");
          }
        }

        void hasCycle(Node head) {
          Node p1 = head;
          Node p2 = head;
          while(p2!=null){
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null){
                p2 = p2.next;
            }
            if(p1==p2){
               System.out.println("Cycle Detected by Method 2");
               break;
            }
          }
          if(p2==null){
            System.out.println("No Cycles are there");
          }
        }
    }

    public class Detectcycle {

       public static void main(String[] args){
           Node c = new Node("C",null);
           Node b = new Node("B",null);
           Node a = new Node("A",null);
           a.next = b;
           b.next = c;
           c.next = b;
           Cycles cycle = new Cycles();
           cycle.solve(a);
           cycle.hasCycle(a);
     }
}
