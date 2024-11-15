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

	public int krapekarOp(int num) {
		numerosOriginales = new ArrayList<>();
		numerosOriginales.addAll(String.valueOf(Math.abs(num))
				.chars()
				.mapToObj(c -> c - '0')
				.collect(Collectors.toList()));
		List <Integer> numerosMenorMayor= numerosOriginales.stream()
				.sorted()
				.collect(Collectors.toList());
		List <Integer> numerosMayorMenor= numerosOriginales.stream()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		
	return num
	}

}


