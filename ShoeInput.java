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
    JLabel lacesLabel = new JLabel("Choose Option");
        // Window two b
    JFrame laceOp = new JFrame();
    ArrayList<JButton> options = new ArrayList<>();
    JButton opOne = new JButton("op one");
    JButton opTwo = new JButton("op two");
    JButton opThree = new JButton("enter option");

    JFrame inputWindowLaces = new JFrame();
    JTextField inputOpThree = new JTextField("enter option");

    public static void main(String[] args){
        new ShoeInput();
    }
    public ShoeInput(){
        // New shoe window
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cNS = new Container();
        cNS.setLayout(new GridLayout(1, 1));
        newShoe.addActionListener(this);
        cNS.add(newShoe);
        window.add(cNS, BorderLayout.NORTH);
        window.setVisible(true);
        window.pack();

        inputWindow();
    }
    public void inputWindow(){
        windowTwo.setLayout(new BorderLayout());

        //Information container
        JLabel brand = new JLabel("Brand : Lululemon");
        JLabel loco = new JLabel("Brand's HQ Location : PDX");
        JPanel shoeName = new JPanel();
        shoeName.setLayout(new GridLayout(1,2));
        JLabel title = new JLabel("Shoe Name: ");
        JTextField inputTitle = new JTextField("enter name");
        inputTitle.addActionListener(this);
        shoeName.add(title);
        shoeName.add(inputTitle, BorderLayout.EAST);
        Container infoContainer = new Container();
        infoContainer.setLayout(new GridLayout(3, 1));
        infoContainer.add(brand);
        infoContainer.add(loco);
        infoContainer.add(shoeName);
        windowTwo.add(infoContainer);
        windowTwo.pack();

        //  Laces container
        JLabel laces = new JLabel("Laces: ");
        Container cCB = new Container();
        cCB.setLayout(new GridLayout(1, 3));
        cCB.add(laces);
        JCheckBox y = new JCheckBox("Yes");
        y.addActionListener(this);
        JCheckBox n = new JCheckBox("No");
        n.addActionListener(this);

        cCB.add(y);
        cCB.add(n);
        cCB.add(lacesLabel);
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
                    chooseLaces(); //calls laces method
                }
            }
        };
        y.addActionListener(clickButton);


    }
    public void chooseLaces(){
        inputOpThree.addActionListener(this);
        inputWindowLaces.add(inputOpThree);
        options.add(opOne);
        options.add(opTwo);
        laceOp.setLayout(new BorderLayout());
        opOne.addActionListener(this);
        opTwo.addActionListener(this);
        opThree.addActionListener(this);
        Container cLO = new Container();
        cLO.setLayout(new GridLayout(3, 1));
        for (JButton laces: options){
            cLO.add(laces);
        }
        cLO.add(opThree);
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
                lacesLabel.setText(laces.getText());
            }
        }
        if (e.getSource().equals(opThree)){
            inputWindowLaces.setVisible(true);
        }
    }
}
