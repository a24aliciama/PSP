package org.example;

public class MediaRunnable implements Runnable{
    int temperaturas[] = new int[3650/10];
    int media;
    int sumas[] = new int[10];
    int pos;

    public MediaRunnable(int temperaturas[],int sumas[],int pos){
        this.temperaturas = temperaturas;
        this.sumas = sumas;
        this.pos = pos;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = 0; i < temperaturas.length;i++){
            total += temperaturas[i];
        }
        sumas[pos] = total;
    }
}
