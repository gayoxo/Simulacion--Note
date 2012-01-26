import java.util.ArrayList;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.util.Double2D;


public class Actividad implements Steppable{

	
	private static int IDcounter=0;
	private int Id;
	private int Completitud;
	private int Nota;
	private int ciclosLimite;
	private int cicloActual;
	private String Nombre;
	private Estado State;
	private Curso Cur;
	private Double2D Posicion;
	private ArrayList<Alumnos> ListaAlumnos;
	private String Profesor;

	
	public Actividad(Profesores profesores,int CiclosLimite, Double2D posicionActNew) {
Id=IDcounter++;
Cur=profesores.getCursosPertenezco();
Profesor=profesores.getName();
Completitud=0;
Nota=0;
ciclosLimite=CiclosLimite;
cicloActual=0;
State=Estado.SinAtributos;
Posicion=posicionActNew;
ListaAlumnos=new ArrayList<Alumnos>();
//Posicion=new Double2D(Cur.getYard().width*0.5,Id);



//System.out.println("Posicion: " + Posicion.getX()+ "," + Posicion.getY());
	
Cur.getYard().setObjectLocation(this, Posicion);

}

	@Override
	public void step(SimState arg0) {
		
		if (State==Estado.Activa){
			if (cicloActual<ciclosLimite)
			{
				cicloActual++;
			}
			else 
			{
				State=Estado.RecienAcabada;
			}
		}
	}
	
	
	public Double2D getPosicion() {
		return Posicion;
	}
	
	public static void setIDcounter(int iDcounter) {
		IDcounter = iDcounter;
	}
	
	
	public Estado getEstado() {
		return State;
	}
	
	public void setAtributosFijados(String NombreLibro) {
		Nombre=NombreLibro;
		State =Estado.Activa;
	}
	public int getId() {
		return Id;
	}
	
	public int getCompletitud() {
		return Completitud;
	}
	
	public void setNota(int nota) {
		Nota = nota;
	}
	
	public int getNota() {
		return Nota;
	}
	
	public void setPosicion(Double2D posicion) {
		Posicion = posicion;
	}
	
	public void setFinalizada()
	{
		State=Estado.Acabada;
		System.out.println("///////////////////////");
		System.out.println("En La actividad del libro : " + getNombre() + ".");
		System.out.println("Creada por el Profesor: " + Profesor + ".");
		StringBuffer SB=new StringBuffer();
		for (int i = 0; i < ListaAlumnos.size()-1; i++) {
			SB.append(ListaAlumnos.get(i).getName());
//			SB.append(" (Esforzandose para un ");
//			SB.append(ListaAlumnos.get(i).getEsfuerzo());
//			SB.append("), ");
			SB.append(", ");
		}
		if (!ListaAlumnos.isEmpty())
			{
			SB.append(ListaAlumnos.get(ListaAlumnos.size()-1).getName());
//			SB.append(" (Esforzandose para un ");
//			SB.append(ListaAlumnos.get(ListaAlumnos.size()-1).getEsfuerzo());
//			SB.append(").");
			SB.append(".");
			}
		System.out.println("Los Alumnos: " + SB.toString());
		System.out.println("Obtuvieron la nota de " + Nota);
		//System.out.println(" El Alumno " + Id + " ha obtenido la puntuacion de " + A.getNota() + " en la Actividad del Libro \"" + A.getNombre() + "\" esforzandose para un " + Esfuerzo +".");
	//	System.out.println("///////////////////////");
	}
	
	public void setCiclosLimite(int ciclosLimite) {
		this.ciclosLimite = ciclosLimite;
	}
	
	public void Trabajar(int cant)
	{
		Completitud=Completitud+cant;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public ArrayList<Alumnos> getListaAlumnos() {
		return ListaAlumnos;
	}
}
