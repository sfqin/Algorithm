package smartZ.day4;

class Node {
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}


class RandomNode {
    int label;
    RandomNode next = null;
    RandomNode random = null;

    RandomNode(int label) {
        this.label = label;
    }
}

public class Main {


    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public Node Merge(Node pHead1,Node pHead2) {


        return null;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public Node FindFirstCommonNode(Node pHead1, Node pHead2) {

        return null;
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public Node deleteDuplication(Node pHead) {

        return null;
    }


    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param pHead
     * @return
     */
    public RandomNode Clone(RandomNode pHead) {


        return null;
    }

    public static void main(String[] args) {

    }
}
