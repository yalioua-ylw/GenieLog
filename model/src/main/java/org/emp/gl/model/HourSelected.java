package org.emp.gl.model;

public class HourSelected implements WatchState{
    Watch myWatch;
    HourSelected(Watch w){
        myWatch=w;
    }
    @Override
    public void config(){
        myWatch.setState(new InitState(myWatch));
    }
    public void mode(){
        myWatch.setState(new SecondeSelected(myWatch));
    }
    public void increment(){
        myWatch.incrementHours();
    }


}
