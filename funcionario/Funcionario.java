package funcionario;

public class Funcionario {
	private int id;
	private String nome;
	private double salario;

	public Funcionario(int id, String nome, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void aumentoSalario(double aumento) {
		salario += salario / 100 * aumento;
	}

	public String toString() {
		return id + ", " + nome + ", R$ " + String.format("%.2f", salario);
	}

}
