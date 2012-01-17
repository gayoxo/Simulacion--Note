import java.util.ArrayList;

import sim.engine.SimState;
import sim.engine.Steppable;


public class Actividad implements Steppable{

	
	private int Id;
	private int Completitud;
	private int Nota;
	private boolean AtributosFijados;
	private ArrayList<Alumnos> Alumnos;
	private int ciclosLimite;
	private Profesores MiCreador;
	
	public Actividad(Profesores profesores) {
MiCreador=profesores;
}

	@Override
	public void step(SimState arg0) {
		System.out.println("Actividad:" + Id + " esta viva");
		
	}
	
	
	
}
