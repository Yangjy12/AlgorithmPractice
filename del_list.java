public class del_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next = head;
        ListNode fast=dummyNode;
        ListNode slow=dummyNode;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        if(slow.next!=null){
            slow.next=slow.next.next;
        }
        return dummyNode.next;
    }
}
