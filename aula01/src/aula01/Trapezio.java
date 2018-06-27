package aula01;

public class Trapezio extends Quadrado
{
	private double baseMaior;
	
	public Trapezio(double base, double altura, double baseMaior)
	{
		super(base, altura);
		this.baseMaior = baseMaior;
	}
	
	@Override
	public double perimetro()
	{
		double hipotenusa = Math.sqrt( ( Math.pow(getAltura(),2) ) + ( Math.pow(getBase(),2) ) );
		return (hipotenusa * 2) + getBase() + baseMaior;
	}
	
	@Override
	public double area()
	{
		return ( (getBase() + baseMaior) * getAltura() )/2;
	}
	
	public String toString()
	{
		return "\n\nTrapezio:\nArea: "+area()+"\nPerimetro:"+perimetro();
	}
}