import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;


public class Configuracion extends JFrame {

	private JPanel contentPane;
	private static PanelSlide AlumnosP;
	private static PanelSlide ProfesoresP;
	private static PanelSlide ActividadesP;
	private static PanelSlide ExigenciamediaVarP;
	private static PanelSlide YTableroP;
	private static PanelSlide XTableroP;
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
		setTitle("Configuracion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("Tama\u00F1o");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel label_1 = new JLabel("   X    ");
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel("   Y    ");
		panel_6.add(label_2);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_6.add(verticalStrut);
		
		JLabel label_3 = new JLabel("Alumnos");
		panel_6.add(label_3);
		
		JLabel label_4 = new JLabel("Profesores                ");
		panel_6.add(label_4);
		
		JLabel label_5 = new JLabel("Actividades/Profesor ");
		panel_6.add(label_5);
		
		JLabel label_6 = new JLabel("Exigencia Profesor        ");
		panel_6.add(label_6);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(7, 0, 0, 0));
		
		XTableroP = new PanelSlide(0, 300, XTablero);
		panel_7.add(XTableroP);
		
		YTableroP = new PanelSlide(0, 300, YTablero);
		panel_7.add(YTableroP);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_1);
		
		 AlumnosP = new PanelSlide(0, 300, Alumnos);
		panel_7.add(AlumnosP);
		
		 ProfesoresP = new PanelSlide(0, 300, Profesores);
		panel_7.add(ProfesoresP);
		
		 ActividadesP = new PanelSlide(0, 300, Actividades);
		panel_7.add(ActividadesP);
		
		 ExigenciamediaVarP = new PanelSlide(0, 5, ExigenciamediaVar - 1 - (ExigenciamediaVar/2));
		panel_7.add(ExigenciamediaVarP);
		
		}

	public static void Bloquear() {
		int X = XTableroP.getValue();
		int Y = YTableroP.getValue();
		int AlumnosT = AlumnosP.getValue();
		int ProfesoresT = ProfesoresP.getValue();
		int ActividadesT = ActividadesP.getValue();
		int ExigenciamediaVarT  = ExigenciamediaVarP.getValue()* 2 + 1;
		
		CONSTANTES.setActividades(Actividades);
		CONSTANTES.setAlumnos(Alumnos);
		CONSTANTES.setExigenciamediaVar(ExigenciamediaVar);
		CONSTANTES.setProfesores(Profesores);
		CONSTANTES.setXTablero(X);
		CONSTANTES.setYTablero(Y);
		
	}

}
