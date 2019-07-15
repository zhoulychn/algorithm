package com.zhoulychn;


public class Application {

    public enum Calc {

        ADD, MINUS, MULTIPLY, DIVIDE;

        public static int execute(int a, int b, Calc calc) {
            switch (calc) {
                case ADD:
                    return a + b;
                case MINUS:
                    return a - b;
                case DIVIDE:
                    return a / b;
                case MULTIPLY:
                    return a * b;
                default:
                    return Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
    }
}
