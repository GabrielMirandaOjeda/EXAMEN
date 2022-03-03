package examen;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio3 {

    static Scanner sc = new Scanner(System.in);
 
    static ArrayList<String> Plataformas = new ArrayList();
    
	/**
	 * Pre: Recibe un string que contiene la ruta y el nombre de un fichero csv que contiene datos de ventas de videojuegos separados por comas
	 * Post: Crea un arraylist de strings que contiene las diferentes consolas que hay en el fichero, y lo muestra por pantalla
	 */
	private static void informacionVideojuegos(String fixero) {
		
		File file = new File(fixero);
		String[] platform;
		int cuenta=0;//Esta variable se utiliza para no introducir la cabecera del fichero de ventas en el arraylist
		boolean igual = false;
		
		try {Scanner f = new Scanner(file);
			 while(f.hasNextLine()) {
				String linea = f.nextLine();
				if (cuenta!=0) {
					 platform = linea.split(",");
					for(String s : Plataformas) {
							if(platform[2].equalsIgnoreCase(s)) {
								igual = true;
								break;
							}
					}
					if(igual==false) {
						Plataformas.add(platform[2]);
					}
				}
				igual=false;
				cuenta++;
			 }
			 System.out.println(cuenta);
			 for(String x : Plataformas) {
				 System.out.println(x);
			 }

			f.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + fixero + " no ha podido ser abierto.");
		}
	}
	/**
	 * Pre: 
	 * Post: Le pide al usuario la ruta de un fichero csv que contiene datos de ventas de videojuegos separados por comas , 
	 * crea un arraylist de strings que contiene las diferentes consolas que hay en el fichero, y lo muestra por pantalla
	 */
	public static void main(String[] args) {
    	System.out.println("Escriba la ruta del fichero que contiene la lista a evaluar");
		String fichero = sc.nextLine();
		informacionVideojuegos(fichero);
    } 
    
}