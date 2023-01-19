import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class Depstore extends JFrame {
JPanel pnlMain = new JPanel();

JLabel lblProduct= new JLabel ("Price: ");
JLabel lblPrice= new JLabel ("Price: ");

JButton btnSubmit = new JButton ("Submit");
JButton btnClearAll = new JButton ("ClearAll");

JTextField fldProduct= new JTextField(16);
JTextField fldPrice= new JTextField(16);

JTextArea outputArea = new JTextArea (8, 25);

FlowLayout fl = new FlowLayout();
Font setFont = new Font ("",Font.BOLD, 14);

	public static void main (String[] args) {
		Depstore Departmentstore = new Depstore();


}
public Depstore() {
this.setSize(700,350);
this.setLocation(200,200);
this.setTitle("Deptstore IS");
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

outputArea.setBackground(Color.LIGHT_GRAY);
outputArea.setEditable(false);
outputArea.setFont(setFont);

fldProduct.setFont(setFont);
fldPrice.setFont(setFont);

pnlMain.add(lblProduct);
pnlMain.add(fldProduct);
pnlMain.add(lblPrice);
pnlMain.add(fldPrice);
pnlMain.add(outputArea);

btnSubmit.addActionListener(new actionButton1());
pnlMain.add(btnSubmit);
btnClearAll.addActionListener(new actionButton2());
pnlMain.add(btnClearAll);

this.add(pnlMain);
this.setVisible(true);

}
class actionButton1 implements ActionListener {
@Override
public void actionPerformed(ActionEvent a) {
String product= fldProduct.getText();
String price = fldPrice.getText();
outputArea.append("\nProduct:\n "+product+
"\n\nPrice:\n " +price);

try{


	FileWriter fw = new FileWriter("Depstore.txt", true);
	PrintWriter pw = new PrintWriter(fw);

	pw.append(product+ " " + price+ " ");
	

//	pw.println(System.getProperty("line.seperator"));

	pw.close();
	JOptionPane.showMessageDialog(null,"Success");
	setVisible(false);

	new Depstore().setVisible(true);
}
catch(Exception e){
	JOptionPane.showMessageDialog(null,"Error");
}

}
}
class actionButton2 implements ActionListener {
@Override
public void actionPerformed(ActionEvent e){
fldProduct.setText("");
fldPrice.setText("");
outputArea.setText("");
}
}
}
