import java.util.ArrayList;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.util.Double2D;


public class Actividad implements Steppable{

	
	private static int IDcounter=1;
	private int Id;
	private int Completitud;
	private int Nota;
	private boolean AtributosFijados;
	private ArrayList<Alumnos> Alumnos;
	private int ciclosLimite;
	private Profesores MiCreador;
	private Curso Cur;
	private Double2D Posicion;
	
	public Actividad(Profesores profesores) {
MiCreador=profesores;
Id=IDcounter++;
Cur=profesores.getCursosPertenezco();
Posicion=new Double2D(Cur.getYard().width*0.5,Id);
}

	@Override
	public void step(SimState arg0) {
		System.out.println("Actividad:" + Id + " esta viva");
		
	}
	
	
	
}
