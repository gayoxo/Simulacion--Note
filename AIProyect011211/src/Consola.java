import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;


public class Consola extends JFrame {

	private static Consola Yo;
	private JTextArea textArea;
	
	private Consola() {
		setTitle("Consola");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		setPreferredSize(new Dimension(630, 300));
		setSize(new Dimension(630, 300));
	}
	
	public static Consola getInstance()
	{
		if (Yo==null) Yo=new Consola();
		return Yo;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
}
