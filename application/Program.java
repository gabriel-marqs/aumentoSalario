package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import funcionario.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.print("Quantos funcionários serão registrados? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Funcionário #" + (i + 1) + ":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("ID já escolhido! Tente novamente: ");
				id = sc.nextInt();
			}

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();

			Funcionario func = new Funcionario(id, nome, salario);
			list.add(func);
		}

		System.out.print("Informe o ID do funcionário que receberá aumento: ");
		int idAumento = sc.nextInt();

		Funcionario func = list.stream().filter(x -> x.getId() == idAumento).findFirst().orElse(null);

		if (func == null) {
			System.out.println("Esse ID não existe.");
		}

		else {
			System.out.print("Qual será a porcentagem do aumento? ");
			double aumento = sc.nextDouble();
			func.aumentoSalario(aumento);
		}

		System.out.println("Lista de funcionários:");
		for (Funcionario x : list) {
			System.out.println(x);
		}

		sc.close();

	}

	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}
}
