package domain;
import exception.InsufficientBalance;
import exception.NegativeValueException;

public interface IConta {

	void sacar(double valor) throws NegativeValueException, InsufficientBalance;

	void depositar(double valor) throws NegativeValueException;

	void transferir(double valor, IConta contaDestino) throws NegativeValueException,
			InsufficientBalance;

	void imprimirExtrato();
}
