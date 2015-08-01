package br.com.caelum.calculadora.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class CalculadoraWS implements Calculadora {

	@WebMethod(operationName = "somar")
	public int soma(@WebParam(name = "valor1") int valor1, @WebParam(name = "valor2") int valor2) {
		return valor1 + valor2;
	}

	@WebMethod
	public int multiplicar(int valor1, int valor2) {
		return valor1 * valor2;
	}

}
