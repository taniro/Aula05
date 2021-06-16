package tads.eaj.ufrn.aula05.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/produto")
public class CadastroProduto {

	@GetMapping
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		var writer = response.getWriter();
		writer.println("HELLO PRODUTO FROM GET");
	}
}
