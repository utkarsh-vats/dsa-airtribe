class Node {
    int value;
    Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class DoubleNode {
    int value;
    DoubleNode next;
    DoubleNode prev;

    DoubleNode(int value, DoubleNode next, DoubleNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

public class LinkedList {
    static void printLL(Node head) {
        Node temp = head;
        if (temp == null) {
            System.out.println("null");
            return;
        }
        while (temp != null) {
            System.out.print(temp.value + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
        return;
    }

    static int size(Node head) {
        int count = 0;
        if (head == null) {
            return 0;
        }
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node future = null;
        while (curr != null) {
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        head = prev;
        return head;
        // printLL(head);
    }

    static Node reverseLinkedListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    static Node returnMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node returnSecondMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // static Node deleteMiddle(Node head) {
    // Node slow = head;
    // Node fast = head;
    // Node prev = null;
    // }

    static boolean isPalindrome(Node head) {
        /*
         * [1] -> [2] -> [3] -> [2] -> [1]
         * i. get mid - using first even
         * ii. secondHead = mid.next
         * iii. break at mid
         * iv. reverse second LL
         * v. compare both LL
         */

        Node h1 = head;
        Node mid = returnMiddle(head);
        Node h2 = mid.next;
        mid.next = null;
        h2 = reverseLinkedList(h2);
        while (h1 != null && h2 != null) {
            if (h1.value != h2.value) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        Node t1 = head;
        Node t2 = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                t2 = slow;
                while (t1 != t2) {
                    t1 = t1.next;
                    t2 = t2.next;
                }
                return t1;
            }
        }
        return null;
    }

    static int lengthOfCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                slow = slow.next;
                while (slow != fast) {
                    count++;
                    slow = slow.next;
                }
                return count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // ...
        Node n1 = new Node(10, null);
        Node n2 = new Node(20, null);
        Node n3 = new Node(30, null);
        Node n4 = new Node(30, null);
        Node n5 = new Node(20, null);
        Node n6 = new Node(10, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        // ...
        // System.out.println(size(n1));
        // LinkedList.printLL(n1);
        // LinkedList.printLL(reverseLinkedList(n1));
        // LinkedList.printLL(returnMiddle(n1));
        // System.out.println("is palindrome?: " + isPalindrome(n1));
        // System.out.println("has cycle?: " + hasCycle(n1));
        System.out.println(
                "length of cycle: " + (lengthOfCycle(n1) > 0 ? String.valueOf(lengthOfCycle(n1)) : "no cycle"));
    }
}