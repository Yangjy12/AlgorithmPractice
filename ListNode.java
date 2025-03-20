import java.util.List;

public class ListNode {
//    结点的值
    int val;
    //下一个结点
    ListNode next;
//    无参构造函数
    public ListNode() {}
//    有参构造函数
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public ListNode removeElements(ListNode head, int val) {
//        对链表的头结点进行判断
        while (head!=null && head.val == val) {
            head=head.next;
        }
        ListNode curr = head;
        while(curr!=null&&curr.next!=null){
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }else {
                curr=curr.next;
            }
        };
        return head;
    }
    public ListNode removeElements2(ListNode head, int val) {
        // 设置一个虚拟的头结点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    //递归
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next=removeElements3(head.next,val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }


}
