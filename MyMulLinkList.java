public class MyMulLinkList {
    class ListNode {
        int val;
        ListNode pre,next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
    private int size;
    //记录链表的虚拟头结点和尾结点
    private ListNode head, tail;
    public MyMulLinkList() {
        //初始化操作
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
        this.head.next = tail;
        this.tail.pre = head;
    }
    public int get(int index) {
        //判断index是否有效
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        //判断是哪一边遍历时间更短
        if(index >= size / 2){
            //tail开始
            cur = tail;
            for(int i = 0; i < size - index; i++){
                cur = cur.pre;
            }
        }else{
            for(int i = 0; i <= index; i++){
                cur = cur.next;
            }
        }
        return cur.val;
    }
    public void addAtIndex(int index, int val) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next.pre=newNode;
        newNode.pre=cur;
        cur.next=newNode;
        size++;
    }
    public void addAtHead(int val) {
        //等价于在第0个元素前添加
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        //等价于在最后一个元素(null)前添加
        addAtIndex(size, val);
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next.next.pre=cur;
        cur.next = cur.next.next;
        size--;
    }

}
