package org.emp.gl.model;

public class SecondeSelected implements WatchState{
    Watch myWatch;

    SecondeSelected(Watch w){
        myWatch=w;
    }
    @Override
    public void mode() {
        myWatch.setState(new MinuteSelected(myWatch));
    }

    @Override
    public void config() {
        myWatch.setState(new InitState(myWatch));
    }

    @Override
    public void increment() {
        myWatch.incrementSeconds();
    }


}
