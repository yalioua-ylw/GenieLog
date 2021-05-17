package org.emp.gl.model;


import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;

public class Watch extends TimerServiceImplWithDelegation implements WatchState {
    WatchState watchState;
    public Watch(){
        super();
        this.watchState=  new InitState(this);
    }


    @Override
    public void mode() {
        watchState.mode();
    }

    @Override
    public void config() {
        watchState.config();
    }

    @Override
    public void increment() {
        watchState.increment();

    }


    public void setState(WatchState ws){
        watchState=ws;
    }

}
