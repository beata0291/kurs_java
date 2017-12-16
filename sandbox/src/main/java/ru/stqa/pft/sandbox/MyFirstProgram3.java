package ru.stqa.pft.sandbox;

public class MyFirstProgram3 {

	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Becia");

		Square s = new Square(5);
		System.out.println("Powierchnia kwadratu o boku " + s.l + "równa się " + area(s));

		Rectangle r = new Rectangle(4,3);
		System.out.println("Powierchnia prostokąta o bokach " + r.a + " i " + r.b + " równa się " + area(r));

	}
		public static void hello (String somebody){
			System.out.println("Hello " + somebody + "!");
		}

		public static double area (Square s){
			return s.l * s.l;
		}

	public static double area(Rectangle r) {
		return r.a * r.b;
	}




	}



