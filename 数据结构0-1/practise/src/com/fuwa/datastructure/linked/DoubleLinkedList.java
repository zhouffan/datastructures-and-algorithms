package com.fuwa.datastructure.linked;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/16 13:42
 * @Description:
 */
public class DoubleLinkedList {
    private PersonNode2 head = new PersonNode2(0,"","");

    /**
     * 添加节点到最后
     * @param newNode
     */
    public void add(PersonNode2 newNode){
        PersonNode2 lastNode = head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.pre = lastNode;
    }

    /**
     * 根据no修改 节点
     * @param newNode
     */
    public void update(PersonNode2 newNode){
        PersonNode2 nextNode = head.next;
        while (nextNode != null){
            if(nextNode.no == newNode.no){
                nextNode.name = newNode.name;
                nextNode.nickName = newNode.nickName;
                System.out.println("更新成功");
            }
            nextNode = nextNode.next;
        }
    }

    /**
     * 根据no 删除节点
     * @param no
     */
    public void delete(int no){
        PersonNode2 nextNode = head.next;
        while (nextNode != null){
            if(nextNode.no == no){
                //直接能找到 上一个和下一个。进行设置
                nextNode.pre.next = nextNode.next;
                nextNode.next.pre = nextNode.pre;
                System.out.println("删除成功");
            }
            nextNode = nextNode.next;
        }
    }

    /**
     * 遍历链表
     */
    public void list(){
        PersonNode2 nextNode = head.next;
        while (nextNode != null){
            System.out.println(nextNode);
            nextNode = nextNode.next;
        }
    }

    public static void main(String[] args) {
        PersonNode2 hero1 = new PersonNode2(1, "宋江", "及时雨");
        PersonNode2 hero2 = new PersonNode2(2, "卢俊义", "玉麒麟");
        PersonNode2 hero2_2 = new PersonNode2(2, "卢俊义-2", "玉麒麟-2");
        PersonNode2 hero3 = new PersonNode2(3, "吴用", "智多星");
        PersonNode2 hero4 = new PersonNode2(4, "林冲", "豹子头");

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);
        linkedList.list();

        System.out.println("\n修改操作：");
        linkedList.update(hero2_2);
        linkedList.list();

        System.out.println("\n删除操作：");
        linkedList.delete(3);
        linkedList.list();
    }
}
