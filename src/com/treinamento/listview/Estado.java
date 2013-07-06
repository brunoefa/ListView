package com.treinamento.listview;

public class Estado {
	private String estado;
	private String capital;
	private int bandeira;

	public Estado(String estado, String capital, int bandeira) {
		super();
		this.estado = estado;
		this.capital = capital;
		this.bandeira = bandeira;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getBandeira() {
		return bandeira;
	}

	public void setBandeira(int bandeira) {
		this.bandeira = bandeira;
	}
}
