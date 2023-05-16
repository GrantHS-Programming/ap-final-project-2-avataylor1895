import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ShoeInput implements ActionListener{
    JFrame window = new JFrame();
    JButton newShoe = new JButton("Input new shoe");

    JFrame windowTwo = new JFrame();
    Label laces = new Label("Laces: ");

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
        windowTwo.setSize(500, 1000);
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
        windowTwo.add(cCB);
        windowTwo.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newShoe)){
            windowTwo.setVisible(true);
        }
    }
}
