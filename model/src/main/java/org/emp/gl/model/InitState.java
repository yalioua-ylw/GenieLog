package org.emp.gl.model;

public class InitState implements WatchState{

    Watch myWatch;

    InitState(Watch w){
        myWatch=w;
    }
    @Override
    public void mode() {
        //watch.mode();
        myWatch.setState(new SecondeSelected(myWatch));
    }

    @Override
    public void config() {

    }

    @Override
    public void increment() {

    }


}
