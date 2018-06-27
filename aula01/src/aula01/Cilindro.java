package aula01;

public class Cilindro extends Poliedro
{
	private double raio;
	
	public Cilindro(double altura, double raio)
	{
		super(altura);
		this.raio = raio;
	}
	
	@Override
	public double volume()
	{
		return altura*Math.PI*(Math.pow(raio,2));
	}
	
	public String toString()
	{
		return "\n\nCilindro:\nVolume: "+volume();
	}
}