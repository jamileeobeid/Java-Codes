public class remove_duplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; //skipping duplicate
            } else {
                current = current.next;
            }
        }
        
        return head;
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
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        // Connect the nodes
        node1.next = node2;
        node2.next = node3;

        // Call deleteDuplicates to remove duplicates
        ListNode result = new remove_duplicates().deleteDuplicates(node1);

        // Print the modified list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        //output will be: 1 2, this is because we removed the duplicate: 1
    }

}
