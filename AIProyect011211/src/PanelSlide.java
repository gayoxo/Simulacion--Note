import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PanelSlide extends JPanel {
	private JTextField textField;
	private JSlider slider;

	/**
	 * Create the panel.
	 */
	public PanelSlide(int start,int end,int actual) {
		setLayout(new BorderLayout(0, 0));
		
		slider = new JSlider();
		slider.setMaximum(end);
		slider.setMinimum(start);
		slider.setValue(actual);
		add(slider, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setEditable(false);
		add(textField, BorderLayout.EAST);
		textField.setColumns(10);
		textField.setText(Integer.toString(actual));
		
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textField.setText(Integer.toString(slider.getValue()));	
			}
		});
			}
	
	
	public int getValue() {
		return slider.getValue();
	}
	
	

}
