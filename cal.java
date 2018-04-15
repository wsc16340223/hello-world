import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class Calculator implements ActionListener {

	private JTextField num1;
	private JTextField num2;
	private JLabel symbol;
	
	private JLabel result;
	
	
	public Calculator() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int a, b;
		a = Integer.parseInt(num1.getText());
		b = Integer.parseInt(num2.getText());
		if (e.getActionCommand().equals("+")) {
			symbol.setText("+");
		}
		else if (e.getActionCommand().equals("-")) {
			symbol.setText("-");
		}
		else if (e.getActionCommand().equals("*")) {
			symbol.setText("*");
		}
		else if (e.getActionCommand().equals("/")) {
			symbol.setText("/");
		}
		
		if (e.getActionCommand().equals("OK")) {
			if (symbol.getText().equals("+")){
				String s = String.valueOf(a+b);
				result.setText(s);
			}
			else if (symbol.getText().equals("-")) {
				String s = String.valueOf(a-b);
				result.setText(s);
			}
			else if (symbol.getText().equals("*")) {
				String s = String.valueOf(a*b);
				result.setText(s);
			}
			else if (symbol.getText().equals("/")) {
				if (b == 0) {
					result.setText("NaN");
				}
				String s = String.valueOf(a/b);
				result.setText(s);
			}
		}
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Easy Calculater");
		JPanel pan = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = frame.getContentPane();
		GridLayout layout = new GridLayout(2 ,5 ,10 ,10 );
		pan.setLayout(layout);
		cp.add(pan);
		frame.pack();

		JLabel equal;
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton multi = new JButton("*");
		JButton div = new JButton("/");
		JButton ok = new JButton("OK");
		
		num1 = new JTextField("12",5);
		num2 = new JTextField("2",5);
		symbol = new JLabel("");
		equal = new JLabel("=");
		result = new JLabel("");
		
		frame.setSize(400,200);
		frame.setLocation(400, 300);
		
		pan.add(num1);
		pan.add(symbol);
		pan.add(num2);
		pan.add(equal);
		pan.add(result);
		
		pan.add(plus);
		pan.add(minus);
		pan.add(multi);
		pan.add(div);
		pan.add(ok);
		
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		multi.addActionListener(this);
		div.addActionListener(this);
		ok.addActionListener(this);
		
		frame.setVisible(true);
	}
}
