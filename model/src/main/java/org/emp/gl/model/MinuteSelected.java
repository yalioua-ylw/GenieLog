package org.emp.gl.model;

public class MinuteSelected implements   WatchState{
    Watch myWatch;
    MinuteSelected(Watch w){
        myWatch=w;
    }
    @Override
    public void mode() {
        myWatch.setState(new HourSelected(myWatch));
    }

    @Override
    public void config() {
        myWatch.setState(new InitState(myWatch));
    }

    @Override
    public void increment() {
        myWatch.incrementMinutes();
    }

}
