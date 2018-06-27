package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class FazerLogin implements Command 
{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");
		
		Usuario usuario = new Usuario();
		usuario.setUsername(nome);
		usuario.setPassword(senha);

		UsuarioService service = new UsuarioService();

		System.out.println(usuario.getPassword());
		try 
		{
			if(service.validar(usuario))
			{
				HttpSession session = request.getSession();
				session.setAttribute("logado", usuario);
				System.out.println("Logou "+usuario);
			}else
			{
				System.out.println("N�o Logou "+usuario);
				throw new ServletException("Usu�rio/Senha inv�lidos");
			}
		}catch(ServletException e) 
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}
}