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

	public Continuous2D yard = new Continuous2D(1.0,CONSTANTES.XTablero,CONSTANTES.YTablero);
	
	private static ArrayList<Alumnos> AlumnosArray;
	private static ArrayList<Profesores> ProfesoresArray;
	private static ArrayList<Actividad> ActividadesArray;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		yard.clear();
		Profesores.setIDcounter(0);
		Alumnos.setConstantID(0);
		Actividad.setIDcounter(0);
		PosicionesActividades.clean();
		Alumnos.setNumpositivo(0.0);
		ProfesoresArray=new ArrayList<Profesores>();
		AlumnosArray=new ArrayList<Alumnos>();
		ActividadesArray=new ArrayList<Actividad>();
		CrearAlumnos();
		//Necesitan los alumnos para saber la gente que ponen en cada actividad;
		CrearProfesores();
		
		for (Alumnos A : AlumnosArray) {
			yard.setObjectLocation(A,A.getPosicion());
			schedule.scheduleRepeating(A);
		}
		for (Profesores P : ProfesoresArray) {
			
			yard.setObjectLocation(P,P.getPosicion());	
			schedule.scheduleRepeating(P);
		}
		
		
		}

	private void CrearAlumnos() {
		for (int i = 0; i < CONSTANTES.Alumnos; i++) {
			Alumnos A=new Alumnos(this);
			AlumnosArray.add(A);
		}
	}

	private void CrearProfesores() {
		for (int i = 0; i < CONSTANTES.Profesores; i++) {
			Profesores P=new Profesores(this);
			ProfesoresArray.add(P);
		}
		
	}
	
	public static void main(String[] args) {
			doLoop(Curso.class,args);
			System. exit(0);
			
	}
	
	public static ArrayList<Actividad> getActividades() {
		return ActividadesArray;
	}

	public void addschedule(Actividad a) {
		
		schedule.scheduleRepeating(a);
	}
	
	public Continuous2D getYard() {
		return yard;
	}
	
	public void setYard(Continuous2D yard) {
		this.yard = yard;
	}
	
	public static ArrayList<Alumnos> getAlumnosArray() {
		return AlumnosArray;
	}
	
	public static ArrayList<Profesores> getProfesoresArray() {
		return ProfesoresArray;
	}
	
	
}
