package com.fuwa.datastructure.linked;

import java.io.*;
import java.util.Stack;

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

    /**
     * 获取节点个数
     * @return
     */
    public int getLength(){
        PersonNode nextNode = head.next;
        int num = 0;
        while (nextNode != null){
            num++;
            nextNode = nextNode.next;
        }
        return num;
    }

    /**
     * 查找链表中倒数 第index节点
     * @param index
     * @return
     */
    public PersonNode findLastIndexNode(int index){
        int length = getLength();
        if(length == 0 || index < 0 || index > length){
            System.out.println("无效数据...");
            return null;
        }
        PersonNode nextNode = this.head.next;
        for (int i = 0; i < (length - index); i++) {
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    /**
     * 反转链表
     */
    public void reverseList(){
        PersonNode nextNode = head.next;
        if(nextNode == null || nextNode.next.next == null){
            System.out.println("链表小于2，不需要反转");
            return;
        }
        PersonNode tempHead = new PersonNode(0, "","");
        while (nextNode != null){
            /**
             * 临时插入数据，不能修改nextNode
             * 要么对象深拷贝/浅拷贝
             */
            PersonNode insertNode = new PersonNode(
                    nextNode.no, nextNode.name, nextNode.nickName);
            insertNode.next = tempHead.next;
            tempHead.next = insertNode;
            //下一个
            nextNode = nextNode.next;
        }
        head.next = tempHead.next;
    }

    /**
     * 从尾到头打印
     * 使用 stack 栈方式
     */
    public void reversePrint(){
        Stack<PersonNode> stack = new Stack<>();
        PersonNode nextNode = head.next;
        while (nextNode != null){
            stack.push(nextNode);
            nextNode = nextNode.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 复制
     * @param old
     * @return
     */
    public Object copy(Object old) {
        Object clazz = null;
        try {
            // 写入字节流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(old);
            // 读取字节流
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clazz = (Object) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
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

        System.out.println();
        System.out.printf("大小：%d ", linkedList.getLength());
        System.out.println();

        System.out.println();
        System.out.printf("倒数第3：%s ", linkedList.findLastIndexNode(3));
        System.out.println();

        System.out.println("\n反向遍历，仅仅是打印：");
        linkedList.reversePrint();

        System.out.println("\n修改链表成反向列表：");
        linkedList.reverseList();
        linkedList.list();

//        PersonNode heroTemp = (PersonNode) linkedList.copy(hero4);
//        heroTemp.setNickName("xxxx");
//        System.out.println(heroTemp + "\n" + hero4);
    }
}
