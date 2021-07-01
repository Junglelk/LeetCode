package other;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {
    public static void main(String[] args) {

        CQueue obj = new CQueue();
        obj.appendTail(5);
        obj.appendTail(6);
        System.out.println(obj.deleteHead());
    }
    Deque<Integer> head = new ArrayDeque<Integer>();
    Deque<Integer> tail = new ArrayDeque<Integer>();
    public CQueue() {

    }


    public void appendTail(int value) {
        while(!tail.isEmpty()){
            head.push(tail.pop());
        }
        head.push(value);
    }

    public int deleteHead() {
        while(!head.isEmpty()){
            tail.push(head.pop());
        }
        return (tail.isEmpty() ? -1:tail.pop());
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */