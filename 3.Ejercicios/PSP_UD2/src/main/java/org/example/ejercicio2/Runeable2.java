package org.example.ejercicio2;

public class Runeable2 implements Runnable{

    private int[] temp; //temperaturas
    private int start;
    private int end;
    private long sum = 0;


    public Runeable2(int[] temp, int start, int end) {
        this.temp = temp;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += temp[i];
        }
    }

    public double getMediaSum() {
        double media = (double) sum /365;
        return media;
    }
}
