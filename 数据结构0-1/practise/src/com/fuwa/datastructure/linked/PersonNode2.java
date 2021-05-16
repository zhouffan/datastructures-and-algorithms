package com.fuwa.datastructure.linked;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/14 23:01
 * @Description: 节点
 */
public class PersonNode2 {
    public int no;
    public String name;
    public String nickName;
    public PersonNode2 next;
    public PersonNode2 pre;

    public PersonNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
