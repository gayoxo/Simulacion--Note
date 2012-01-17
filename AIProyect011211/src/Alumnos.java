import sim.engine.SimState;
import sim.engine.Steppable;


public class Alumnos implements Steppable{

	private static int ConstantID=1;
	private int Id;
	private int Energia;
	private int Productividad;
	private boolean Esfuerzo;
	
	public Alumnos() {
	Id=ConstantID++;
	}
	
	@Override
	public void step(SimState arg0) {
		System.out.println(Id + " EstoyVivo!!!!!");		
	}

}
