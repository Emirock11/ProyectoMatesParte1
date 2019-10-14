import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Falta:
 * - Hacer el JavaDoc donde se comentará todo el código.
 * 
 * */
public class Main {
	static LinkedList<String> listaType = new LinkedList<String>();
	private static String state;
	static LinkedList<String> listaConnections = new LinkedList<String>();
	static LinkedList<String> listaStates = new LinkedList<String>();
	// Hacer un arreblo bidimensional en donde contenga la letra y el state con el que se va a conectar el State
	public static void main(String [] arg) {
		
		Scanner sc = new Scanner(System.in);
		
		int contador=1,contSets=0,stateDestiny=0,stateOriginNumber=0,cont5=0;
		String stateOrigin="", characterConnection="";
		
		File file = new File("test2.txt");
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
		    			// Aquí se leerán los sets que habrá del autómata y se guardarán dentro de una lista
		    			for(int i=0;i<=lines.length()-1;i++) {
		    				if(i<lines.length()) {
		    					char ca = lines.charAt(i);
		    					if(ca=='q') {
		    						// Aquí se agrega el objeto que se creó a la lista de los estados
		    						char ca2=lines.charAt(i+1);
		    						// Hay algo mal en el guardado de los states, sólo guarda q0, mas no q1
		    						// YA QUEDÓ ARREGLADO
		    						String number=Character.toString(ca)+Character.toString(ca2);
		    						listaStates.add(number);
		    					}
		    				}
		    			}
		    			contSets=0;
		    			break;
		    		case 3:
		    			// Aquí se escogerá el inicio del autómata
		    			for(int i=0;i<=lines.length()-1;i++) {
		    				if(i<lines.length()) {
		    					char ca = lines.charAt(i);
		    					if(ca=='q') {
		    						
		    						// De la lista, tiene que buscar a qué state se le va a agregar el tipo si es inicial
		    						//En el for se va recorriendo en toda la lista donde se guardan los States hasta que se encuente el state inicial
		    						for(int j=0;j<=listaStates.size()-1;j++){
			    						
			    						char ca2=lines.charAt(i+1);
			    						String number=Character.toString(ca)+Character.toString(ca2);
			    						String temp=listaStates.get(j);
			    						// No quiere jalar este condicional!!! :(
			    						if(temp.charAt(1)==number.charAt(1)) {
			    							// Se repite "Initial porque solamente hay un string y si se modifica uno, se modifica el otro"
			    							listaType.add("Initial");
			    						}
			    						
		    						}
		    						
		    					}
		    				}
		    			}
		    			// Crear muchos objetos por medio de un for, los objetos se irán metiendo a la lista y ya después se recolectarán
		    			
		    			break;
		    		case 4:
		    			// Aquí se escogerá el final del autómata
		    			for(int i=0;i<=lines.length()-1;i++) {
		    				if(i<lines.length()) {
		    					char ca = lines.charAt(i);
		    					if(ca=='q') {
		    						// De la lista, tiene que buscar a qué state se le va a agregar el tipo si es final
		    						//En el for se va recorriendo en toda la lista donde se guardan los States hasta que se encuente el state final
		    						for(int j=0;j<=listaStates.size()-1;j++) {
			    						char ca2=lines.charAt(i+1);
			    						
			    						String number=Character.toString(ca)+Character.toString(ca2);
			    						if(listaType.get(0)=="Initial" &&  listaStates.get(0).charAt(1)==number.charAt(1)) {
			    							listaType.set(0,"Both");
			    						}else {
			    							listaType.add("Final");
			    						}
		    						}
		    						
		    					}
		    				}
		    			}
		    			break;
		    	//____________________________________________________________________________
		    	
		    	
		    	//Se irán procesando las conexiones de aqui en adelante...
		    		default:
		    			
		    			if(contador>4) {
		    				for(int i=0;i<=lines.length();i++){
			    				if(i<lines.length()) {
			    					char ca = lines.charAt(i);
			    					if(ca=='q') {
			    						if(cont5==0) {
			    							// La primera q es la que muestra el origen, después de esto se le aumenta uno al contador
			    							char ca2 = lines.charAt(i+1);
			    							stateOriginNumber=Character.getNumericValue(ca2);
			    							cont5++;
			    						}else {
			    							char ca2 = lines.charAt(i+1);
			    							stateDestiny=Character.getNumericValue(ca2);
			    							setStateConnections(stateOriginNumber,stateDestiny,characterConnection);
			    						}
			    						char ca2 = lines.charAt(i+1);
			    						String temp=Character.toString(ca)+Character.toString(ca2);
			    					}else if(ca=='l') {
			    						characterConnection="lmd";
			    					}else if(ca=='a' || ca=='b') {
			    						characterConnection=Character.toString(ca);
			    					}
			    				}
			    			}
		    				cont5=0;
		    			}
		    			
		    			break;
		    	}
		        //Se suma al contador para que pase a la siguiente línea del .txt y haga la siguiente acción del switch
		    	contador++;
		    	
		    	
		    	
		    }
		}catch (IOException e) {
		    e.printStackTrace();
		}
		
		try {
		    String lines = "";
		    
		    while( ( lines = file2.readLine()) != null) {
		    	
		    	for(int i=0;i<=lines.length()-1;i++) {
    				if(i<lines.length()) {
    					char ca = lines.charAt(i);
    					
    				}
    			}
		    	//____________________________________________________________________________
		    	
		    	
		    	//Se irán procesando las conexiones de aqui en adelante...
		    	
		    }
		}catch (IOException e) {
		    e.printStackTrace();
		}
		
		for(int i=0;i<=listaStates.size()-1;i++) {
			// Se busca el objeto dentro de la lista
			System.out.println("State: "+listaStates.get(i));
			System.out.println("Type: "+listaType.get(i));
			
		}
		
		for(int i=0;i<=listaConnections.size()-1;i++) {
			System.out.println(i+1+".- Connection: "+listaConnections.get(i));
		}
		System.out.println("__________________________________________________");
		System.out.println("Enter the String you want to process: ");
		processString(sc.nextLine());
	}
	public static void setStateConnections(int stateOrigin, int stateDestiny, String character) {
		//Se agrega las conexiones mediante un arreglo en donde se compone de la siguiente manera:
		//array[posicionDelArreglo][numeroDestino]=caracter
		String posTemp=Integer.toString(stateOrigin);
		String desTemp=Integer.toString(stateDestiny);
		String chara=character;
		String temp=posTemp+","+chara+","+desTemp;
		int c=0;
		if(temp.charAt(1)==',' && temp.charAt(2)==',') {
			System.out.println("Se repiten comas");
			
		}else{
			listaConnections.add(temp);
		}
	}
	
	public static String getStateConnections(String state, char character) throws CharacterNotFoundException{
		// state= "q0"  character= "a"
		String ret="";
		boolean found=false;
		for(int i=0;i<listaConnections.size();i++) {
			String temp=listaConnections.get(i);
			
			if(temp.charAt(0)==state.charAt(1) && character==temp.charAt(2)){
				found=true;
				ret= "q"+Character.toString(temp.charAt(4))+Character.toString(temp.charAt(2));
			}else if(temp.charAt(0)==state.charAt(1) && 'l'==temp.charAt(2)){
				found=true;
				ret= "q"+Character.toString(temp.charAt(6))+"lmd";
			}
			
		}
		if(found==false){
				throw new CharacterNotFoundException("The character "+Character.toString(character)+" is not in the automata. The string is not accepted by the automata.");
		}
		return ret;
	}
	
	public static String getStateType(int state){
		return listaType.get(state);
	}
	
	public static void processString(String string) {
		try {
			String actualPosition="q0";
			char character;
			String tempPosition;
			boolean contLmd=false,finalAnswer=false;
			for(int i=0;i<string.length();i++) {
				character=string.charAt(i);
				String tempString=getStateConnections(actualPosition,character);
				//a -> "q1a" o "q1lmd"
				if(tempString.charAt(2)=='l' && contLmd==false) {
					tempPosition=actualPosition;
					actualPosition=Character.toString(tempString.charAt(0))+Character.toString(tempString.charAt(1));
					System.out.println(tempPosition+", "+Character.toString(tempString.charAt(2))+"md => "+actualPosition);
					i--;
					contLmd=true;
				}else {
					tempPosition=actualPosition;
					actualPosition=Character.toString(tempString.charAt(0))+Character.toString(tempString.charAt(1));
					System.out.println(tempPosition+", "+Character.toString(tempString.charAt(2))+" => "+actualPosition);
					contLmd=false;
				}
			}
			for(int i=0;i<listaType.size();i++) {
				
				if((listaType.get(i)=="Final" && Character.getNumericValue(actualPosition.charAt(1))==i) || (listaType.get(i)=="Both" && Character.getNumericValue(actualPosition.charAt(1))==i)) {
					finalAnswer=true;	
				}
			}
			if(finalAnswer) {
				System.out.println("The string "+ string +" is accepted by the automata");
			}else {
				System.out.println("The string "+ string +" is not accepted by the automata");
			} 
		}catch (CharacterNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}