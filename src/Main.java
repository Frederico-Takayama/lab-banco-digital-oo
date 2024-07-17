import domain.Conta;
import domain.ContaCorrente;
import domain.ContaPoupanca;
import exception.InsufficientBalance;
import exception.NegativeValueException;
import model.Cliente;

public class Main {

	public static void main(String[] args) {
		Cliente client = new Cliente("Frederico", "12345678900",
			"frederico@gmail.com");
		Conta cc = new ContaCorrente(client);
		Conta poupanca = new ContaPoupanca(client);

		try {
			cc.depositar(300);
		} catch (NegativeValueException e) {
			System.out.println("Invalid deposit: please provide a value greater than zero");
			return;
		}

		try {
			cc.transferir(200, poupanca);
		} catch (NegativeValueException e) {
			System.out.println("Invalid transfer: please provide a value greater than zero");
			return;
		} catch (InsufficientBalance e) {
			System.out.println("Operation not succeeded: insufficient balance");
			return;
		}

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
