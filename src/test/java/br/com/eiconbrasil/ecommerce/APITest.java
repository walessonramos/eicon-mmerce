package br.com.eiconbrasil.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class APITest {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarPedidos() {
		
		RestAssured.given()
			.basePath("/pedidos")
			.port(port)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
		
	}

}
