package br.com.caelum.calculadora.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CalculadoraWS implements Calculadora {

	@WebMethod
	public int soma(int valor1, int valor2) {
		return valor1 + valor2;
	}

	@WebMethod
	public int multiplicar(int valor1, int valor2) {
		return valor1 * valor2;
	}

}
