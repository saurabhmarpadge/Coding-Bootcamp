package removekthlast;

class Node{
String data;
Node next;
    Node(String x,Node y){
        data = x;
        next = y;
    }
}
class kthsolver{
    Node head;
    kthsolver(Node input){
        head = input;
    }
    //Method 1 form Bootcamp
   /* void solve(int k){
        Node pt1=head;
        Node pt2=head;
        
        while(k>0){
            pt2=pt2.next;
            k--;
        }
        
        while(pt2!=null){
            pt2=pt2.next;
            pt1=pt1.next;
        }
        
        Node tmp = pt1.next;
        if(tmp == null){
            pt1.data = null;
            pt1.next = null;
        } else {
            pt1.data = tmp.data;
            pt1.next = tmp.next;
        }  
        printresult();
    }*/
    //Method 2
    void solve(int k){
        Node pt1=head;
        Node pt2=head;
        
        while(k!=0){
            pt2=pt2.next;
            k--;
        }
        
        while(pt2.next!=null){
            pt2=pt2.next;
            pt1=pt1.next;
        }
        pt1.next = pt1.next.next;
        printresult();
    }
    
    void printresult(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
        curr = curr.next;
        }
        System.out.println();
    }
}

//Method 3 Using recursion to find Kth node form last
class Findanddel{
  int kth;
  Node find;
  int counti;
  Node head;
    Findanddel(int input,Node input1){
        kth =input;
        counti = 0;
        head = input1;
    }
    public void rec(Node ptr){

        if(ptr.next==null){
            return;
        }
        rec(ptr.next);
        counti++;
        if(counti==(kth-1)){
        find = ptr;           //It will return the Pointer to be deleted
        }
    }
    public void del(){
    Node curr = head;
        while(curr.next!=find){//It finds the node iteratively and delets it.
               curr = curr.next; 
        }
        curr.next = curr.next.next;
    }
    public void display(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Removekthlast {
    
    public static void main(String[] args) {
       Node a = new Node("A",null);
       Node b = new Node("B",null);
       Node c = new Node("C",null);
       Node d = new Node("D",null);
       Node e = new Node("E",null);
       
       a.next = b;
       b.next = c;
       c.next = d;
       d.next = e;
       e.next = null;
       Findanddel obj = new Findanddel(3,a);
       obj.display();
       obj.rec(a);
       obj.del();
       obj.display();
       kthsolver obj1 = new kthsolver(a);
       obj1.solve(3);
    }
    
}
