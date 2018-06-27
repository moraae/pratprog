package aula01;

public class Triangulo extends Poligono
{	
	public Triangulo(double base, double altura)
	{
		super(base, altura);
	}
	
	public String condicao()
	{
		double lado = Math.sqrt(Math.pow((getBase()/2),2)+Math.pow(getAltura(),2));
		if(getBase() == lado)
		{
			return "equilatero";
		}
		return "triangulo retangulo";
	}
	
	@Override
	public double perimetro()
	{
		String x = condicao();
		if(x.equals("equilatero"))
		{
			return getBase() * 3;
		}else
		{
			double hipotenusa = Math.sqrt(Math.pow(getBase(),2)+Math.pow(getAltura(),2));
			return hipotenusa + getBase() + getAltura();
		}
	}
	
	@Override 
	public double area()
	{
		return (getBase() * getAltura())/2;
	}
	
	public String toString()
	{
		return "\n\nTriangulo:\nArea: "+area()+"\nPerimetro:"+perimetro();
	}
}