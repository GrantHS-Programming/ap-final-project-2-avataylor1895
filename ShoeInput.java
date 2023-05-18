import javafx.scene.chart.Axis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
public class ShoeInput implements ActionListener{
    // Window one
    JFrame window = new JFrame();
    JButton newShoe = new JButton("Input new shoe");
    //Window two a
    JFrame windowTwo = new JFrame();
    Label laces = new Label("Laces: ");
    JLabel label = new JLabel("Choose Option");
        // Window two b
    JFrame laceOp = new JFrame();
    ArrayList<JButton> options = new ArrayList<>();
    JButton opOne = new JButton("op one");
    JButton opTwo = new JButton("op two");
    JButton opThree = new JButton("op three");

    public static void main(String[] args){
        new ShoeInput();
    }
    public ShoeInput(){
        window.setLayout(new BorderLayout());
        window.setSize(750,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cNS = new Container();
        cNS.setLayout(new GridLayout(1, 1));
        newShoe.addActionListener(this);
        cNS.add(newShoe);
        window.add(cNS, BorderLayout.NORTH);
        window.setVisible(true);
        window.pack();

        windowTwo.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
        panel.add(laces);
        Container cCB = new Container();
        cCB.setLayout(new GridLayout(1, 3));
        cCB.add(panel, BorderLayout.NORTH);

        JCheckBox y = new JCheckBox("Yes");
        y.addActionListener(this);
        windowTwo.add(y);
        JCheckBox n = new JCheckBox("No");
        n.addActionListener(this);
        windowTwo.add(n);


        cCB.add(y);
        cCB.add(n);
        cCB.add(label);
        windowTwo.add(cCB);
        windowTwo.pack();
        ActionListener clickButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton button = (AbstractButton) e.getSource();
                boolean click = button.getModel().isSelected();
                System.out.println(click);
                if (e.getSource().equals(y) && click == true){
                    System.out.println("clicked");
                    laceOp.setVisible(true);
                    chooseLaces();
                }
            }
        };
        y.addActionListener(clickButton);

    }
    public void chooseLaces(){
        options.add(opOne);
        options.add(opTwo);
        options.add(opThree);
        laceOp.setLayout(new BorderLayout());
        opOne.addActionListener(this);
        opTwo.addActionListener(this);
        opThree.addActionListener(this);
        Container cLO = new Container();
        cLO.setLayout(new GridLayout(3, 1));
        for (JButton laces: options){
            cLO.add(laces);
        }
        laceOp.add(cLO);
        laceOp.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newShoe)){
            windowTwo.setVisible(true);
        }
        for (JButton laces: options){
            if (e.getSource().equals(laces)){
                laceOp.setVisible(false);
                label.setText(laces.getText());
            }
        }
    }
}
