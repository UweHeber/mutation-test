package it.heber.sandbox.mutationtest;

public class Service {
    public int add(int a, int b) {
        if (a < 2) {
            return (a + b) * -1;
        } else {
            return a + b;
        }
    }
}
