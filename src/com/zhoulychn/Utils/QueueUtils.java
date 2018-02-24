package com.zhoulychn.Utils;

import com.zhoulychn.BaseBean.StackAndQueue.Queue;

public class QueueUtils {

    public static boolean isEmpty(Queue queue) {
        return queue.getFront() == queue.getRear();
    }

    public static boolean enQueue(Queue queue, int value) {
        int[] data = queue.getData();
        int front = queue.getFront();
        int rear = queue.getRear();
        if ((rear + 1) % queue.getCapacity() == front) return false;
        data[rear++] = value;
        queue.setRear(rear);
        return true;
    }

    public static int deQueue(Queue queue) {
        int[] data = queue.getData();
        int front = queue.getFront();
        int result = data[front++];
        queue.setFront(front);
        return result;
    }
}
