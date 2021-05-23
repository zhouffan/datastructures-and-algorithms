package com.fuwa.datastructure.stack;

import java.util.Scanner;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/23 23:14
 * @Description:
 */
public class ArrayStack {
    /**
     * 数组模拟栈
     */
    private int[] stack;
    /**
     * 栈大小
     */
    private int maxSize;
    /**
     * 栈顶
     */
    private int top = -1;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        //栈顶标志移到最大一个值
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈并返回
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空...");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            return;
        }
        for (int i = top; i >= 0; i--) {
            int value = stack[i];
            System.out.printf("stack[%d] = %d\n", i, value);
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            /**
             * 阻塞
             */
            String key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    /**
                     * 阻塞
                     */
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
