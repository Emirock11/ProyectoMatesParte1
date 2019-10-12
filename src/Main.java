import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Falta:
 * - Agregar las letras, tipo y conecci�n dentro de la clase state
 * - Realizar las conecciones entre los estados.
 * - Establecer bien las letras que van a contener cada estado.
 * - Organizar todo el c�digo y que no haya m�s ni menos lineas de c�digo.
 * - Hacer el proceso de b�squeda para ver si el string es aceptable o no dentro del aut�mata. (crear una clase distinta para que est� mucho m�s organizado todo)
 * - Hacer el JavaDoc donde se comentar� todo el c�digo.
 * 
 * */
public class Main {	
	public static void main(String [] arg) {
		List<State> listaStates = new ArrayList<State>();
		List<String> listaLetras = new ArrayList<String>();
		int contador=1,contSets=0;
		File file = new File("test1.txt");
		FileReader fileR = null;
		BufferedReader file2 = null;

		try {
		    fileR = new FileReader(file);
		    file2 = new BufferedReader(fileR);


		} catch (FileNotFoundException e) {
		    System.out.println("No se encontro el archivo "+file.getName());
		}

		try {
		    String lines = "";
		    while( ( lines = file2.readLine()) != null) {
		    	switch (contador){
		    		case 1:
		    			// Aqu� se leer�n los sets que habr� del aut�mata y se guardar�n dentro de una lista
		    			for(int i=0;i<=lines.length()-1;i++) {
		    				if(i<lines.length()) {
		    					char ca = lines.charAt(i);
		    					if(ca=='q') {
		    						// Aqu� se agrega el objeto que se cre� a la lista de los estados
		    						String temp="q"+contSets;
		    						listaStates.add(new State(temp));
		    						contSets++;
		    					}
		    				}
		    			}
		    			contSets=0;
		    			break;
		    		case 2:
		    			// Aqu� se leer�n las letras que van a unir a los aut�matas
		    			for(int i=0;i<=lines.length()-1;i++) {
		    				if(i<lines.length()) {
		    					char ca = lines.charAt(i);
		    					if(ca!=',') {
		    						String str=Character.toString(ca);
		    						// Agregar letra a la lista de letras
		    						listaLetras.add(str);
		    					}
		    				}
		    			}
		    			contSets=0;
		    			break;
		    		case 3:
		    			// Aqu� se escoger� el inicio del aut�mata
		    			for(int i=0;i<=lines.length()-1;i++) {
		    				if(i<lines.length()) {
		    					char ca = lines.charAt(i);
		    					if(ca=='q') {
		    						
		    						// De la lista, tiene que buscar a qu� state se le va a agregar el tipo si es inicial
		    						//En el for se va recorriendo en toda la lista donde se guardan los States hasta que se encuente el state inicial
		    						for(int j=0;j<=listaStates.size();j++) {
			    						State st=listaStates.get(i);
			    						// Si el state es igual a el contador de sets, se va a ir guardando el tipo que se le va asignando
			    						if(st.getState()=="q"+contSets) {
			    							System.out.println("Hola");
			    							contSets++;
			    						}
			    						
		    						}
		    						
		    					}
		    				}
		    			}
		    			// Crear muchos objetos por medio de un for, los objetos se ir�n metiendo a la lista y ya despu�s se recolectar�n
		    			contSets=0;
		    			break;
		    		case 4:
		    			// Aqu� se escoger� el final del aut�mata
		    			for(int i=0;i<=lines.length()-1;i++) {
		    				if(i<lines.length()) {
		    					char ca = lines.charAt(i);
		    					if(ca=='q') {
		    						// De la lista, tiene que buscar a qu� state se le va a agregar el tipo si es final
		    						//En el for se va recorriendo en toda la lista donde se guardan los States hasta que se encuente el state final
		    						for(int j=0;j<=listaStates.size();j++) {
			    						State st=listaStates.get(i);
			    						
		    						}
		    						
		    					}
		    				}
		    			}
		    			break;
		    	}
		    	
		        //Se suma al contador para que pase a la siguiente l�nea del .txt y haga la siguiente acci�n del switch
		    	contador++;
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		for(int i=0;i<=listaStates.size()-1;i++) {
			// Se busca el objeto dentro de la lista
			State st=listaStates.get(i);
			System.out.println(st.getState());
			System.out.println(st.getType());
		}
	}
}
/*Arreglar los tipos de los estados*/

