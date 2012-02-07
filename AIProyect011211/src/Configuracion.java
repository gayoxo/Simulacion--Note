import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class Configuracion extends JFrame {

	private JPanel contentPane;
	public static int Profesores=6;
	public static int ExigenciamediaVar=5;
	public static int Alumnos=35;
	public static int Actividades=7;
	public static int YTablero=50;
	public static int XTablero=50;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracion frame = new Configuracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Configuracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		PanelSlide AlumnosP = new PanelSlide(0,XTablero,Alumnos);
		contentPane.add(AlumnosP);
		
		}

	public static void Bloquear() {
		CONSTANTES.setActividades(Actividades);
		CONSTANTES.setAlumnos(Alumnos);
		CONSTANTES.setExigenciamediaVar(ExigenciamediaVar);
		CONSTANTES.setProfesores(Profesores);
		CONSTANTES.setXTablero(XTablero);
		CONSTANTES.setYTablero(YTablero);
		
	}

}
