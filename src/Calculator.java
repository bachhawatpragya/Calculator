import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberbut= new JButton[10];
	JButton[] functionButt=new JButton[13];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equalButton, delButton, clrButton,negButton ;
	JButton modButton,sqButton,cubeButton, onebyxButton;
	JPanel panel;
	Font myFont= new Font("Ink Free", Font.BOLD,30);
	Font funFont= new Font("Ink Free", Font.BOLD,20);
	double num1=0,n2=0,result=0;
	char operator;
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton=new JButton("+");
		subButton=new JButton("-");
		mulButton=new JButton("*");
		divButton=new JButton("/");
		decButton=new JButton(".");
		equalButton=new JButton("=");
		delButton=new JButton("Delete");
		clrButton=new JButton("Clear");
		negButton=new JButton("(-)");
		modButton= new JButton("%");
		sqButton= new JButton("x^2");
		cubeButton= new JButton("x^3");
		onebyxButton= new JButton("1/x");
		
		functionButt[0]=addButton;
		functionButt[1]=subButton;
		functionButt[2]=mulButton;
		functionButt[3]=divButton;
		functionButt[4]=decButton;
		functionButt[5]=equalButton;
		functionButt[6]=delButton;
		functionButt[7]=clrButton;
		functionButt[8]=negButton;
		functionButt[9]=modButton;
		functionButt[10]=sqButton;
		functionButt[11]=cubeButton;
		functionButt[12]=onebyxButton;

		for(int i=0;i<10;i++) {
			functionButt[i].addActionListener(this);
			functionButt[i].setFont(myFont);
			functionButt[i].setFocusable(false);
		}
		for(int i=10;i<13;i++) {
			functionButt[i].addActionListener(this);
			functionButt[i].setFont(funFont);
			functionButt[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
			numberbut[i]=new JButton(String.valueOf(i));
			numberbut[i].addActionListener(this);
			numberbut[i].setFont(myFont);
			numberbut[i].setFocusable(false);
		}

		negButton.setBounds(50, 430, 80, 50);
		delButton.setBounds(130, 430, 125, 50);
		clrButton.setBounds(255, 430, 105, 50);
		
		panel=new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(5,4,10,10));
		
		panel.add(numberbut[1]);
		panel.add(numberbut[2]);
		panel.add(numberbut[3]);
		panel.add(addButton);
		panel.add(numberbut[4]);
		panel.add(numberbut[5]);
		panel.add(numberbut[6]);
		panel.add(subButton);
		panel.add(numberbut[7]);
		panel.add(numberbut[8]);
		panel.add(numberbut[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberbut[0]);
		panel.add(equalButton);
		panel.add(divButton);
		panel.add(onebyxButton);
		panel.add(sqButton);
		panel.add(cubeButton);
		panel.add(modButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc= new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(e.getSource()== numberbut[i]) {
				if(i==0) {
					String s=textfield.getText();
					if(!s.equals("")) {
						textfield.setText(s+"0");
					}
				}
				else {
					textfield.setText(textfield.getText().concat(String.valueOf(i)));
				}
			}
		}
		if(e.getSource()==decButton) {
			if(!textfield.getText().contains(".")) {
				textfield.setText(textfield.getText().concat("."));
			}
		}
		if(e.getSource()==addButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
		}
		if(e.getSource()==modButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='%';
			textfield.setText("");
		}
		if(e.getSource()==equalButton) {
			n2= Double.parseDouble(textfield.getText());
			switch(operator) {
			case'+':
				result=num1+n2;
				break;
			case'-':
				result=num1-n2;
				break;
			case'*':
				result=num1*n2;
				break;
			case'/':
				result=num1/n2;
				break;
			case'%':
				result=num1%n2;
				break;
			}
			
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==onebyxButton) {
			textfield.setText((1/Double.parseDouble(textfield.getText()))+"");
		}
		if(e.getSource()==sqButton) {
			textfield.setText(Math.pow(Double.parseDouble(textfield.getText()),2.0)+"");
		}
		if(e.getSource()==cubeButton) {
			textfield.setText(Math.pow(Double.parseDouble(textfield.getText()),3.0)+"");
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String str=textfield.getText();
			textfield.setText("");
			for(int i=0;i<str.length()-1;i++) {
				textfield.setText(textfield.getText()+str.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			Double temp=Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}

}
