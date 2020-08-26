package swing.youtube.tachenrechner.one.one;

import javax.swing.SwingUtilities;

public class DemoStartCalculator {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new CalculatorLogic());

	}

}
