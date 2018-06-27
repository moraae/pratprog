package aula01;

public class Retangulo extends Quadrado implements Diagonal
{	
	public Retangulo(double base, double altura)
	{
		super(base, altura);
	}
	
	@Override
	public double perimetro()
	{
		return (getAltura() * 2) + (getBase() * 2);
	}
	
	@Override
	public double area()
	{
		return getBase() * getAltura();
	}
	
	@Override
	public double diagonal()
	{
		return Math.sqrt( ( Math.pow(getBase(),2) ) + ( Math.pow(getAltura(),2) ) );
	}
	
	public String toString()
	{
		return "\n\nRetangulo:\nArea: "+area()+"\nPerimetro: "+perimetro()+"\nDiagonal: "+diagonal();
	}
}