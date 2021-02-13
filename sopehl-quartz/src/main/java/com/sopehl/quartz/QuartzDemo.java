package com.sopehl.quartz;

import java.util.*;

public class QuartzDemo {

    public static void main(String[] args) {
        int[] comets = {-1,-2, 5, 10};

        Stack<Integer> cometStack = new Stack<>();
        for (int item : comets) {
            if (item < 0) {
                while (!cometStack.isEmpty() && cometStack.peek() > 0 && cometStack.peek() < Math.abs(item)) {
                    cometStack.pop();
                }
                if ((!cometStack.isEmpty() && cometStack.peek() > 0) && cometStack.peek() == Math.abs(item)) {
                    cometStack.pop();
                } else {
                    cometStack.push(item);
                }
            } else {
                cometStack.push(item);
            }
        }

        int[] status = new int[cometStack.size()];
        for (int i = 0;  i <= status.length - 1; i++) {
            status[i] = cometStack.pop();
        }

        for (int item : reverse(status, status.length)) {
            System.out.println(item);
        }

    }

    static int[] reverse(int a[], int n) {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

        return b;
    }
}
