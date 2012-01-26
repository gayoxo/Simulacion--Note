import java.util.ArrayList;
import java.util.Random;

import sim.engine.SimState;
import sim.engine.Steppable;
import sim.util.Double2D;


public class Alumnos implements Steppable{

	private static int ConstantID=0;
	private int Id;
	private int Energia;
	private int Productividad;
	private int Esfuerzo;
	private Curso Cur;
	private Double2D Posicion;
	private static boolean positivo=true;
	private static double numpositivo=0.0;
	private ArrayList<Actividad> Implicado;
	private String Name;


	
	public Alumnos(Curso curso) {
		Name=CONSTANTES.GetNombreAleatorioNombre();
		Energia=((new Random()).nextInt(51))+50;
		Productividad=((new Random()).nextInt(2))+1;
		Esfuerzo=((new Random()).nextInt(6))+5;
		
		Implicado=new ArrayList<Actividad>();
		positivo=!positivo;
	Id=ConstantID++;
	Cur=curso;	
	if (positivo)
		numpositivo=numpositivo + Id;
	else
		numpositivo=numpositivo - Id;
	
		Posicion=new Double2D(Cur.getYard().width-1,Cur.getYard().height*0.5 - numpositivo);
	
	//System.out.println("Posicion: " + Posicion.getX()+ "," + Posicion.getY());
	}
	
	
	
	@Override
	public void step(SimState arg0) {
		if (!Implicado.isEmpty()){

		Actividad A=GetActividadCandidata();
		if (A!=null){
		Double2D PosicionOri = Cur.yard.getObjectLocation(this);
		if ((PosicionOri.getX()==Posicion.getX()) && (PosicionOri.getY()==Posicion.getY()))
		{
			if ((A.getEstado()!=Estado.SinAtributos)&&(A.getEstado()!=Estado.RecienAcabada)){
				if (A.getEstado()==Estado.Acabada)
				{
				Implicado.remove(A);
				}
				else {
					if ((A.getEstado()==Estado.Activa)&&(Energia>0)&&(A.getNota()<Esfuerzo))
						{
						Double2D ActPos=new Double2D(A.getPosicion().getX()+1,A.getPosicion().getY());
						Cur.yard.setObjectLocation(this, ActPos);
						A.Trabajar(Productividad);
						Energia=Energia-Productividad;
						}
//					else if (Energia<=0) 
//						System.out.println("Me quede sin Energia");
//						if (A.getNota()>Esfuerzo)
//							System.out.println("Trabaje lo suficiente");
					}
				
			}
		}
		else
		{
			Cur.yard.setObjectLocation(this, Posicion);	
		}
		}
		}
	}
	
	private Actividad GetActividadCandidata() {
		Actividad Menor=null;
		for (Actividad A : Implicado) {
			if (Menor==null)
				Menor=A;
			else
			{
				if (A.getNota()<Menor.getNota())
					Menor=A;
			}
		}
		return Menor;
	}



	public Double2D getPosicion() {
		return Posicion;
	}
	
	public static void setConstantID(int constantID) {
		ConstantID = constantID;
	}
	public static void setNumpositivo(double numpositivo) {
		Alumnos.numpositivo = numpositivo;
	}
	
	public ArrayList<Actividad> getImplicado() {
		return Implicado;
	}
	
	public void setImplicado(ArrayList<Actividad> implicado) {
		Implicado = implicado;
	}

	public int getId() {
		return Id;
	}
	
	public int getEsfuerzo() {
		return Esfuerzo;
	}
	
	public String getName() {
		return Name;
	}
}
