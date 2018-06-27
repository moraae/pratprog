/* código para criação do banco de dados
 * create database aula02;
 * use aula02;
 * create table pais
 *  (
 *		id int auto_increment not null,
 *      nome varchar(100),
 *		populacao bigint,
 *		area decimal(15,2),
 *	    primary key(id)
 *	);*/

package aula02;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Pais
{
	//atributos
	private int id;
	private String nome;
	private long populacao;
	private double area;
	ArrayList<Object> paises;
	//setup driver
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}
	//conexao com banco
	public Connection conexao() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost/aula02?user=alunos&password=alunos");
	}
	//construtores
	public Pais(String nome, long populacao, double area)
	{
		setNome(nome);
		setPopulacao(populacao);
		setArea(area);
	}
	public Pais(int id)
	{
		this.id = id;
	}
	public Pais()
	{
		paises = new ArrayList<>();
	}
	//set's
	public void setId(int id)
	{
		this.id = id;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public void setPopulacao(long populacao)
	{
		this.populacao = populacao;
	}
	public void setArea(double area)
	{
		this.area = area;
	}
	//get's
	public int getId()
	{
		return id;
	}
	public String getNome()
	{
		return nome;
	}
	public long getPopulacao()
	{
		return populacao;
	}
	public double getArea()
	{
		return area;
	}
	//toString
	public String toString()
	{
		return "ID: "+getId()+"\nPaís: "+getNome()+"\nPopulação: "+getPopulacao()+"\nÁrea: "+getArea()+" km²";
	}
	//crud
	//insert
	public int inserir(Pais pais)
	{
		String sqlInsert = "insert into pais(nome, populacao, area) values(?,?,?)";
		String sqlQuery = "select last_insert_id()";
		try(Connection conn = conexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);)
		{
			stm.setString(1,pais.getNome());
			stm.setLong(2,pais.getPopulacao());
			stm.setDouble(3,pais.getArea());
			stm.execute();
         try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
            ResultSet rs = stm2.executeQuery();)
         {
            if(rs.next())
            {
               pais.setId(rs.getInt(1));
            }
         }catch(Exception e)
         {
            e.printStackTrace();
         }
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
      return pais.getId();
	}
	//delete
	public void excluir(int id)
	{
		String sqlDelete = "delete from pais where id = ?";
		try(Connection conn = conexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);)
		{
			stm.setInt(1,id);
			stm.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//update
	public void atualizar(Pais pais)
	{
		String sqlUpdate = "update pais set nome = ?, populacao = ?, area = ? where id = ?";
		try(Connection conn = conexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1,pais.getNome());
			stm.setLong(2,pais.getPopulacao());
			stm.setDouble(3,pais.getArea());
			stm.setInt(4,pais.getId());
			stm.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//select's
	public Pais carregar(int id)
	{
      Pais pais = new Pais(id);
		String sqlSelect = "select nome, populacao, area from pais where id = ?";
		try(Connection conn = conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
         stm.setInt(1,pais.getId());
			try(ResultSet rs = stm.executeQuery();)
			{
				if(rs.next())
				{
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				}else
				{
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
      return pais;
	}
	public ArrayList<Pais> listarPaises()
	{
		Pais pais;
		ArrayList<Pais> paises = new ArrayList<>();
		String sqlSelect = "SELECT * FROM pais";
		try (Connection conn = conexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) 
		{
			stm.execute();
			try (ResultSet rs = stm.executeQuery();) 
			{
				while (rs.next()) 
				{
					pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					paises.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return paises;
	}
	//retorna pais com maior populacao
	public String maiorPopulacao()
	{
	   String sqlSelect = "select * from pais where populacao = (select max(populacao) from pais)";
	   try(Connection conn = conexao();
	 		  PreparedStatement stm = conn.prepareStatement(sqlSelect);)
	   {
	      stm.execute();
	      try(ResultSet rs = stm.executeQuery();)
	      {
	         while(rs.next())
	         {
	            this.setId(rs.getInt("id"));
	            this.setNome(rs.getString("nome"));
	            this.setPopulacao(rs.getLong("populacao"));
	            this.setArea(rs.getDouble("area"));
	         }
	      }catch(SQLException e)
	      {
	         e.printStackTrace();
	      }
	   }catch(SQLException e1)
	   {
	      System.out.println(e1.getStackTrace());
	   }
	   return toString();
	}
	//retorna pais com menor area
	public String menorArea()
	  {
	      String sqlSelect = "select * from pais where area = (select min(area) from pais)";
	      try(Connection conn = conexao();
	    		  PreparedStatement stm = conn.prepareStatement(sqlSelect);)
	      {
	         stm.execute();
	         try(ResultSet rs = stm.executeQuery();)
	         {
	            if(rs.next())
	            {
	               this.setId(rs.getInt("id"));
	               this.setNome(rs.getString("nome"));
	               this.setPopulacao(rs.getLong("populacao"));
	               this.setArea(rs.getDouble("area"));
	            }
	         }catch(SQLException e)
	         {
	            e.printStackTrace();
	         }
	      }catch(SQLException e1)
	      {
	         System.out.println(e1.getStackTrace());
	      }
	      return toString();
	  }
	//retorna vetor tres países
	public String[] vetorTresPaises()
	{
	      String[] vetor = new String[3];
	      String sqlSelect = "select * from pais";
	            try(Connection conn = conexao();
	            		PreparedStatement stm = conn.prepareStatement(sqlSelect);)
	            {
	               stm.execute();
	               try(ResultSet rs = stm.executeQuery();)
	               {
	            	  for(int i = 0; i < vetor.length; i++)
	            	  {
	            		  if(rs.next())
	            		  {  
	            			  this.setId(rs.getInt("id"));
	            			  this.setNome(rs.getString("nome"));
	            			  this.setPopulacao(rs.getLong("populacao"));
	            			  this.setArea(rs.getDouble("area"));
	            			  vetor[i] = toString();
	            		  }
	            	  }
	               }catch(SQLException e)
	               {
	                  e.printStackTrace();
	               }
	             }catch(SQLException e1)
	             {
	               System.out.println(e1.getStackTrace());
	             }              
	      return vetor;
	}
}