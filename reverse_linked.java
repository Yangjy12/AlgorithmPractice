public class reverse_linked {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null) {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    //递归
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }
    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
    //从后向前递归
    ListNode reverseList3(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }
}
