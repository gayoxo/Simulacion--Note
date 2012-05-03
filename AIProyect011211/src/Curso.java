import java.util.ArrayList;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;
import sim.field.network.Network;
import sim.util.Bag;
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
	public Network buddies = new Network(false);
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		yard = new Continuous2D(1.0,CONSTANTES.XTablero,CONSTANTES.YTablero);
		yard.clear();
		Profesores.setIDcounter(0);
		Profesores.setNumpositivo(0);
		Alumnos.setConstantID(0);
		Alumnos.setNumpositivo(0.0);
		Actividad.setIDcounter(0);
		PosicionesActividades.clean();
		PosicionesActividades.getInstance().restart();
		ProfesoresArray=new ArrayList<Profesores>();
		AlumnosArray=new ArrayList<Alumnos>();
		ActividadesArray=new ArrayList<Actividad>();
		CrearAlumnos();
		//Necesitan los alumnos para saber la gente que ponen en cada actividad;
		CrearProfesores();
		
		for (Alumnos A : AlumnosArray) {
			yard.setObjectLocation(A,A.getPosicion());
			schedule.scheduleRepeating(A);
			buddies.addNode(A);
		}
		generarAmistades();
		for (Profesores P : ProfesoresArray) {
			
			yard.setObjectLocation(P,P.getPosicion());	
			schedule.scheduleRepeating(P);
		}
		
		
		}

	private void generarAmistades() {
		Bag Alumnos = buddies.getAllNodes();
		for(int i = 0; i < Alumnos.size(); i++) {
			Object Alumno = Alumnos.get(i);
		// who does he like?
			Object AlumnoB = null;
			do
				AlumnoB =Alumnos.get(random.nextInt(CONSTANTES.Alumnos));
			while (Alumno == AlumnoB);
			
			double buddiness = random.nextInt(2);
				buddies.addEdge(Alumno, AlumnoB, new Double(buddiness));
		// who does he dislike?
				do
					AlumnoB =Alumnos.get(random.nextInt(CONSTANTES.Alumnos));
				while (Alumno == AlumnoB);
					buddiness = random.nextInt(2);
					buddies.addEdge(Alumno, AlumnoB, new Double(-buddiness));
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
