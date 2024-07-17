package domain;
import exception.InsufficientBalance;
import exception.NegativeValueException;
import model.Cliente;

public abstract class Conta implements IConta{

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	protected int getAgencia() {
		return agencia;
	}

	protected int getNumero() {
		return numero;
	}

	protected double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public void sacar(double valor) throws NegativeValueException, InsufficientBalance {
		if(valor < 0) {
			throw new NegativeValueException();
		} else if (saldo < valor) {
			throw new InsufficientBalance();
		} else {
			saldo -= valor;
		}
	}

	@Override
	public void depositar(double valor) throws NegativeValueException{
		if(valor < 0) {
			throw new NegativeValueException();
		} else {
			saldo += valor;
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) throws NegativeValueException,
			InsufficientBalance {
		if(valor < 0) {
			throw new NegativeValueException();
		} else {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
	}
}
