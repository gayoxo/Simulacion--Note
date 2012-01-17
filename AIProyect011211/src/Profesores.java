import java.util.ArrayList;
import java.util.Random;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;
import sim.util.Double2D;


public class Profesores implements Steppable {
	

	private static int IDcounter=1;
	private int Id;
	private int Exigencia;
	private ArrayList<Actividad> ActividadesMias;
	private Curso CursosPertenezco;
	private Double2D Posicion;
	
	public Profesores(Curso e) {
		
	CursosPertenezco=e;	
	Id=IDcounter++;
	Posicion=new Double2D(0,Id);
	Random R=new Random();
	Exigencia= -2 + R.nextInt(CONSTANTES.ExigenciamediaVar);
	ActividadesMias=new ArrayList<Actividad>();
	
	}
	
	@Override
	public void step(SimState arg0) {
		if (ActividadesMias.size()<CONSTANTES.Actividades)
		{
			Actividad A=new Actividad(this);
			ActividadesMias.add(A);
			Curso.getActividades().add(A);
			System.out.println("Creada Actividad por Profesor" + Id);
			CursosPertenezco.addschedule(A);	
			
		}
	}
	
	public void setActividadesMias(ArrayList<Actividad> actividadesMias) {
		ActividadesMias = actividadesMias;
	}
	
	
	
	public Double2D getPosicion() {
		return Posicion;
	}
	
	public Curso getCursosPertenezco() {
		return CursosPertenezco;
	}
}
