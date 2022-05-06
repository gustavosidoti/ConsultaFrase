package com.Sitrack.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;



@SpringBootApplication
public class ConsultaFraseApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConsultaFraseApplication.class, args);

		// Instanciamos la clase DemoService
		DemoService demoservice = new DemoService();

		//crear el Scanner
		Scanner sc = new Scanner(System.in);
		//crear las variables de la url y la palabra a buscar en ella
		String palab;
		String url;

		//ingresar la url
		System.out.println("Ingrese la web: Por ejemplo  https://es.wikipedia.org/wiki/Pir%C3%A1mides_de_Egipto");
		//leer la url
		url =sc.nextLine();

		//ingresar la palabra a buscar
		System.out.println("Ingrese la palabra a buscar:");
		//leer la palabra a buscar
		palab=sc.nextLine();


		// Llamamos a la función consultar de la clase DemoService
		Integer result = demoservice.consultar( url, palab);

	// fin
	}


}
