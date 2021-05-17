package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;

import org.emp.gl.guidisplay.GuiDisplay;
import org.emp.gl.model.Watch;
import org.emp.gl.model.WatchState;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;
import org.emp.gl.gui.GuiControl;

public class App {

    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
    static {
        Watch watch=new Watch();
        Lookup.getInstance().register(TimerServiceImplWithDelegation.class, watch);
        Lookup.getInstance().register(WatchState.class, watch);
    }



    public static void main(String[] args) {

        //testDuTimeService();
        TimerService ts = Lookup.getInstance().getService(TimerServiceImplWithDelegation.class);
        GuiControl guiControl=new GuiControl();
        GuiDisplay guiDisplay=new GuiDisplay(ts.getDixiemeDeSeconde(), ts.getSecondes(), ts.getMinutes(), ts.getHeures());
        ts.addTimeChangeListener(guiDisplay);


    }


    private static void testDuTimeService() {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        ts.addTimeChangeListener(new AfficheurHeureSurConsole());
        /*for(int i=0;i<20;i++){
            ts.addTimeChangeListener(new CompteARebour(5 + (int)(Math.random() * 10)));
        }*/


    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
