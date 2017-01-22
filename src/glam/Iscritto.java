package glam;

import java.util.Date;

public class Iscritto {
	private String nome;
	private Date giorno;
	
	public Iscritto(String n,java.util.Date giorno2) {
		// TODO Auto-generated constructor stub
		nome = n;
		giorno = (Date) giorno2;
		System.out.println(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getGiorno() {
		return giorno;
	}

	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}
	
}
