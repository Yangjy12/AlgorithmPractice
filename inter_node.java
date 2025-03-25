public class inter_node {
//有点坑这道题，其实就是看图，图上1是两个单独的节点，物理地址并不相同，是从8开始公用的。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            if (p1==null){
                p1=headB;
            }else {
                p1=p1.next;
            }
            if (p2==null){
                p2=headA;
            }else {
                p2=p2.next;
            }
        }
        return p1;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        int lenA=0,lenB=0;
        while(curA!=null){
            lenA++;
            curA=curA.next;
        }
        while (curB!=null){
            lenB++;
            curB=curB.next;
        }
        curA=headA;
        curB=headB;
        if(lenB>lenA){
            int tmplen=lenA;
            lenA=lenB;
            lenB=tmplen;
            ListNode tmpNode=curA;
            curA=curB;
            curB=tmpNode;
        }
        int gap=lenA-lenB;
        while (gap-->0){
            curA=curA.next;
        }
        while(curA!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}
