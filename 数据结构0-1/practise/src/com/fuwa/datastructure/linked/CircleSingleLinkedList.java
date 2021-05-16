package com.fuwa.datastructure.linked;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/16 14:19
 * @Description: 约瑟夫环
 */
public class CircleSingleLinkedList {
    private PersonNode first = null;
    private int nums;

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

    /**
     * 删除某个节点
     * @param node
     */
    public void delete(PersonNode node){
        if(node == null){
            System.out.println("该节点为 null");
            return;
        }
        PersonNode currentNode = node;
        PersonNode nextNode = node.next;
        PersonNode preNode;
        while (true){
            if(currentNode.next == node){
                //找到前一个节点
                preNode = currentNode;
                break;
            }
            currentNode = currentNode.next;
        }
        //更新第一个节点
        if(preNode.next.no == first.no){
            first = nextNode;
        }
        preNode.next = nextNode;
    }

    /**
     * 根据no查找节点
     * @param startNo
     * @return
     */
    private PersonNode findPersonNodeByNo(int startNo){
        if(first.no == startNo){
            return first;
        }
        PersonNode currentNode = first.next;
        //判断当前节点是否是第一个
        while (currentNode != first){
            if(currentNode.no == startNo){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
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
        if(startNo > (nums - 1)){
            System.out.println("起始no 大于总数");
            return;
        }
        //先找到startNo 节点
        PersonNode startNode = findPersonNodeByNo(startNo);
        System.out.println("startNode=====>"+startNode);
        while (true){
            PersonNode outNode;
            for (int i = 0; i < countNum; i++) {
                startNode = startNode.next;
            }
            outNode = startNode;
            //最后一个自己
            if(outNode.next == outNode){
                System.out.println(outNode);
                return;
            }
            //删除节点
            delete(outNode);
            System.out.println(outNode);
        }
    }

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList(10);
        linkedList.showList();

        System.out.println("\n计算节点出圈顺序:");
        PersonNode personNodeByNo = linkedList.findPersonNodeByNo(10);
//        System.out.println(personNodeByNo);
//        linkedList.delete(personNodeByNo);
//        linkedList.showList();
//        System.out.println();
        linkedList.countPerson(1, 2);
    }
}
