package com.basedeconhecimento.principal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.basedeconhecimento.principal.entities.Cliente;
import com.basedeconhecimento.principal.services.ClienteService;
import java.util.List;


@Controller
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	

	
	
	
	@RequestMapping(path="editar")
	public ModelAndView salvarCliente(@RequestParam (required= false) Long id) {
		
		ModelAndView mv = new ModelAndView("cliente/form.html");
		
		Cliente cliente;
		
		if(id==null) {
			cliente =new Cliente();
		}else {
			  try {
				  cliente = clienteService.buscarCliente(id);
				  
			  }catch(Exception e ) {
				  cliente =new Cliente();
				  mv.addObject("mensagem", e.getMessage());
			  }
		}
		mv.addObject("cliente",cliente);
		return mv.addObject("listarcliente", clienteService.listarCliente());
		
		
		
	}

	@RequestMapping(method= RequestMethod.POST, path="editar")
	public ModelAndView salvarCliente(Cliente cliente, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("cliente/form.html");
		
       boolean novo = true;
		
		
		if (bindingResult.hasErrors()) {
			mv.addObject("cliente",cliente);
			return mv;
		}
		
		clienteService.salvarCliente(cliente);
		
		if(novo) {
			mv.addObject("cliente",new Cliente());
		}else {
			mv.addObject("evento", cliente);
		}
		
		
		mv.addObject("mensagem","Cliente Salvo Com Sucesso");
		
		mv.addObject("listarclientes",clienteService.listarCliente());		
		
		return mv;
	}
	
	
	
	@RequestMapping(method= RequestMethod.GET, path="listar")
	public ModelAndView listarCliente(String nome) {
		
		
		List <Cliente>clientes = this.clienteService.listarCliente();

		
		ModelAndView mv = new ModelAndView("cliente/listar.html");
		
		mv.addObject("lista", clientes );
		mv.addObject("nome", nome);
		
		return mv;
	}
	
	
	@RequestMapping(path="excluir")
	public ModelAndView excluirCliente(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
		
		try {
			clienteService.excluirCliente(id);
			redirectAttributes.addFlashAttribute("mensagem", "Cliente Excluído com Sucesso");
		}catch (Exception e){
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
	
			
		}
		return mv;
	}
	

}


