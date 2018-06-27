package aula01;

public class Esfera extends Poliedro
{
	private double raio;
	
	public Esfera(double altura, double raio)
	{
		super(altura);
		this.raio = raio;
	}
	
	@Override
	public double volume()
	{
		return (4/3)*Math.PI*(Math.pow(raio,3));
	}
	
	public String toString()
	{
		return "\n\nEsfera:\nVolume: "+volume();
	}
}