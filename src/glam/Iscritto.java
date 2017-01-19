package glam;

import org.eclipse.swt.widgets.DateTime;

public class Iscritto {
	private String nome;
	private DateTime giorno;
	
	public Iscritto(String n,DateTime d) {
		// TODO Auto-generated constructor stub
		nome = n;
		giorno = d;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DateTime getGiorno() {
		return giorno;
	}

	public void setGiorno(DateTime giorno) {
		this.giorno = giorno;
	}
	
}
