import implementations.DoublyLinkedList;
import implementations.Queue;
import implementations.ReversedList;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> integerQueue = new Queue<>();
//        integerQueue.offer(1);
//        integerQueue.offer(2);
//        integerQueue.offer(3);
//        int element1 = integerQueue.poll();
//        int element2 = integerQueue.poll();
//        int element3 = integerQueue.poll();
////
//        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addLast(0);
//        list.addLast(-1);
//        list.addLast(-2);
//        Integer integer1 = list.removeFirst();
//        Integer integer2 = list.removeFirst();
//        java.util.ArrayDeque<Integer> stack = new ArrayDeque<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        System.out.println();
//        stack.offer(-1);
//        stack.offer(-2);
//        stack.offer(-3);
//        stack.offer(-4);
//        System.out.println();
//        Integer pop = stack.pop();
//        Integer poll = stack.poll();
//        Integer peek = stack.peek();


//        ArrayDeque<Integer> myDeque = new ArrayDeque<>();
//        boolean empty1 = myDeque.isEmpty();
//        myDeque.addFirst(1);
//        myDeque.addFirst(2);
//        myDeque.addFirst(3);
//        myDeque.addLast(101);
//        myDeque.addLast(102);
//        myDeque.addLast(103);
//        myDeque.addLast(104);
//        myDeque.addLast(105);
//        myDeque.addFirst(4);
//        myDeque.addFirst(5);
//        myDeque.addFirst(6);
//        myDeque.addFirst(7);
//        myDeque.addFirst(8);
//        Integer integer = myDeque.get(5);
//        Integer integer2 = myDeque.get(12);
//        myDeque.insert(2, 10007);
//        myDeque.set(2, 999);
//        Integer poll = myDeque.poll();
//        Integer pop = myDeque.pop();
//        int capacity = myDeque.capacity();
//        Integer pop1 = myDeque.pop();
//        //myDeque.trimToSize();
//        capacity = myDeque.capacity();
//        boolean empty = myDeque.isEmpty();
//        Object o = new Object();
//        o = Integer.valueOf("105");
//        myDeque.remove(o);
//        Object o1 = new Object();
//        o1 = Integer.valueOf("103");
//        myDeque.remove(o1);
//        myDeque.remove(5);
//        Object o2 = Integer.valueOf("6");
//        myDeque.remove(o2);
//        myDeque.offer(777);
//        myDeque.add(555);
//

        ReversedList<Integer> reversedList = new ReversedList<>();
        reversedList.add(1);
        reversedList.add(2);
        reversedList.add(3);
        reversedList.add(4);
        reversedList.add(5);
        int capacity = reversedList.capacity();

        int size = reversedList.size();

        reversedList.get(3);

        reversedList.removeAt(3);
        reversedList.size();
        Iterator<Integer> iterator = reversedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
