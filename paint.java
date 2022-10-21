import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;

class MyFrame extends JFrame implements ActionListener,ChangeListener{
    Point getPoint;
    JButton button,button2;
    Graphics g;
    Color color=Color.WHITE;
    JPanel panel;
    JSlider slider;
    int width=5,height=5;
    MyFrame(){
       
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);

        button=new JButton("change color");
        button.setBounds(300, 0,100, 50);
        button.addActionListener(this);

        button2=new JButton("Clear");
        button.setBounds(350, 0, 100, 50);
        button2.addActionListener(this);

        slider=new JSlider();
       slider.setPaintTicks(true);
       slider.setPaintLabels(true);
       slider.setMinorTickSpacing(10);
       slider.setPaintTrack(true);
       slider.setMajorTickSpacing(25);
       slider.addChangeListener(this);
 
        panel=new JPanel();
        panel.add(button);
        panel.add(button2);
        panel.setBounds(0, 0, 600, 70);
        //panel.setPreferredSize(new Dimension(200,200));
        panel.setBorder(BorderFactory.createTitledBorder("Change the drawing color"));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
       panel.add(slider);
        this.add(panel);
        this.addMouseMotionListener(new mouseDragged());
        this.setVisible(true);
    }
    public void stateChanged(ChangeEvent e){
        if(e.getSource()==slider){
            width=slider.getValue();
            System.out.println(width);
            height=slider.getValue();
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            JColorChooser colorChooser=new JColorChooser();
            color=colorChooser.showDialog(null, "color picker", Color.WHITE);
        }
        if(e.getSource()==button2){
            repaint();
        }
    }
    class mouseDragged extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            g=getGraphics();
            g.setColor(color);
            g.fillOval(e.getX(), e.getY(), width, height);
            //repaint();
        }
    }
    
}

public class paint {
    public static void main(String args[]){
        MyFrame myFrame=new MyFrame();
    }
}
