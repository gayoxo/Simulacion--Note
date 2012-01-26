import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;

import sim.engine.*;
import sim.portrayal.DrawInfo2D;
import sim.portrayal.continuous.ContinuousPortrayal2D;
import sim.portrayal.simple.OvalPortrayal2D;
import sim.display.*;

public class StudentsWithUI extends GUIState {
	
	public Display2D display;
	public JFrame displayFrame;
	ContinuousPortrayal2D yardPortrayal = new ContinuousPortrayal2D();
	
	
	public static void main(String[] args) {
		CONSTANTES.LoadLibros(CargaLibros());
		CONSTANTES.LoadNombres(CargaNombres());
		StudentsWithUI vid = new StudentsWithUI();
		Console c = new Console(vid);
		c.setVisible(true);
	}

	private static ArrayList<String> CargaNombres() {
		ArrayList<String> Salida = new ArrayList<String>();
		File archivo=new File("Nombres.txt");
		try {
		BufferedReader reader = new BufferedReader(new FileReader(archivo));
		String linea = reader.readLine();
		while ((linea = reader.readLine()) != null) {
		Salida.add(linea);
		}
		} catch (Exception ex) {
		}
		return Salida;
	}

	private static ArrayList<String> CargaLibros() {
		ArrayList<String> Salida = new ArrayList<String>();
		File archivo=new File("Libros.txt");
		try {
		BufferedReader reader = new BufferedReader(new FileReader(archivo));
		String linea = reader.readLine();
		while ((linea = reader.readLine()) != null) {
		Salida.add(linea);
		}
		} catch (Exception ex) {
		}
		return Salida;
	}

	public StudentsWithUI() {
		super(new Curso(System.currentTimeMillis()));
	}

	public StudentsWithUI(SimState state) {
		super(state);
	}

	public static String getName() {
		return "Simulacion de anotador";
	}
	
	public void init(Controller c){
		super.init(c);
		display = new Display2D(300,300,this);
		display.setClipping(false);
		displayFrame = display.createFrame();
		displayFrame.setTitle("Simulacion de anotador");
		c.registerFrame(displayFrame);
		displayFrame.setVisible(true);
		display.attach( yardPortrayal, "Yard" );
		}
	
	public void start(){
		super.start();
		setupPortrayals();
		}
		public void load(SimState state){
		super.load(state);
		setupPortrayals();
		}
		public void quit(){
		super.quit();
		if (displayFrame!=null) displayFrame.dispose();
		displayFrame = null;
		display = null;
		}
		
		
		public void setupPortrayals(){
			Curso students = (Curso) state;
			// tell the portrayals what to portray and how to portray them
			yardPortrayal.setField( students.yard );
			yardPortrayal.setPortrayalForAll(new OvalPortrayal2D()
			{
				@Override
				public void draw(Object object, Graphics2D graphics,
						DrawInfo2D info) {
					if (object instanceof Alumnos){
						paint = Color.BLUE;
					}
					else if (object instanceof Profesores)
						paint = Color.WHITE;
					else
						{
						Actividad A=(Actividad) object;
						if (A.getEstado()==Estado.SinAtributos)
							paint=Color.YELLOW;
						else if (A.getEstado()==Estado.Activa)
							paint=Color.GREEN;
						else if (A.getEstado()==Estado.RecienAcabada)
							paint=Color.RED;
						else paint=Color.RED;
						}
					super.draw(object, graphics, info);

				}
			
			});
			// reschedule the displayer
			display.reset();
			display.setBackdrop(Color.BLACK);
			// redraw the display
			display.repaint();
			}
}
