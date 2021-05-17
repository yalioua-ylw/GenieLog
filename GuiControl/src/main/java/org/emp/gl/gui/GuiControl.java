package org.emp.gl.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.model.WatchState;

public class GuiControl
{
    JFrame frame = new JFrame();
    JButton configButton =new JButton("Config");
    JButton incrementButton =new JButton("+");
    JButton modeButton = new JButton("Mode");
    Font font=new Font("Arial",Font.PLAIN,40);
    WatchState watch=Lookup.getInstance().getService(WatchState.class);
    public GuiControl(){
        frame.setSize(465,180);
        configButton.setFont(font);
        configButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                watch.config();
            }
        });
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                watch.increment();
            }
        });
        modeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                watch.mode();
            }
        });
        incrementButton.setFont(font);
        modeButton.setFont(font);
        configButton.setBounds(0,0,150,150);
        incrementButton.setBounds(150,0,150,150);
        modeButton.setBounds(300,0,150,150);
        frame.add(configButton);
        frame.add(incrementButton);
        frame.add(modeButton);
        frame.setTitle("Gui Control");
        frame .setLayout(null);
        frame.setVisible(true);

    }



}
