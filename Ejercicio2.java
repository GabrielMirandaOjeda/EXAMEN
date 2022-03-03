package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2 {
	
	/**
	 * Pre: Recibe una linea de texto y un valor entero que indica la longitud de palabra que se va a usar en la comparacion
	 * Post: Devuelve un entero que indica la cantidad de palabras de la linea que tienen longitud superior a la introducida por el usuario
	 */
	
	private static int cortar(String line, int longitud) {
		String [] palabras = line.split(" ");
		int cuenta=0;
		for(int i = 0; i < palabras.length; i++) {
			if (palabras[i].length()>longitud) {
				cuenta++;
			}
		}
		return cuenta;
	}
	
	/**
	 * Pre: Recibe un string que contiene la ruta + nombre del fichero de texto a evaluar
	 * Post: Devuelve un entero que indica la cantidad de palabras del texto que tienen longitud superior a la introducida por el usuario
	 */
	
	private static int palabrasMasLargasQue(String texto, int length) {
		
		File file = new File(texto);
		int total=0;

		try {
			Scanner f = new Scanner(file);
			while(f.hasNextLine()) {
			String linea = f.nextLine();
			total = total+cortar(linea, length);
			}
			f.close();
			}
		catch(FileNotFoundException e) {
			System.out.println("El fichero " + texto + " no ha podido ser abierto.");
		}
		return total;
	}
	/**
	 * Pre:
	 * Post: El le pide al usuario la ruta y el nombre de un fichero de texto y una entero que indica la longitud de palabra, y devuelve el
	 * numero de palabras en el texto de longitud superior a la indicada por el usuario
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escriba la ruta del fichero con el archivo de texto a evaluar");
		String fichero = scan.nextLine();
		System.out.println("Escriba la longitud de palabra que se va a usar para realizar la comparacion con las palabras del texto");
		int longitud = scan.nextInt();
		System.out.println("El numero de palabras de longitud superior a la introducida es: " +palabrasMasLargasQue(fichero, longitud));

	}
}
