class rev_link_list {

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        
        //as long as the list(first value) is not empty
        while (curr != null) {

            //we will store the current node in a temporary variable
            ListNode nextTemp = curr.next;
            //we will swap the current node as a previous node
            curr.next = prev;
            
            //the previous element will become the current element (swapping)
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
    
        //connecting the nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    
        //reversing the linked list
        ListNode reversedList = reverseList(node1);
    
        //printing the reversed list
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
        //we will get the reversed linked list as our output: 5 4 3 2 1
    }
    
}
