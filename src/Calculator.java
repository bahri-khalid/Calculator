import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addBtn,subBtn,mulBtn,divBtn;
	JButton decBtn,equBtn,delBtn,clrBtn,negBtn;
	JPanel panel;
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	double num1 = 0,num2=0,result = 0;
	char operator;
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(340,500);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(20,25,300,40);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/");
		
		decBtn = new JButton(".");
		equBtn = new JButton("=");
		
		delBtn = new JButton("Del");
		clrBtn = new JButton("Clr");
		negBtn = new JButton("(-)");
		
		negBtn.setBounds(30, 385, 90,50);
		delBtn.setBounds(125, 385, 90, 50);
		clrBtn.setBounds(220, 385, 90, 50);
		delBtn.setBackground(Color.orange);
		clrBtn.setBackground(Color.red);
		negBtn.setBackground(Color.cyan);
		
		functionButtons[0] = addBtn;
		functionButtons[1] = subBtn;
		functionButtons[2] = mulBtn;
		functionButtons[3] = divBtn;
		functionButtons[4] = decBtn;
		functionButtons[5] = equBtn;
		functionButtons[6] = delBtn;
		functionButtons[7] = clrBtn;
		functionButtons[8] = negBtn;
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i]= new JButton(String.valueOf(i));
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].addActionListener(this);
		}
		
		for(int i = 0;i<9;i++) {
			functionButtons[i].setFont(myFont);
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
		}
		
		panel = new JPanel();
		panel.setBounds(20, 75, 300, 300);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new GridLayout(4,4	,10,10));
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(addBtn);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subBtn);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(mulBtn);
		panel.add(numberButtons[0]);
		panel.add(decBtn);
		panel.add(equBtn);
		panel.add(divBtn);
		
		
		
		frame.setVisible(true);
		frame.add(panel);
		frame.add(textfield);
		frame.add(negBtn);
		frame.add(delBtn);
		frame.add(clrBtn);
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		new Calculator();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i<10 ; i++) {
			if(e.getSource()==numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decBtn) {
			if(!textfield.getText().contains(".")) {
				
					textfield.setText(textfield.getText().concat("."));
			}
		}
		if(e.getSource()==addBtn) {
			operator = '+';
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==subBtn) {
			operator = '-';
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==mulBtn) {
			operator = '*';
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==divBtn) {
			operator = '/';
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==equBtn) {
			num2 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			switch(operator) {
			case '+':
				textfield.setText(String.format("%.4f",num1+num2));
				break;
			case '-':
				textfield.setText(String.format("%.4f",num1-num2));
				break;
			case '*':
				textfield.setText(String.format("%.4f",num1*num2));
				break;
			case '/':
				if(num2!=0) {
					textfield.setText(String.format("%.4f",num1/num2));
				}else {
					textfield.setText("");
				}
				break;
			}
			
		}
		if(e.getSource()==clrBtn) {
			textfield.setText("");
			
		}
		if(e.getSource()==negBtn) {
			if(!textfield.getText().contains("-")) {
				textfield.setText("-".concat(textfield.getText()));
			}else {
				textfield.setText((String)(textfield.getText()).replaceFirst("-", ""));
			}
		}
		if(e.getSource()==delBtn) {
			String cntnt = textfield.getText();
			textfield.setText(cntnt.substring(0,cntnt.length()-1));
		}
	}

}	
