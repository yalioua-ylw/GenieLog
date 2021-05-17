package org.emp.gl.timer.service.impl.withdelegation;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerServiceImplWithDelegation extends TimerTask
        implements TimerService {
    int dixiemeDeSeconde;
    int minutes;
    int secondes;
    int heures;
    private  PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }


    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        this.pcs.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        this.pcs.removePropertyChangeListener(pl);
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }
    @Override
    public void run() {
        timeChanged();
    }
    private void timeChanged() {
        updateDixiemeDeSecode();
    }
    private void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;


        if (dixiemeDeSeconde == 0  ) {
            updateSecondes();
        }
        else{
            PropertyChangeEvent event = new PropertyChangeEvent(this, TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue, dixiemeDeSeconde);
            pcs.firePropertyChange(event);
        }

    }
    private void updateSecondes() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;



        if (secondes == 0) {
            updateMinutes();
        }
        else{
            PropertyChangeEvent event = new PropertyChangeEvent(this, TimerChangeListener.SECONDE_PROP, oldValue, secondes);
            pcs.firePropertyChange(event);
        }

    }

    private void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;

        if (minutes == 0) {
            updateHeures();
        }
        else{
            PropertyChangeEvent event = new PropertyChangeEvent(this, TimerChangeListener.MINUTE_PROP, oldValue, minutes);
            pcs.firePropertyChange(event);
        }

    }

    private void updateHeures() {
        int oldValue = heures;
        heures = (heures + 1) % 24;
         PropertyChangeEvent event = new PropertyChangeEvent(this, TimerChangeListener.HEURE_PROP, oldValue, heures);
        pcs.firePropertyChange(event);
    }
    public void incrementMinutes(){
        //minutes++;
        updateMinutes();
        System.out.println("minutes incremented");

    }
    public void incrementSeconds(){
        //secondes++;
        updateSecondes();

        System.out.println("seconds incremented "+ getSecondes());

    }
    public void incrementHours(){
        //heures++;
        updateHeures();
        System.out.println("hours incremented");
    }
}
