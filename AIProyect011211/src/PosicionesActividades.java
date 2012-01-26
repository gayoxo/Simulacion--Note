import javax.swing.text.Position;

import sim.util.Double2D;


public class PosicionesActividades {

	private static boolean[] Array=new boolean[CONSTANTES.YTablero];
	public static PosicionesActividades YO;
	
	public PosicionesActividades() {
	for (int i = 0; i < Array.length; i++) {
		Array[i]=false;
	}
	}
	
	public Double2D getNexOpen(Curso Cur){
		
		boolean positivo=false;
		int act=CONSTANTES.YTablero/2;
		for (int i = 0; i < Array.length; i++) {
			if (positivo) 
				act=act+i;
			else act=act-i;
			if ((act<CONSTANTES.YTablero)&&(!Array[act]))
			{
				Array[act]=true;
				return new Double2D(Cur.getYard().width*0.5,act);
				
			}
			positivo=!positivo;
		}
		return null;
	}
	
	public static PosicionesActividades getInstance()
	{
		if (YO==null) YO=new PosicionesActividades();
		return YO;
	}
	
	
	public static void clean(){
		for (int i = 0; i < Array.length; i++) {
			Array[i]=false;
		}
	}
	
	public static void removeActividad(int A)
	{
		Array[A]=false;
	}
}
