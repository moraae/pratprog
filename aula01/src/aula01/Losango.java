package aula01;

public class Losango extends Quadrado
{
	public Losango(double base, double altura)
	{
		super(base, altura);
	}
	
	@Override
	public double perimetro()
	{
		return getBase() * 4;
	}
	
	@Override
	public double area()
	{
		return getBase() * getAltura();
	}
	
	public String toString()
	{
		return "\n\nLosango:\nArea: "+area()+"\nPerimetro:"+perimetro();
	}
}