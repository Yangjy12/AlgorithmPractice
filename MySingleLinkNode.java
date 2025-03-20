public class MySingleLinkNode {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//    链表大小
    private int size;
//    虚拟头结点
    private ListNode head;
//    初始化链表
    public MySingleLinkNode(){
        this.size = 0;
        this.head = new ListNode(0);
    }
//    获取链表中第 index 个节点的值。如果索引无效，则返回-1
    public int get(int index){
        if(index<0 || index>=size){
            return -1;
        }
//        如果直接使用 head = head.next，会不断改变 head 的指向，这会导致原链表的头节点丢失，链表结构被破坏
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
//    在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
    public void addAtHead(int val){
        ListNode newHead = new ListNode(val);
//        不写的话会丢失原来的链表啊！！！
        newHead.next = head.next;
        head.next = newHead;
        size++;
    }
//    addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val){
        ListNode newTail = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newTail;
        size++;
    }
//    addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
//    如果 index 等于链表的长度，则该节点将附加到链表的末尾。
//    如果 index 大于链表长度，则不会插入节点。
//    如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val){
        if (index<0){
            addAtHead(val);
        }
        if (index==size){
            addAtTail(val);
        }
        if (index>size){
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }
//    deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index){
        if (index<0 || index>=size){
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
