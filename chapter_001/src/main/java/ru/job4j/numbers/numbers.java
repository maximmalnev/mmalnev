package ru.job4j.numbers;

public class numbers {
    public static void main(String[] args) {

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    for (int d = 0; d < 10; d++) {
                        for (int e = 0; e < 10; e++) {
                            if ((9+b*10+d*100+c*1000+c*10000+b*100000+b*1000000+e*10000000)+(b+b*10+e*100+797000+b*1000000+c*10000000)==a+90+c*100+a*1000+c*10000+2*100000+9*1000000+d*10000000+d*100000000){
                                System.out.println("a1=" + a);
                                System.out.println("b1=" + b);
                                System.out.println("c1=" + c);
                                System.out.println("d1=" + d);
                                System.out.println("e1=" + e);
                                break;
                            }
                        }
                    }
                }
            }
        }


    }
}
