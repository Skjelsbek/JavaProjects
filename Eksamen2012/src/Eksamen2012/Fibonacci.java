package Eksamen2012;

public class Fibonacci {
    public static void main(String[] args) {
        int foregående1 = 0;
        int foregående2 = 0;
        int hjelp = 0;
        for (int i = 0; i < 22; i++) {
            if (i == 0) {
                System.out.println("1: " + 0);
                foregående2 = i;
            } else if (i == 1) {
                System.out.println("2: " + 1);
                foregående1 = i;
            } else {
                System.out.println((i+1) + ": "+ (foregående1 + foregående2));
                hjelp = foregående1;
                foregående1 += foregående2;
                foregående2 = hjelp;
            }
        }
    }
}
