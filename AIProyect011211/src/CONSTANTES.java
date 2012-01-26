import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class CONSTANTES {

	public static final int Profesores=6;
	public static final int ExigenciamediaVar=5;
	public static final int Alumnos=35;
	public static final int Actividades=7;
	public static final int MedioY=25;
	public static final int YTablero=50;
	public static final int XTablero=50;
	public static ArrayList<String> Libros;
	public static ArrayList<String> Nombres;
	
	public static int getCiclos(int Alumnos)
	{
		return (Alumnos/2)*100;
	}

	public static int getAlumnosParticipantes()
	{
	Random R=new Random();
	return 4+R.nextInt(5);
	}
	
	public static ArrayList<ArrayList<Alumnos>> getAlumnosRandom(ArrayList<Alumnos> A, int cantidad)
	{
		int Grupos=A.size()/cantidad;
		ArrayList<ArrayList<Alumnos>> Salida=new ArrayList<ArrayList<Alumnos>>();
		ArrayList<Alumnos> copy=new ArrayList<Alumnos>(A);
		for (int i = 0; i < cantidad; i++) {
			ArrayList<Alumnos> NUevo=new ArrayList<Alumnos>();
			int quedan=0;
			while ((quedan<Grupos)&&(!copy.isEmpty()))
			{
			Random R=new Random();
			int Slecccionado=R.nextInt(copy.size());
			Alumnos sel=copy.get(Slecccionado);
			copy.remove(Slecccionado);
			NUevo.add(sel);
			quedan++;
			}
			Salida.add(NUevo);
		}
		return Salida;
	}
	
	public static void LoadLibros(ArrayList<String> LibrosIn)
	{
		Libros=LibrosIn;
	}
	
	public static void LoadNombres(ArrayList<String> NombressIn)
	{
		Nombres=NombressIn;
	} 
	
	public static String GetNombreAleatorioLibro()
	{
	Random R=new Random();
	int sal=R.nextInt(Libros.size());
	return Libros.get(sal);
	}
	
	public static String GetNombreAleatorioNombre()
	{
	Random R=new Random();
	int sal=R.nextInt(Nombres.size());
	return Nombres.get(sal);
	}
}
