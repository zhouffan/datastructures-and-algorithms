package com.fuwa.datastructure.linked;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/16 14:19
 * @Description: 约瑟夫环
 */
public class CircleSingleLinkedList {
    private PersonNode first = null;
    private int nums = -1;

    /**
     * 创建一个 nums数量的环
     * @param nums
     */
    public CircleSingleLinkedList(int nums) {
        this.nums = nums;
        createCircle();
    }

    private void createCircle(){
        PersonNode currentNode = null;
        for (int i = 0; i < nums; i++) {
            PersonNode node = new PersonNode(i,
                    "name:"+i, "nickName:"+i);
            if(i == 0){
                first = node;
                currentNode = first;
                first.next = first;
            }else {
                currentNode.next = node;
                node.next = first;
                currentNode = node;
            }
        }

    }

    public void delete(PersonNode node){
        PersonNode nextNode = node.next;
        PersonNode preNode = null;
        PersonNode currentNode = node;
        while (true){
            if(currentNode.next == node){
                //找到前一个节点
                preNode = currentNode;
                break;
            }
            currentNode = currentNode.next;
        }
        if (preNode != null) {
            preNode.next = nextNode;
        }
    }

    /**
     * 遍历环链表
     */
    public void showList(){
        PersonNode currentNode = first;
        while (true){
            System.out.println(currentNode);
            if(currentNode.next == first){
                return;
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * 计算节点出圈顺序
     * @param startNo 开始位置
     * @param countNum 数几下
     */
    public void countPerson(int startNo, int countNum){
        //先找到startNo 节点
        PersonNode startNode = null;
        PersonNode currentNode = first;
        //循环一圈
        do {
            if (currentNode.no == startNo) {
                startNode = currentNode;
            }
            //移动节点
            currentNode = currentNode.next;
        } while (currentNode.next != first);
        System.out.println(startNode);
        while (true){
            PersonNode outNode = startNode;
            for (int i = 0; i < countNum; i++) {
                startNode = startNode.next;
            }
            if(outNode == null){
                return;
            }
            System.out.println(outNode);
            //删除节点
            delete(outNode);
        }
    }

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList(10);
        linkedList.showList();

        System.out.println("\n计算节点出圈顺序:");
        linkedList.countPerson(0, 2);
    }
}
