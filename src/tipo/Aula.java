package tipo;

public class Aula {

	private String numero;
	private String data;
	private String presenca;
	private int peso;
	private int notaParcial;
	private int notaPonderada;
	private String descricao;

	public Aula(String numero, String data, String presenca) {
		this.numero = numero;
		this.data = data;
		this.presenca = presenca;
	}

	public Aula(String numero, String data, String presenca, int peso, int notaParcial, String descricao) {
		this.numero = numero;
		this.data = data;
		this.presenca = presenca;
		this.peso = peso;
		this.notaParcial = notaParcial;
		this.notaPonderada = this.getPeso() * this.getNotaParcial();
		this.descricao = descricao;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}

	public int getNotaParcial() {
		return notaParcial;
	}

	public void setNotaParcial(int notaParcial) {
		this.notaParcial = notaParcial;
	}

	public String getNumero() {
		return numero;
	}

	public String getData() {
		return data;
	}

	public int getPeso() {
		return peso;
	}

	public int getNotaPonderada() {
		return notaPonderada;
	}

	public void setNotaPonderada() {
		this.notaPonderada = this.getPeso() * this.getNotaParcial();
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Aula)) {
			return false;
		}

		Aula aula = (Aula) obj;
		return this.getNumero() == aula.getNumero();

	}

	@Override
	public String toString() {
		return numero + "\t" + data + "\t" + presenca + "\t" + peso + "\t" + notaParcial + "\t" + notaPonderada + "\t"
				+ descricao;
	}

}
