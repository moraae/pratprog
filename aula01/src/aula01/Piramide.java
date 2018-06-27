package aula01;

public class Piramide extends Poliedro
{
	private double base;
	
	public Piramide(double altura, double base)
	{
		super(altura);
		this.base = base;
	}
	
	@Override
	public double volume()
	{
		return (Math.pow(base,2)*altura)/3;
	}
	
	public String toString()
	{
		return "\n\nPiramide:\nVolume: "+volume();
	}
}