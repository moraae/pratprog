package aula01;

public class Circulo extends Figuras2D
{
	private double raio;
	
	public Circulo(double raio)
	{
		this.raio = raio;
	}
	
	@Override
	public double perimetro()
	{
		return (2*raio)*Math.PI;
	}
	
	@Override
	public double area()
	{
		return Math.PI * (Math.pow(raio,2));
	}
	
	public String toString()
	{
		return "\n\nCirculo:\nArea: "+area()+"\nPerimetro:"+perimetro();
	}
}