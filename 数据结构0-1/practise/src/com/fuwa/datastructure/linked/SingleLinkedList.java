package com.fuwa.datastructure.linked;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/14 23:00
 * @Description:
 */
public class SingleLinkedList {
    /**
     * 定义头节点，没有实际数据
     */
    private PersonNode head = new PersonNode(0, "","");

    /**
     * 添加节点
     * @param newNode
     */
    public void addLast(PersonNode newNode){
        PersonNode tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        //查找到最后一个节点，然后添加newNode
        tempNode.next = newNode;
    }

    /**
     *  按序号添加节点:插入 （假如都是按照序号添加）
     * @param node
     */
    public void addByOrder(PersonNode node){
        PersonNode tempNode = head;
        while (tempNode.next != null){
            PersonNode next = tempNode.next;
            //插入的no更小，则抛弃当前次
            if(node.no < next.no){
                break;
            }
            //查找下一个
            tempNode = next;
        }
        //插入
        node.next = tempNode.next;
        tempNode.next = node;
    }

    /**
     * 更新节点， 根据no
     * @param newNode
     */
    public void update(PersonNode newNode){
        PersonNode nextNode = head.next;
        if(nextNode == null){
            System.out.println( "空...");
        }
        while (nextNode != null){
            if(nextNode.no == newNode.no){
                //更新
                nextNode.name = newNode.name;
                nextNode.nickName = newNode.nickName;
                System.out.println("更新成功...");
                break;
            }
            nextNode = nextNode.next;
        }
    }

    /**
     * 删除
     * @param no
     */
    public void delete(int no){
        PersonNode currentNode = head;
        if(currentNode.next == null){
            System.out.println( "空...");
        }
        while (currentNode.next != null){
            PersonNode appendNode = currentNode.next.next;
            if(currentNode.next.no == no){
                currentNode.next = appendNode;
                System.out.println("删除成功... ");
            }
            //后移
            currentNode = currentNode.next;
        }
    }

    /**
     * 查询所有
     */
    public void list(){
        PersonNode nextNode = head.next;
        if(nextNode == null){
            System.out.println( "空...");
        }
        while (nextNode != null){
            System.out.println(nextNode.no + "=="
                    + nextNode.name + "==" + nextNode.nickName);
            nextNode = nextNode.next;
        }
    }

    public static void main(String[] args) {
        PersonNode hero1 = new PersonNode(1, "宋江", "及时雨");
        PersonNode hero2 = new PersonNode(2, "卢俊义", "玉麒麟"); 
        PersonNode hero2_2 = new PersonNode(2, "卢俊义-2", "玉麒麟-2");
        PersonNode hero3 = new PersonNode(3, "吴用", "智多星");
        PersonNode hero4 = new PersonNode(4, "林冲", "豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(hero1);
//        linkedList.addLast(hero2);
//        linkedList.addLast(hero3);
        linkedList.addLast(hero4);
        linkedList.addByOrder(hero2);
        linkedList.list();

        System.out.println();
        linkedList.update(hero2_2);
        linkedList.list();

        System.out.println();
        linkedList.delete(10);
        linkedList.list();
    }
}
