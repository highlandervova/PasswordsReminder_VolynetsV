package com.brainacad.passwordReminder;

public class SymbolThread extends Thread{

    private String msg;

    public SymbolThread() {
    }

    public SymbolThread(String msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RandomService.randomSymbolResults.add(msg);
    }
}