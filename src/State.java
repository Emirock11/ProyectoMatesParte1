import java.util.ArrayList;
import java.util.List;

public class State extends Symbols{
	// Type es si es final o inicial
	private String type;
	private String state;
	// listaConnection es una lista de la conección con los otros estados.
	List<String> listaConnection = new ArrayList<String>();
	public State() {
		
	}
	
	public State(String state) {
		this.state=state;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	/*public String getConnection(String state){
		for(int i =0;i<=listaConnection.size();i++) {
			
		}
	}*/
	// Para agregar una conexión se necesita un state y una letra por la que se va a conectar entre si
	public void setConnection(String character,String state, int contSets) {
		// De la lista, tiene que buscar a qué state se le va a agregar el tipo si es final o inicial
		
	}
	
}
