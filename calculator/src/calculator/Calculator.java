package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*TODO: 
* Avaliar melhor maneira de tratar os erros
* Avaliar melhor opção para definir os operadores permitidos ao inves de usar uma ArrayList na classe Operator
* Separar melhor os arquivos
* Avaliar interface para a classe Operator
* Permitir entrada de multiplos números (validar melhor forma)
* Avaliar formatação do texto de saida
* Avaliar implementação do toString nas classes para remover o sysout do resultado
* Adição de novas operações (raizes, exponenciação, log)
* Avaliar criação de GUI
* Avaliar refatoração para implementação de GUI
* Implementar documentação (javadoc);
*/
public class Calculator {

	public static void main(String[] args) {
		ArrayList<Float> numbers = new ArrayList<Float>();
		Operator chosenOperation = null;
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Insira a operação (+, -, / ou *):");
		
		try {
			chosenOperation = new Operator(reader.next());
		} catch (OperationException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try {
			System.out.println("Insira o primeiro número:");
			numbers.add(reader.nextFloat());
			
			System.out.println("Insira o segundo número:");
			numbers.add(reader.nextFloat());
		} catch (InputMismatchException e) {
			System.out.println("Invalid input.");
			System.exit(1);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		
		
		reader.close();
		
		Operation operation = chosenOperation.getOperation();
		
		try {
			Float result = operation.doOperation(numbers);
			System.out.println(result);
		} catch (OperationException e) {
			System.out.println(e.getMessage());		
		}
	}

}
