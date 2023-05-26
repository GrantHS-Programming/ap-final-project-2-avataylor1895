import javafx.scene.chart.Axis;

import javax.management.remote.JMXConnectorFactory;
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
    JTextField inputTitle = new JTextField("enter name");
    JLabel lacesLabel = new JLabel("Choose Option");
    JButton a = new JButton("A: Upper Material");
    JButton b = new JButton("B: Lining / Reinforcement");
    JButton c = new JButton("C: Components and Sockliner");
    JButton d = new JButton("D: Process");
    JButton e = new JButton("E: Bottom Unit");

    //window three
    JFrame sectionA = new JFrame();
    //vamp
    JButton chooseMaterial = new JButton("Choose Material");
    JLabel vampLabel = new JLabel("");
    JFrame materialOp = new JFrame();
    ArrayList<JButton> materialOptions = new ArrayList<>();
    JButton texon = new JButton("Texon");
    JButton sincetech = new JButton("Sincetech");
    JButton inHouse = new JButton("In - House");
    JButton sanFang = new JButton("San Fang");
    JButton materialInputButton = new JButton("Enter Option");
    JFrame inputWindowMaterial = new JFrame();
    JTextField inputMaterial = new JTextField("New Material");


    //laces
    JFrame laceOp = new JFrame();
    ArrayList<JButton> lacesOptions = new ArrayList<>();
    JButton opOne = new JButton("op one");
    JButton opTwo = new JButton("op two");
    JButton opThree = new JButton("enter option");

    JButton doneButton = new JButton("Done");

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

        windowTwo();
        windowA();

    }
    public void windowTwo(){
        windowTwo.setLayout(new BorderLayout());

        //Information container
        JLabel brand = new JLabel("Brand : Lululemon");
        JLabel loco = new JLabel("Brand's HQ Location : PDX");
        JPanel shoeName = new JPanel();
        shoeName.setLayout(new GridLayout(1,2));
        JLabel title = new JLabel("Shoe Name: ");
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

        // Shoe part option
        Container sections = new Container();
        sections.setLayout(new GridLayout(6,1));
        JLabel section = new JLabel("Section: ");
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        sections.add(a);
        sections.add(b);
        sections.add(c);
        sections.add(d);
        sections.add(e);
        windowTwo.add(sections, BorderLayout.AFTER_LAST_LINE);
        windowTwo.pack();

    }
    public void windowA(){
        sectionA.setLayout(new BorderLayout());
        JLabel titleA = new JLabel("Upper Material");
        sectionA.add(titleA);

        //Vamp
        JLabel materials = new JLabel("Materials: ");
        Container cVamp = new Container();
        cVamp.setLayout(new GridLayout(1,3));
        cVamp.add(materials);
        cVamp.add(chooseMaterial);
        chooseMaterial.addActionListener(this);
        cVamp.add(vampLabel);
        sectionA.add(cVamp);
        sectionA.pack();

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
        sectionA.add(cCB);
        sectionA.pack();

        ActionListener clickButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton button = (AbstractButton) e.getSource();
                boolean click = button.getModel().isSelected();
                System.out.println(click);
                if (e.getSource().equals(y) && click){
                    System.out.println("clicked");
                    laceOp.setVisible(true);
                    chooseLaces(); //calls laces method
                }
            }
        };
        y.addActionListener(clickButton);
        doneButton.addActionListener(this);
        sectionA.add(doneButton, BorderLayout.AFTER_LAST_LINE);
        sectionA.pack();

    }
    public void materialChoice(JLabel label){
        materialOp.setLayout(new BorderLayout()); // ? make this visib;eeeeeee
        Container cMO = new Container();
        cMO.setLayout(new GridLayout(5,1));
        materialOptions.add(texon);
        materialOptions.add(sincetech);
        materialOptions.add(inHouse);
        materialOptions.add(sanFang);
        materialOp.setVisible(true);
        for (JButton material: materialOptions){
            cMO.add(material);
            material.addActionListener(this);
        }
        cMO.add(materialInputButton);
        inputWindowMaterial.setLayout(new GridLayout(1,2));
        inputWindowMaterial.add(inputMaterial);
        inputWindowMaterial.add(doneButton);
        inputWindowMaterial.pack();
        materialOp.add(cMO);
        materialOp.pack();
        ActionListener inputAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(materialInputButton)){
                    inputWindowMaterial.setVisible(true);
                }
                if (e.getSource().equals(doneButton)){
                    String newMaterial = inputMaterial.getText();
                    label.setText(newMaterial);
                    inputWindowMaterial.setVisible(false);
                    materialOp.setVisible(false);
                }
            }
        };
        materialInputButton.addActionListener(inputAction);
    }
    public void chooseLaces(){
        lacesOptions.add(opOne);
        lacesOptions.add(opTwo);
        laceOp.setLayout(new BorderLayout());
        Container cLO = new Container();
        cLO.setLayout(new GridLayout(3, 1));
        for (JButton laces: lacesOptions){
            laces.addActionListener(this);
            cLO.add(laces);
        }
        opThree.addActionListener(this);
        cLO.add(opThree);
        laceOp.add(cLO);
        laceOp.pack();
    }
    public void inputLaces(){
        inputWindowLaces.setLayout(new GridLayout(1,1));
        inputOpThree.addActionListener(this);
        inputWindowLaces.add(inputOpThree);
        inputWindowLaces.add(doneButton);
        ActionListener done = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(doneButton)){
                    String newOpThree = inputOpThree.getText();
                    lacesLabel.setText(newOpThree);
                    inputWindowLaces.setVisible(false);
                    laceOp.setVisible(false);
                }
            }
        };
        doneButton.addActionListener(done);
        inputWindowLaces.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newShoe)){
            windowTwo.setVisible(true);
        }
        if (e.getSource().equals(a)){
            sectionA.setVisible(true);
        }
        if (e.getSource().equals(chooseMaterial)){
            materialChoice(vampLabel);
        }
        for (JButton laces: lacesOptions){
            if (e.getSource().equals(laces)){
                laceOp.setVisible(false);
                lacesLabel.setText(laces.getText());
            }
        }
        if (e.getSource().equals(opThree)){
            inputWindowLaces.setVisible(true);
            inputLaces();
        }
        //Done clicked:
        //get laces text

    }
}
