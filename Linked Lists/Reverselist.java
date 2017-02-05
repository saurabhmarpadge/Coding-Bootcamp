class Node{
    String data;
    Node next = null;
    Node(String x,Node y){
        data = x;
        next = y;
    }
}

class ReversingList{
    Node head = null;
    ReversingList(Node input){
        head = input;
    }
    ReversingList(){
    }
    public void solve(){
        Node prev = null;
        Node curr = head;
        Node forw = head.next;
        while(curr!=null){
          curr.next = prev;
          prev = curr;
          curr = forw;
          if(forw!=null){
              forw = forw.next;
          }
        }
        head = prev;
        printResult();
    }

    public void printResult(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public void rec(Node ptr){
        if(ptr.next==null){
            head = ptr;
            return;
        }
        rec(ptr.next);
        Node tmp = ptr.next;
        tmp.next = ptr;
        ptr.next = null;
    }
}

public class Reverselist {
    public static void main(String[] args) {
        Node a =  new Node("A",null);
        Node b =  new Node("B",null);
        Node c =  new Node("C",null);
        Node d =  new Node("D",null);
        Node e =  new Node("E",null);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        System.out.print("Orignal string \nA B C D E \nNow reversing it\n");
        ReversingList obj = new ReversingList(a);
        obj.solve();
        ReversingList re = new ReversingList();
        re.rec(e);
        System.out.println("Now reversing to Original");
        re.printResult();
    }

}
