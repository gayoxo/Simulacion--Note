import java.util.ArrayList;
import java.util.Random;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;


public class Profesores implements Steppable {
	

	private static int IDcounter=1;
	private int Id;
	private int Exigencia;
	private ArrayList<Actividad> ActividadesMias;
	
	public Profesores() {
	Id=IDcounter++;
	Random R=new Random();
	Exigencia= -2 + R.nextInt(CONSTANTES.ExigenciamediaVar);
	}
	
	@Override
	public void step(SimState arg0) {
		if (ActividadesMias.size()<CONSTANTES.Actividades)
		{
			Actividad A=new Actividad(this);
			ActividadesMias.add(A);
			Curso.getActividades().add(A);
		}
	}
}
