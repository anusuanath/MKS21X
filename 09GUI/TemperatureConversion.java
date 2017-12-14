import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConversion extends JFrame implements ActionListener {
    private Container pane;
    private JButton b1,b2;
    private JTextField t;

    public TemperatureConversion() {
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	b1 = new JButton("FtoC");
	b2 = new JButton("CtoF");
	t = new JTextField(12);

	pane.add(b1);
	pane.add(b2);
	pane.add(t);
    }
    public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
	System.out.println(s);
	//if(s.equals("FtoC")) {
	    
    }
    /*
    public static double CtoF(double t) {
    return (t * 9) / 5 + 32;
    }
    public static double FtoC(double t) {
    return (t - 32) * (5/9);
    }
    */
    public static void main(String[] args) {
	TemperatureConversion t = new TemperatureConversion();
	t.setVisible(true);
    }
}
