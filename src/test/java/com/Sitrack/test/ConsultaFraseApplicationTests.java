package com.Sitrack.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoService.class)
class ConsultaFraseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test1() {
		String Url = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
		String textoabuscar = "Egipto";
		DemoService demoservice = new DemoService();
		Integer count = demoservice.consultar(Url, textoabuscar);
		Assertions.assertEquals(76, count);
	}

	@Test
	public void test2() {
		String Url = "";
		String textoabuscar = "Egipto";
		DemoService demoservice = new DemoService();
		Integer count = demoservice.consultar(Url, textoabuscar);
		Assertions.assertEquals(0, count);
	}

	@Test
	public void test3() {
		String Url = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
		String textoabuscar = "";
		DemoService demoservice = new DemoService();
		Integer count = demoservice.consultar(Url, textoabuscar);
		Assertions.assertEquals(0, count);
	}

}


