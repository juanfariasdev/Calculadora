package main;

import java.io.IOException;
import java.util.*;
import java.util.List;
import model.Calc;

public class Main {

	public static void clearScreen() {
		try {
			String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			System.out.println("-------------------------------");
		}
	};

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner valueInput = new Scanner(System.in);
		Calc calc = new Calc();

		while (true) {

			System.out.println("1 - Soma");
			System.out.println("2 - Subtração");
			System.out.println("3 - Divisão");

			System.out.println("4 - Multiplicação");
			System.out.println("5 - Sair");

			System.out.println("Digite uma opção:");

			while (!valueInput.hasNextInt()) {
				System.out.println("Entrada Invalida");
				valueInput.next(); // this is important!
			}

			Integer selectOption = valueInput.nextInt();

			System.out.println("Você selecionou: " + selectOption);

			if (selectOption == 5) {
				clearScreen();
				List<String> operations = calc.getLastOperations();
				System.out.println("Operações realizadas");
				for (String operation : operations) {
					System.out.println(operation);
				}
				valueInput.close();
				return;
			}

			System.out.println("Digite o primeiro valor a ser calculado: ");

			while (!valueInput.hasNextDouble()) {
				System.out.println("Entrada Invalida");
				valueInput.next();
			}
			double input1 = valueInput.nextDouble();
			// float f_entrada1 = Float.valueOf(entrada1);

			System.out.println("Digite o segundo valor a ser calculado: ");

			while (!valueInput.hasNextDouble()) {
				System.out.println("Entrada Invalida");
				valueInput.next();
			}
			double input2 = valueInput.nextDouble();
			// float f_entrada2 = Float.valueOf(entrada2);

			switch (selectOption) {
				case 1:
					System.out.println("Soma: " + input1 + " + " + input2 + ": " + calc.sum(input1, input2));
					break;
				case 2:
					System.out.println("Subtração: " + input1 + " - " + input2 + ": " + calc.sub(input1, input2));
					break;
				case 3:
					System.out.println("Divisão: " + input1 + " / " + input2 + ": " + calc.div(input1, input2));
					break;
				case 4:
					System.out.println("Multiplicação: " + input1 + " * " + input2 + ": " + calc.mult(input1, input2));
					break;
				default:
					System.out.println("Opção Invalida");
			}
			Thread.sleep(4000);

			clearScreen();
		}

	}

}
