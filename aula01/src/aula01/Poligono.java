package aula01;

public abstract class Poligono extends Figuras2D
{
	private double base, altura;
	
	public Poligono(double base, double altura)
	{
		this.base = base;
		this.altura = altura;
	}
	
	public double getBase()
	{
		return base;
	}
	public double getAltura()
	{
		return altura;
	}
}