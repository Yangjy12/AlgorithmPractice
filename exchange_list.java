public class exchange_list  {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next=head.next;
        ListNode newNode=swapPairs(next.next);
        next.next=head;
        head.next=newNode;
        return next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode dumyhead=new ListNode(-1);
        dumyhead.next=head;
        ListNode cur=dumyhead;
        ListNode tmp;
        ListNode firstNode;
        ListNode scendNode;
        while(cur.next!=null&&cur.next.next!=null){
            firstNode=cur.next;
            scendNode=cur.next.next;
            tmp=cur.next.next.next;
            cur.next=scendNode;
            scendNode.next=firstNode;
            firstNode.next=tmp;
            cur=firstNode;
        }
        return dumyhead.next;
    }
}
