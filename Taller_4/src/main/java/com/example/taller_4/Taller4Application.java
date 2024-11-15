package com.example.taller_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Taller4Application {
	List <Integer> numerosOriginales;
	public static void main(String[] args) {
		SpringApplication.run(Taller4Application.class, args);

	}
	// Método que realiza la operación de Kaprekar:
	// 1. Convierte el número en una lista de dígitos.
	// 2. Ordena la lista en orden descendente y ascendente.
	// 3. Convierte las listas ordenadas de nuevo en números enteros.
	// 4. Realiza la resta de los dos números obtenidos.
	public static int kaprekarOp(int num) {
		int numero1;// Variable para almacenar el número formado con los dígitos ordenados en forma descendente
		int numero2;// Variable para almacenar el número formado con los dígitos ordenados en forma ascendente
		List<Integer> numero1ToList=
				numToList(num);
		numero1ToList=listMayorMenor(numero1ToList);
		List<Integer> numero2ToList=listMenorMayor(numero1ToList);
		numero1=listToInt(numero1ToList);
		numero2=listToInt(numero2ToList);

	return numero1-numero2;
	}
	// Método que convierte un número en una lista de sus dígitos.
	public static List<Integer> numToList(int num) {
		List<Integer> numeros = new ArrayList<>();
		numeros.addAll(String.valueOf(Math.abs(num))
				.chars()
				.mapToObj(c -> c - '0')
				.collect(Collectors.toList()));
		return numeros;
	}
	// Método que ordena una lista de dígitos en orden ascendente
	public static List<Integer> listMenorMayor(List<Integer> numeros){
		List <Integer> numerosMenorMayor= numeros.stream()
				.sorted()
				.collect(Collectors.toList());
		return numerosMenorMayor;
	}
	// Método que ordena una lista de dígitos en orden descendente
	public static List<Integer> listMayorMenor(List<Integer> numeros){
		List <Integer> numerosMayorMenor= numeros.stream()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		return numerosMayorMenor;
	}
	// Método que convierte una lista de dígitos en un número entero
	public static int listToInt(List<Integer> digitList) {
		String numberString = digitList.stream()
				.map(String::valueOf)
				.collect(Collectors.joining());
		return Integer.parseInt(numberString);
	}
}



