import java.util.ArrayList;
import java.util.List;

public class Symbols{
	
	List<String> listaSymbols = new ArrayList<String>();
	private String symbols;
	public Symbols() {
		
	}
	
	public void setSymbols(String symbol) {
		listaSymbols.add(symbol);
	}
	
	public String getSymbols() {
		for(int i=0;i<=listaSymbols.size();i++) {
			symbols=symbols+","+listaSymbols.get(i);
		}
		return symbols;
	}
	
}
