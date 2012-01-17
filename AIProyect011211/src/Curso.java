import java.util.ArrayList;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;
import sim.util.Double2D;


public class Curso extends SimState{
	
	public Curso(long seed) {
		super(seed);
		// TODO Auto-generated constructor stub
	}

	public Continuous2D yard = new Continuous2D(1.0,100,100);
	
	private ArrayList<Alumnos> Alumnos;
	private ArrayList<Profesores> Profesores;
	private static ArrayList<Actividad> Actividades;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		yard.clear();
		Profesores=new ArrayList<Profesores>();
		Alumnos=new ArrayList<Alumnos>();
		Actividades=new ArrayList<Actividad>();
		CrearProfesores();
		CrearAlumnos();
		for (Profesores P : Profesores) {
			yard.setObjectLocation(P,
					new Double2D( yard.getWidth()*0.5+random.nextDouble()-0.5,
							yard.getHeight()*0.5+random.nextDouble()-0.5));
			schedule.scheduleRepeating(P);
		}
		for (Alumnos A : Alumnos) {
			yard.setObjectLocation(A,
					new Double2D( yard.getWidth()*0.5+random.nextDouble()-0.5,
							yard.getHeight()*0.5+random.nextDouble()-0.5));
			schedule.scheduleRepeating(A);
		}
		
		}

	private void CrearAlumnos() {
		for (int i = 0; i < CONSTANTES.Alumnos; i++) {
			Alumnos.add(new Alumnos());
		}
	}

	private void CrearProfesores() {
		for (int i = 0; i < CONSTANTES.Profesores; i++) {
			Profesores P=new Profesores();
			P.addCurso(this);
			Profesores.add(P);
		}
		
	}
	
	public static void main(String[] args) {
			doLoop(Curso.class,args);
			System. exit(0);
			
	}
	
	public static ArrayList<Actividad> getActividades() {
		return Actividades;
	}

	public void addschedule(Actividad a) {
		
		schedule.scheduleRepeating(a);
	}
	
	
}
