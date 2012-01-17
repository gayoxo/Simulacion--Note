import sim.engine.SimState;
import sim.engine.Steppable;
import sim.util.Double2D;


public class Alumnos implements Steppable{

	private static int ConstantID=1;
	private int Id;
	private int Energia;
	private int Productividad;
	private boolean Esfuerzo;
	private Curso Cur;
	private Double2D Posicion;
	
	public Alumnos(Curso curso) {
	Id=ConstantID++;
	Cur=curso;
	Posicion=new Double2D(Cur.getYard().width-1,Id);
	}
	
	@Override
	public void step(SimState arg0) {
	//	System.out.println(Id + " EstoyVivo!!!!!");		
	}
	
	public Double2D getPosicion() {
		return Posicion;
	}

}
