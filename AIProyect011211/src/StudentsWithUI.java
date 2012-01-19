import java.awt.Color;

import javax.swing.JFrame;

import sim.engine.*;
import sim.portrayal.continuous.ContinuousPortrayal2D;
import sim.portrayal.simple.OvalPortrayal2D;
import sim.display.*;

public class StudentsWithUI extends GUIState {
	
	public Display2D display;
	public JFrame displayFrame;
	ContinuousPortrayal2D yardPortrayal = new ContinuousPortrayal2D();
	
	
	public static void main(String[] args) {
		StudentsWithUI vid = new StudentsWithUI();
		Console c = new Console(vid);
		c.setVisible(true);
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
		displayFrame.setTitle("Schoolyard Display");
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
			yardPortrayal.setPortrayalForAll(new OvalPortrayal2D());
			// reschedule the displayer
			display.reset();
			display.setBackdrop(Color.BLACK);
			// redraw the display
			display.repaint();
			}
}
