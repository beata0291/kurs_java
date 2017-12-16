package ru.stqa.pft.sandbox;

public class MyFirstProgram3 {

	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Becia");

		Square s = new Square(5);
		System.out.println("Powierchnia kwadratu o boku " + s.l + "równa się " + s.area());

		Rectangle r = new Rectangle(4,3);
		System.out.println("Powierchnia prostokąta o bokach " + r.a + " i " + r.b + " równa się " + r.area());

	}
		public static void hello (String somebody){
			System.out.println("Hello " + somebody + "!");
		}


	}



