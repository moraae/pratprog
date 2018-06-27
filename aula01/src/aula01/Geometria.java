package aula01;

import java.util.ArrayList;

public class Geometria
{
	public static void main(String[] args)
	{
		ArrayList<Figuras2D> figuras2D = new ArrayList<Figuras2D>();
		ArrayList<Figuras3D> figuras3D = new ArrayList<Figuras3D>();
	
		figuras2D.add(new Triangulo(10, 15));
		figuras2D.add(new Circulo(5));
		figuras2D.add(new Losango(10,12));
		figuras2D.add(new Retangulo(10,15));
		figuras2D.add(new Quadrado(15,15));
		figuras2D.add(new Trapezio(5,10,8));
		
		figuras3D.add(new Cubo(10,10));
		figuras3D.add(new Cilindro(10,4));
		figuras3D.add(new Esfera(10,5));
		figuras3D.add(new Piramide(10,5));
		
		for(int i = 0; i < figuras2D.size(); i++)
		{
			System.out.println(figuras2D.get(i).toString());
		}
		
		for(int i = 0; i < figuras3D.size(); i++)
		{
			System.out.println(figuras3D.get(i).toString());
		}
	}
}