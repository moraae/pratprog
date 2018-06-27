package aula01;

public class Cubo extends Poliedro
{
	private double base; 
	
	public Cubo(double altura, double base)
	{
		super(altura);
		this.base = base;
	}
	
	@Override
	public double volume()
	{
		return Math.pow(base,3);
	}
	
	public String toString()
	{
		return "\n\nCubo:\nVolume: "+volume();
	}
}