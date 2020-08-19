package swing.youtube.tachenrechner.one.one;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import static swing.youtube.tachenrechner.one.one.ImagesURLImport.*;

@SuppressWarnings("serial")
public class TachenrechnerVerbessert extends JFrame {

	final private static String FIRST_OPERAND = "First operand";
	final private static String SECOND_OPERAND = "Second operand";

	private JLabel jLabelResult;
	private JTextField jTextFieldFirst, jTextFieldSecond;
	private JButton jButtonPlus, jButtonMinus, jButtonMultiply, jButtonDivide, jButtonResult;
	private Color color;
	private Integer resultInt = Integer.MAX_VALUE;
	private Double resultDouble = Double.MAX_VALUE;

	public TachenrechnerVerbessert() {
		super("Calculator");
		setLayout(new FlowLayout());
		setSize(300, 165);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setjLabelResult(new JLabel(""));

		setjTextFieldFirst(new JTextField(getFirstOperand()));
		setColor(getjTextFieldFirst().getCaretColor());
		getjTextFieldFirst().setForeground(Color.lightGray);
		getjTextFieldFirst().setPreferredSize(new Dimension(123, 26));
		getjTextFieldFirst().addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (getjTextFieldFirst().getText().isEmpty()) {
					getjTextFieldFirst().setForeground(Color.lightGray);
					getjTextFieldFirst().setText(getFirstOperand());
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (getjTextFieldFirst().getText().equals(getFirstOperand())) {
					getjTextFieldFirst().setForeground(getColor());
					getjTextFieldFirst().setText("");
				}
			}
		});

		setjTextFieldSecond(new JTextField(getSecondOperand()));
		getjTextFieldSecond().setForeground(Color.lightGray);
		getjTextFieldSecond().setPreferredSize(new Dimension(123, 26));
		getjTextFieldSecond().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (getjTextFieldSecond().getText().equals(getSecondOperand())) {
					getjTextFieldSecond().setForeground(getColor());
					getjTextFieldSecond().setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (getjTextFieldSecond().getText().isEmpty()) {
					getjTextFieldSecond().setForeground(Color.lightGray);
					getjTextFieldSecond().setText(getSecondOperand());
				}
			}
		});

		setjButtonPlus(new JButton());
		// getImagesURLImport();
		// getImagesURLImport();
		getjButtonPlus().setIcon(new ImageIcon(new ImageIcon(getFile() + "//" + getArraysuffix()[0].toString())
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		getjButtonPlus().setActionCommand("+");
		getjButtonPlus().addActionListener((ae) -> startCalculation(ae));
		getjButtonPlus().setPreferredSize(new Dimension(59, 26));

		setjButtonMinus(new JButton());
		getjButtonMinus().setIcon(new ImageIcon(new ImageIcon(getFile() + "//" + getArraysuffix()[1].toString())
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		getjButtonMinus().setActionCommand("-");
		getjButtonMinus().addActionListener((ae) -> startCalculation(ae));
		getjButtonMinus().setPreferredSize(new Dimension(59, 26));

		setjButtonMultiply(new JButton());
		getjButtonMultiply().setIcon(new ImageIcon(new ImageIcon(getFile() + "//" + getArraysuffix()[2].toString())
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		getjButtonMultiply().setActionCommand("*");
		getjButtonMultiply().addActionListener((ae) -> startCalculation(ae));
		getjButtonMultiply().setPreferredSize(new Dimension(59, 26));

		setjButtonDivide(new JButton());
		getjButtonDivide().setIcon(new ImageIcon(new ImageIcon(getFile() + "//" + getArraysuffix()[3].toString())
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		getjButtonDivide().setActionCommand("/");
		getjButtonDivide().addActionListener((ae) -> startCalculation(ae));
		getjButtonDivide().setPreferredSize(new Dimension(59, 26));

		setjButtonResult(new JButton());
		getjButtonResult().setIcon(new ImageIcon(new ImageIcon(getFile() + "//" + getArraysuffix()[4].toString())
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		getjButtonResult().setPreferredSize(new Dimension(59, 26));
		getjButtonResult().addActionListener((ae) -> {

			// if the first operand is missing and button(+,-,*,/) have not been pressed
			if (getResultInt() == Integer.MAX_VALUE && getResultDouble() == Double.MAX_VALUE
					&& getjTextFieldFirst().getText().equals(getFirstOperand())
					&& getjTextFieldSecond().getText().equals(getSecondOperand())) {
				getjLabelResult().setText(
						"                       +,-,*,/ and first and second operad are missing                       ");
				return;
			}
			// if the first operand is missing and button(+,-,*,/) have not been pressed
			else if (getResultInt() == Integer.MAX_VALUE && getResultDouble() == Double.MAX_VALUE
					&& getjTextFieldFirst().getText().equals(getFirstOperand())) {
				getjLabelResult()
						.setText("                       +,-,*,/ and first operad are missing                       ");
				return;
				// if the second operand is missing and button(+,-,*,/) have not been pressed
			} else if (getResultInt() == Integer.MAX_VALUE && getResultDouble() == Double.MAX_VALUE
					&& getjTextFieldSecond().getText().equals(getSecondOperand())) {
				getjLabelResult().setText(
						"                       +,-,*,/ and second operand are missing                       ");
				return;
				// if the button(+,-,*,/) have not been pressed
			} else if (getResultInt() == Integer.MAX_VALUE && getResultDouble() == Double.MAX_VALUE) {
				getjLabelResult().setText("                       +,-,*,/ are missing                       ");
				return;
			} else if (getResultInt() != Integer.MAX_VALUE) {
				JOptionPane.showConfirmDialog(TachenrechnerVerbessert.this, String.valueOf(resultInt), "Result",
						JOptionPane.INFORMATION_MESSAGE);
				getjTextFieldFirst().setForeground(Color.lightGray);
				getjTextFieldSecond().setForeground(Color.lightGray);
				getjTextFieldFirst().setText(getFirstOperand());
				getjTextFieldSecond().setText(getSecondOperand());
				resultInt = Integer.MAX_VALUE;
				getjLabelResult().setText("");
			} else {
				JOptionPane.showConfirmDialog(TachenrechnerVerbessert.this, String.valueOf(resultDouble), "Result",
						JOptionPane.INFORMATION_MESSAGE);
				getjTextFieldFirst().setForeground(Color.lightGray);
				getjTextFieldSecond().setForeground(Color.lightGray);
				getjTextFieldFirst().setText(getFirstOperand());
				getjTextFieldSecond().setText(getSecondOperand());
				resultDouble = Double.MAX_VALUE;
				getjLabelResult().setText("");
			}

		});

		add(getjTextFieldFirst());
		add(getjTextFieldSecond());
		add(getjButtonPlus());
		add(getjButtonMinus());
		add(getjButtonMultiply());
		add(getjButtonDivide());
		add(getjButtonResult());
		add(getjLabelResult());

		this.setVisible(true);

	}

	private void startCalculation(ActionEvent ae) {

		if (getjTextFieldFirst().getText().equals(getFirstOperand())
				&& getjTextFieldSecond().getText().equals(getSecondOperand())) {
			getjLabelResult().setText("            First and second operand are missing            ");
		} else if (getjTextFieldFirst().getText().equals(getFirstOperand())) {
			getjLabelResult().setText("            First operand is missing            ");
		} else if (getjTextFieldSecond().getText().equals(getSecondOperand())) {
			getjLabelResult().setText("            Second operand is missing            ");
		} else {
			getjLabelResult().setText("");
			try {
				// operands are Integer numbers
				int intFirst = Integer.parseInt(getjTextFieldFirst().getText().trim());
				int intSecond = Integer.parseInt(getjTextFieldSecond().getText().trim());
				resultInt = (Integer) chooseAction(ae.getActionCommand(), intFirst, intSecond);
			} catch (NumberFormatException nfe1) {
				try {
					// operands are Double numbers
					double doubleFirst = Double.parseDouble(getjTextFieldFirst().getText().trim());
					double doubleSecond = Double.parseDouble(getjTextFieldSecond().getText().trim());
					resultDouble = (Double) chooseAction(ae.getActionCommand(), doubleFirst, doubleSecond);
					// operands are incorrect(no Integer & no Double)
				} catch (NumberFormatException nfe2) {
					System.out.println("Incorrecter format");
					getjLabelResult().setText("            Incorrecter format            ");
				}
			}
		}

	}

	private Number chooseAction(String actionEvent, Number n1, Number n2) {

		switch (actionEvent) {
		case "+":
			if (n1.getClass() == Integer.class && n1.getClass() == Integer.class) {
				Integer resutHolder = (int) n1 + (int) n2;
				return resutHolder;
			} else {
				Double resultHolder = (double) n1 + (double) n2;
				return resultHolder;
			}
		case "-":
			if (n1.getClass() == Integer.class && n1.getClass() == Integer.class) {
				Integer resutHolder = (int) n1 - (int) n2;
				return resutHolder;
			} else {
				Double resultHolder = (double) n1 - (double) n2;
				return resultHolder;
			}
		case "*":
			if (n1.getClass() == Integer.class && n1.getClass() == Integer.class) {
				Integer resutHolder = (int) n1 * (int) n2;
				return resutHolder;
			} else {
				Double resultHolder = (double) n1 * (double) n2;
				return resultHolder;
			}
		case "/":
			if (n1.getClass() == Integer.class && n1.getClass() == Integer.class) {
				Integer resutHolder = (int) n1 / (int) n2;
				return resutHolder;
			} else {
				Double resultHolder = (double) n1 / (double) n2;
				return resultHolder;
			}
		default: {
			System.out.println("False ActionEvent: " + actionEvent);
		}
		}
		return 0;

	}

	public static String getFirstOperand() {
		return FIRST_OPERAND;
	}

	public static String getSecondOperand() {
		return SECOND_OPERAND;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Integer getResultInt() {
		return resultInt;
	}

	public Double getResultDouble() {
		return resultDouble;
	}

	public JLabel getjLabelResult() {
		return jLabelResult;
	}

	public void setjLabelResult(JLabel jLabelResult) {
		this.jLabelResult = jLabelResult;
	}

	public JTextField getjTextFieldFirst() {
		return jTextFieldFirst;
	}

	public void setjTextFieldFirst(JTextField jTextFieldFirst) {
		this.jTextFieldFirst = jTextFieldFirst;
	}

	public JTextField getjTextFieldSecond() {
		return jTextFieldSecond;
	}

	public void setjTextFieldSecond(JTextField jTextFieldSecond) {
		this.jTextFieldSecond = jTextFieldSecond;
	}

	public JButton getjButtonPlus() {
		return jButtonPlus;
	}

	public void setjButtonPlus(JButton jButtonPlus) {
		this.jButtonPlus = jButtonPlus;
	}

	public JButton getjButtonMinus() {
		return jButtonMinus;
	}

	public void setjButtonMinus(JButton jButtonMinus) {
		this.jButtonMinus = jButtonMinus;
	}

	public JButton getjButtonMultiply() {
		return jButtonMultiply;
	}

	public void setjButtonMultiply(JButton jButtonMultiply) {
		this.jButtonMultiply = jButtonMultiply;
	}

	public JButton getjButtonDivide() {
		return jButtonDivide;
	}

	public void setjButtonDivide(JButton jButtonDivide) {
		this.jButtonDivide = jButtonDivide;
	}

	public JButton getjButtonResult() {
		return jButtonResult;
	}

	public void setjButtonResult(JButton jButtonResult) {
		this.jButtonResult = jButtonResult;
	}

}
