import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorV2 implements ActionListener {
	JFrame frame;
	JTextField textfield;
	JPanel panel,panel2 ;
	JButton[] numberButtons = new JButton[10];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,equButton;
	JButton negButton,delButton,clrButton;
	JButton[] functionButtons = new JButton[9];
	Font myFont = new Font("TimesRoman",Font.BOLD,20);
	double num1,num2;
	char operator;
	
	CalculatorV2(){
		frame = new JFrame("Calculator-V-2");
		frame.setSize(300, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		Container c = frame.getContentPane();
		c.setBackground(new Color(22,55,66));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textfield = new JTextField();
		textfield.setBounds(20,20,260,50);
		textfield.setEditable(false);
		textfield.setFont(myFont);
		textfield.setBackground(new Color(47,79,79));
		textfield.setForeground(new Color(218,165,32));
		textfield.setBorder(BorderFactory.createLineBorder(new Color(218,165,32), 2));
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		negButton = new JButton("[-]");
		delButton = new JButton("delete");
		clrButton = new JButton("clear");
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = equButton;
		functionButtons[5] = decButton;
		functionButtons[6] = negButton;
		functionButtons[7] = delButton;
		functionButtons[8] = clrButton;
		for(int i = 0; i<10 ; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(new Color(47,79,79));
			numberButtons[i].setForeground(new Color(218,165,32));
			numberButtons[i].addActionListener(this);
		}
		
		for(int i = 0;i<9;i++) {
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(new Color(37,49,49));
			functionButtons[i].setForeground(new Color(218,165,32));
			functionButtons[i].addActionListener(this);
		}
		panel = new JPanel();
		panel.setBounds(20, 120, 260, 340);
		panel.setBackground(new Color(218,165,32));
		panel.setLayout(new GridLayout(4,4,2,2));
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		panel2  = new JPanel();
		panel2.setBounds(20,77,260,40);
		panel2.setLayout(new GridLayout(1,3,0,0));
		panel2.setBackground(new Color(218,165,32));
		panel2.add(negButton);
		panel2.add(delButton);
		panel2.add(clrButton);
		negButton.setBorder(BorderFactory.createLineBorder(new Color(218,165,32),1));
		delButton.setBorder(BorderFactory.createLineBorder(new Color(218,165,32),1));
		clrButton.setBorder(BorderFactory.createLineBorder(new Color(218,165,32),1));
		frame.add(panel);
		frame.add(panel2);
		frame.add(textfield);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorV2();

	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		for(int i = 0; i<10 ; i++ ) {
			if(event.getSource()==numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(event.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '+';
		}
		if(event.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '-';
		}
		if(event.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '*';
		}
		if(event.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '/';
		}
		if(event.getSource()==equButton) {
			if(textfield.getText().length()>0)
				num2 = Double.parseDouble(textfield.getText());
			else
				num2=0;
			switch(operator) {
			case '+':
				textfield.setText(String.format("%.4f", num1+num2));
				operator='_';
				break;
			case '-':
				textfield.setText(String.format("%.4f", num1-num2));
				operator='_';
				break;
			case '*':
				textfield.setText(String.format("%.4f", num1*num2));
				operator='_';
				break;
			case '/':
				if(num2 != 0) {	
					textfield.setText(String.format("%.4f", num1/num2));
					operator='_';
				}
				else
					textfield.setText("");
				break;
			default:
				textfield.setText("");
				break;
			}
		}
		if(event.getSource()==decButton) {
			if((!textfield.getText().contains(".")) && (textfield.getText().length()>0)) {
				textfield.setText(textfield.getText().concat("."));
			}
		}
		if(event.getSource()==delButton) {
			if(textfield.getText().length()>0)
			textfield.setText(textfield.getText().substring(0, textfield.getText().length()-1));
		}
		if(event.getSource()==clrButton) {
			textfield.setText("");
			num1=0;
			num2=0;
			operator='_';
		}
		if(event.getSource()==negButton) {
			if(!textfield.getText().contains("-")) {
				textfield.setText("-".concat(textfield.getText()));
			}else {
				textfield.setText(textfield.getText().substring(1,textfield.getText().length()));
			}
		}
		
	}

}
