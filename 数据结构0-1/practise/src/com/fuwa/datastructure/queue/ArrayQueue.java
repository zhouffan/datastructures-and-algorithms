package com.fuwa.datastructure.queue;

import java.util.Scanner;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/10 23:38
 * @Description:
 */
public class ArrayQueue {
    /**
     * 队列容量
     */
    private int maxSize;
    /**
     * 头位置
     */
    private int front;
    /**
     * 尾位置
     */
    private int rear;
    /**
     * 存放数据
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 入队
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 出队
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        front++;
        int v = arr[front];
        arr[front] = 0;
        return v;
    }

    /**
     * 查询队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 获取队列头
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        return arr[front+1];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int n = scanner.nextInt();
                    queue.addQueue(n);
                    break;
                case 'g':
                    int v = queue.getQueue();
                    System.out.printf("值：%d\n", v);
                    break;
                case 'h':
                    int h = queue.headQueue();
                    System.out.printf("值head：%d\n", h);
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
