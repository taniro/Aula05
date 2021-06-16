package tads.eaj.ufrn.aula05.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/cliente")
public class CadastroCliente {

	@GetMapping
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		var writer = response.getWriter();
		var nome = request.getParameter("nome_val");
		var senha = request.getParameter("senha_val");
		var preferencias = request.getParameterValues("prefs");
		var param_name = request.getParameterNames();

		String nome_param;
		do {
			nome_param = param_name.nextElement();
			System.out.println(nome_param);
		}while(param_name.hasMoreElements());

		var header_names = request.getHeaderNames();
		String nome_header;
		do {
			nome_header = header_names.nextElement();
			System.out.println(nome_header);
		}while(param_name.hasMoreElements());

		for (var pref:preferencias){
			System.out.println(pref);
		}

		writer.println("HELLO CLIENTE FROM GET " + nome + senha);
		writer.println("HOST "+ request.getHeader("host"));
	}

	@PostMapping
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		var writer = response.getWriter();
		var nome = request.getParameter("nome_val");
		var senha = request.getParameter("senha_val");
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> A sua resposta </title>");
		writer.println("</head>");
		writer.println("<body>");
		if (senha.length() < 5) {
			writer.println("Sua senha é muito curta");
		}else{
			writer.println("Cadastro realizado com sucesso");
		}
		writer.println("</body>");
		writer.println("</html>");
	}
}
