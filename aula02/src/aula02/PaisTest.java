package aula02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaisTest
{
   Pais pais, copia;
   static int id = 7;
   
   @Before
	public void setUp() throws Exception 
	{
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Chile");
		pais.setPopulacao(123456);
		pais.setArea(12.2);
		copia = new Pais();
		copia.setId(id);
		copia.setNome("Chile");
		copia.setPopulacao(123456);
		copia.setArea(12.2);
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() 
	{
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Russia");
		fixture.setPopulacao(140300000);
		fixture.setArea(17.07);
		Pais novo = pais.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar()
	{
		System.out.println("criar");
		id = pais.inserir(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() 
	{
		System.out.println("atualizar");
		pais.setPopulacao(999999);
		copia.setPopulacao(999999);		
		pais.atualizar(pais);
		pais = pais.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() 
	{
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(-1);
		copia.setArea(-1);
		pais.excluir(id);
		pais = pais.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}
}