import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


import sim.engine.SimState;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;
import sim.util.Double2D;


public class Profesores implements Steppable {
	

	private String Name;
	private static int IDcounter=0;
	private int Id;
	private int Exigencia;
	private ArrayList<Actividad> ActividadesMias;
	private int actividadesCompletas;
	private ArrayList<Actividad> ActividadesActivas;
	private Curso CursosPertenezco;
	private Double2D Posicion;
	private static boolean positivo;
	private static double numpositivo=0.0;
	private ArrayList<ArrayList<Alumnos>> AlumnosGrupos; 
	
	public Profesores(Curso e) {
		
		Name=CONSTANTES.GetNombreAleatorioNombre();
		positivo=!positivo;
	CursosPertenezco=e;	
	Id=IDcounter++;
	actividadesCompletas=0;
	Random R=new Random();
	int ExigenciaMin=CONSTANTES.ExigenciamediaVar -1 - (CONSTANTES.ExigenciamediaVar/2);
	Exigencia= -ExigenciaMin + R.nextInt(CONSTANTES.ExigenciamediaVar);
	ActividadesMias=new ArrayList<Actividad>();
	ActividadesActivas=new ArrayList<Actividad>();
	if (positivo)
		numpositivo=numpositivo + Id*2;
	else
		numpositivo=numpositivo - Id*2;
	
		Posicion=new Double2D(3,CursosPertenezco.getYard().height*0.5 - numpositivo);
	AlumnosGrupos=CONSTANTES.getAlumnosRandom(Curso.getAlumnosArray(), CONSTANTES.Actividades);
	
	}
	
	@Override
	public void step(SimState arg0) {
		Double2D PosicionOri = CursosPertenezco.yard.getObjectLocation(this);
		if ((PosicionOri.getX()==Posicion.getX()) && (PosicionOri.getY()==Posicion.getY()))
		{
			if (ActividadesMias.size()<CONSTANTES.Actividades)
			{
				Double2D PosicionActNew = PosicionesActividades.getInstance().getNexOpen(CursosPertenezco);
				if (PosicionActNew!=null){
					
					ArrayList<Alumnos> Seleccionados=AlumnosGrupos.get(ActividadesMias.size());
					int Ciclos=CONSTANTES.getCiclos(Seleccionados.size());
					
					
					
					Actividad A=new Actividad(this,Ciclos,PosicionActNew);
					Double2D ActPos=new Double2D(A.getPosicion().getX()-1,A.getPosicion().getY());
					CursosPertenezco.yard.setObjectLocation(this, ActPos);
					ActividadesMias.add(A);
					ActividadesActivas.add(A);
					Curso.getActividades().add(A);
					CursosPertenezco.addschedule(A);	
	//				System.out.println("Actividad creada por Profesor " + Id + " con Identificador " + A.getId());
					
					for (Alumnos alumno : Seleccionados) {
						alumno.getImplicado().add(A);
						A.getListaAlumnos().add(alumno);
					}
					
				}
			}
			else {
				if (actividadesCompletas!=CONSTANTES.Actividades)
				{
				Random R=new Random();
				
				int ActAct=R.nextInt(ActividadesActivas.size());
				Actividad A=ActividadesActivas.get(ActAct);					
					if ((A.getEstado()==Estado.SinAtributos))
						{
						Double2D ActPos=new Double2D(A.getPosicion().getX()-1,A.getPosicion().getY());
						CursosPertenezco.yard.setObjectLocation(this, ActPos);
						A.setAtributosFijados(CONSTANTES.GetNombreAleatorioLibro());
	//					System.out.println("A la Actividad " + A.getId() + " se le han setado los atributos");
						}
					else if (A.getEstado()==Estado.RecienAcabada)
						{
						int notaPar=A.getCompletitud()/10;
						int notaFin=notaPar+Exigencia;
						if (notaFin>10) notaFin=10;
							if (notaFin<0) notaFin=0;
							A.setNota(notaFin);
						Double2D ActPos=new Double2D(A.getPosicion().getX()-1,A.getPosicion().getY());
						CursosPertenezco.yard.setObjectLocation(this, ActPos);
	//					System.out.println("La nota final para la Actividad " + A.getId() + " es de : " + notaFin);
						A.setFinalizada();
						actividadesCompletas++;
						CursosPertenezco.yard.remove(A);
						ActividadesActivas.remove(A);
						double remList=A.getPosicion().getY();
//						double salida=0;
//						if (remList<25) salida=25-remList;
//						 else salida=remList-25;
						PosicionesActividades.removeActividad((int)remList);
						
						}
					else {
						Double2D ActPos=new Double2D(A.getPosicion().getX()-1,A.getPosicion().getY());
						CursosPertenezco.yard.setObjectLocation(this, ActPos);
						int notaFin=A.getCompletitud()/10;
						if (notaFin>10) {
							A.setState(Estado.Terminada);
							notaFin=10;
						}
							if (notaFin<0) notaFin=0;
							A.setNota(notaFin);
						}
				

			
				}
			}
		}
		else
		{
			CursosPertenezco.yard.setObjectLocation(this, Posicion);	
		}
	}
	
	public void setActividadesMias(ArrayList<Actividad> actividadesMias) {
		ActividadesMias = actividadesMias;
		ActividadesActivas=new ArrayList<Actividad>(actividadesMias);
	}
	
	
	
	public Double2D getPosicion() {
		return Posicion;
	}
	
	public Curso getCursosPertenezco() {
		return CursosPertenezco;
	}
	
	public static void setIDcounter(int iDcounter) {
		IDcounter = iDcounter;
	}
	
	public int getId() {
		return Id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}
	
	public static void setNumpositivo(double numpositivo) {
		Profesores.numpositivo = numpositivo;
	}
}
