import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.BorderLayout;


public class PanelSlide extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelSlide(int start,int end,int actual) {
		setLayout(new BorderLayout(0, 0));
		
		JSlider slider = new JSlider();
		slider.setValue(actual);
		slider.setMaximum(start);
		slider.setMinimum(end);
		add(slider, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setEditable(false);
		add(textField, BorderLayout.EAST);
		textField.setColumns(10);
		textField.setText(Integer.toString(actual));
			}

}
