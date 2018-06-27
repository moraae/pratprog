package aula01;

public class Quadrado extends Poligono implements Diagonal
{	
	public Quadrado(double base, double altura)
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
	
	@Override
	public double diagonal()
	{
		return getBase() * (Math.sqrt(2));
	}
	
	public String toString()
	{
		return "\n\nQuadrado:\nArea: "+area()+"\nPerimetro: "+perimetro()+"\nDiagonal: "+diagonal();
	}
}