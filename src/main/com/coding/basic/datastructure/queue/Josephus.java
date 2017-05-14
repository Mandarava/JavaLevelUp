package com.coding.basic.datastructure.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 用Queue来实现Josephus问题
 * 在这个古老的问题当中， N个深陷绝境的人一致同意用这种方式减少生存人数：  N个人围成一圈（位置记为0到N-1）， 并且从第一个人报数， 报到M的人会被杀死， 直到最后一个人留下来
 * 该方法返回一个List， 包含了被杀死人的次序
 *
 * @author zt
 */
public class Josephus {

    public static List<Integer> execute(int n, int m) {
        List<Integer> killedPeopleOrder = new ArrayList<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            arrayDeque.offer(i);
        }
        int number = 1;
        while (arrayDeque.size() > 0) {
            int currentPeople = arrayDeque.poll();
            if (number == m) {
                killedPeopleOrder.add(currentPeople);
            } else {
                arrayDeque.offer(currentPeople);
            }
            number = number++ == m ? 1 : number;
        }
        return killedPeopleOrder;
    }

}
