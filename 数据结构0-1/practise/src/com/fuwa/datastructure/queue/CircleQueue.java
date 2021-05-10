package com.fuwa.datastructure.queue;

import java.util.Scanner;

/**
 * @Author: 进击的烧年.
 * @Date: 2021/5/11 00:07
 * @Description:
 */
public class CircleQueue {
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

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //空标识后移，空标识下标如果超过容量值
        rear = (rear + 1) % maxSize;
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
        //第一个元素
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 查询队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty!");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 当前队列数量
     *
     * @return
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
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
        return arr[front];
    }

    public static void main(String[] args) {
        //尾部空标识占位一个，有效最大值3
        CircleQueue queue = new CircleQueue(4);
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
    }
}
