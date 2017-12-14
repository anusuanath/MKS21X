import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConversion extends JFrame implements ActionListener {
    private Container pane;
    private JCheckBox c1,c2;
    private JTextField t;
    private JButton b;

    
    public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
	System.out.println(s);
	if (s.equals("Convert")) {
	    if (c1.isSelected()) {
		t.setText(t.getText());
	    }
	    else if (c2.isSelected()) {
		t.setText(t.getText());
	    }
	    else {
		t.setText("Unsure what the unit is");
	    }
	}	
    }
	    	
    public static double CtoF(double t) {
	return (t * 9) / 5 + 32;
    }
    public static double FtoC(double t) {
	return (t - 32) * (5/9);
    }
       	
    public TemperatureConversion() {
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	c1 = new JCheckBox("FtoC");
	c2 = new JCheckBox("CtoF");
	t = new JTextField(12);
	b = new JButton("Convert");

	c1.addActionListener(this);
	c2.addActionListener(this);
	t.addActionListener(this);
	b.addActionListener(this);
	
	pane.add(c1);
	pane.add(c2);
	pane.add(t);
	pane.add(b);
    }
  
    public static void main(String[] args) {
	TemperatureConversion t = new TemperatureConversion();
	t.setVisible(true);
    }
}
