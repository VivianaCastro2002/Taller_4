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
	public static String formatToFourDigits(int num) {
		return String.format("%04d", num); // Asegura que el número tenga 4 dígitos
	}
	public static int kaprekarOp(int num) {
		int numero1;
		int numero2;
		List<Integer> numero1ToList=numToList(num);
		numero1ToList=listMayorMenor(numero1ToList);
		List<Integer> numero2ToList=listMenorMayor(numero1ToList);
		numero1=listToInt(numero1ToList);
		numero2=listToInt(numero2ToList);

	return numero1-numero2;
	}

	public static int itKaprekar(int num){

		return  num;
	}

	public static List<Integer> numToList(int num) {
		List<Integer> numeros = new ArrayList<>();
		numeros.addAll(String.valueOf(Math.abs(num))
				.chars()
				.mapToObj(c -> c - '0')
				.collect(Collectors.toList()));
		return numeros;
	}
	public static List<Integer> listMenorMayor(List<Integer> numeros){
		List <Integer> numerosMenorMayor= numeros.stream()
				.sorted()
				.collect(Collectors.toList());
		return numerosMenorMayor;
	}
	public static List<Integer> listMayorMenor(List<Integer> numeros){
		List <Integer> numerosMayorMenor= numeros.stream()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		return numerosMayorMenor;
	}
	public static int listToInt(List<Integer> digitList) {
		String numberString = digitList.stream()
				.map(String::valueOf)
				.collect(Collectors.joining());
		return Integer.parseInt(numberString);
	}
}



