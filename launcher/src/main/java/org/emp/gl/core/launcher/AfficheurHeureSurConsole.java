/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.core.launcher;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author tina
 */
public class AfficheurHeureSurConsole implements TimerChangeListener {

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        
        System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
    }

    // cette méthode provient du PropertyChangeListener 
    // à utiliser plustard ! 
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(pce.getPropertyName() == TimerChangeListener.DIXEME_DE_SECONDE_PROP){
            TimerService ts = Lookup.getInstance().getService(TimerService.class);

            System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                    + ts.getSecondes() + "," + pce.getNewValue());

        }
        if(pce.getPropertyName() == TimerChangeListener.SECONDE_PROP){
            TimerService ts = Lookup.getInstance().getService(TimerService.class);

            System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                    + pce.getNewValue() + "," + ts.getDixiemeDeSeconde());
        }
        if(pce.getPropertyName() == TimerChangeListener.MINUTE_PROP){
            TimerService ts = Lookup.getInstance().getService(TimerService.class);

            System.out.println("" + ts.getHeures() + ":" + pce.getNewValue() + ":"
                    + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
        }
        if(pce.getPropertyName() == TimerChangeListener.HEURE_PROP){
            TimerService ts = Lookup.getInstance().getService(TimerService.class);

            System.out.println("" + pce.getNewValue() + ":" + ts.getMinutes() + ":"
                    + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
        }
    }

}
