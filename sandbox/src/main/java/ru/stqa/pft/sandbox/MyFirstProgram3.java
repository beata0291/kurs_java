package ru.stqa.pft.sandbox;

public class MyFirstProgram3 {

	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Becia");

		double len = 5;
		System.out.println("Powierchnia kwadratu o boku " + len + "równa się " + area(len));

		double a = 4;
		double b = 3;
		System.out.println("Powierchnia prostokąta o bokach " + a + " i " + b + " równa się " + area(a, b));

	}
		public static void hello (String somebody){
			System.out.println("Hello " + somebody + "!");
		}

		public static double area ( double l){
			return l * l;
		}

	public static double area(double a, double b) {
		return a*b;
	}




	}



