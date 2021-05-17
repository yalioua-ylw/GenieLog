package org.emp.gl.guidisplay;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


public class GuiDisplay implements TimerChangeListener
{
    JFrame frame = new JFrame();
    JButton miliButton =new JButton();
    JButton secondsButton =new JButton();
    JButton minutesButton= new JButton();
    JButton hoursButton =new JButton();
    Font font=new Font("Arial",Font.PLAIN,15);
    public GuiDisplay(int dixiemeSecondes, int seconde, int minute, int heure){
        frame.setSize(465,180);
        hoursButton.setFont(font);
        minutesButton.setFont(font);
        secondsButton.setFont(font);
        hoursButton.setBounds(65,65,50,50);
        minutesButton.setBounds(165,65,50,50);
        secondsButton.setBounds(265,65,50,50);
        miliButton.setBounds(365,65,50,50);
        frame.add(hoursButton);
        frame.add(minutesButton);
        frame.add(secondsButton);
        frame.add(miliButton);
        frame.setTitle("Gui Display");
        hoursButton.setText(String.valueOf(heure));
        minutesButton.setText(String.valueOf(minute));
        secondsButton.setText(String.valueOf(String.valueOf(seconde)));
        miliButton.setText(String.valueOf(dixiemeSecondes));
        frame .setLayout(null);

        frame.setVisible(true);

    }


    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {


    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if(pce.getPropertyName() == TimerChangeListener.DIXEME_DE_SECONDE_PROP){
            miliButton.setText(String.valueOf(pce.getNewValue()));

        }
        if(pce.getPropertyName() == TimerChangeListener.SECONDE_PROP){
            secondsButton.setText(String.valueOf(pce.getNewValue()));

        }
        if(pce.getPropertyName() == TimerChangeListener.MINUTE_PROP){
            minutesButton.setText(String.valueOf(pce.getNewValue()));
        }
        if(pce.getPropertyName() == TimerChangeListener.HEURE_PROP){
            hoursButton.setText(String.valueOf(pce.getNewValue()));
        }
    }
}

