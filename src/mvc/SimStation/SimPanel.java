package mvc.SimStation;

import mvc.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SimPanel extends AppPanel {
    public SimPanel(AppFactory factory) { super(factory);
        controlPanel.     setLayout(new GridLayout(5,1,5,5));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border emptyBorder = BorderFactory.createEmptyBorder(50, 50, 50, 50);
        // Combine the existing line border with the empty border
        Border compoundBorder = BorderFactory.createCompoundBorder(
                blackline,
                emptyBorder
        );
        JButton run1 = new JButton("Start");
        run1.addActionListener(this);
        run1.setBorder( compoundBorder);
        run1.setPreferredSize(new Dimension(15, 15));
        JButton run50 = new JButton("Suspend");
        run50.addActionListener(this);
        run50.setBorder(  compoundBorder);
        run50.setPreferredSize(new Dimension(15,15));
        JButton populate = new JButton("Resume");
        populate.addActionListener(this);
        populate.setBorder(  compoundBorder);
        populate.setPreferredSize(new Dimension(15, 15));
        JButton clear = new JButton("Stop");
        clear.addActionListener(this);
        clear.setBorder( compoundBorder);
        clear.setPreferredSize(new Dimension(15, 15));
        JButton statistics = new JButton("Stats");
        statistics.addActionListener(this);
        statistics.setBorder( compoundBorder);
        statistics.setPreferredSize(new Dimension(15, 15));
        controlPanel.add(run1);
        controlPanel.add(run50);
        controlPanel.add(populate);
        controlPanel.add(clear);
        controlPanel.add(statistics);}
    public static void main(String[] args)
    {SimPanel world=new SimPanel(new SimFactory()); world.display();}
}