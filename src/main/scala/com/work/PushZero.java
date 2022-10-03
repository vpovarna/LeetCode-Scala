package com.work;

public class PushZero {

    private static void pushZeroToEnd(int inputArray[]) {
        int count = 0;
        for (int i = 0; i< inputArray.length; i++) {
            if (inputArray[i] != 0) {
                inputArray[count++] = inputArray[i];
            }
        }

        while (count < inputArray.length) {
            inputArray[count++] = 0;
        }
    }

    private static void printArr(int inputArray[]) {
        for (int i : inputArray) {
            System.out.println(i + " ");
        }
    }

    public static void main(String[] args) {
        int inputArray[] = {0, 22, -4, 0, 3, 7, 0, 0, -3, 2};
        pushZeroToEnd(inputArray);
        printArr(inputArray);
    }
}
