package com.basedeconhecimento.principal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.basedeconhecimento.principal.entities.Evento;
import com.basedeconhecimento.principal.services.EventoService;



@Controller
@RequestMapping("/")
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	
	@RequestMapping(method= RequestMethod.GET, path="/")
	public ModelAndView listarPagina() {
		List <Evento> eventos = this.eventoService.listarEventos();
		ModelAndView mv  = new ModelAndView("index.html");
		mv.addObject("listaEventos", eventos);
		
		return mv;
		
	}
	
	
	@RequestMapping(path="evento/editar")
	public ModelAndView novoDesenvolvedor(@RequestParam (required= false) Long id) {
		
		ModelAndView mv = new ModelAndView("evento/form.html");
		
		Evento evento;
		
		if(id == null ) {
			evento =  new Evento();
			
		}else {
			try {
				evento = eventoService.buscarEvento(id);
			}catch(Exception e ){
				evento =  new Evento();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("evento",evento);
		return mv.addObject("listareventos", eventoService.listarEventos());
	}
	
	@RequestMapping(method= RequestMethod.POST, path="evento/editar")
	public ModelAndView salvarDesenvolvedor(Evento evento, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("evento/form.html");
		
       boolean novo = true;
		
		
		if (bindingResult.hasErrors()) {
			mv.addObject("evento",evento);
			return mv;
		}
		
	    eventoService.salvarEvento(evento);
		
		if(novo) {
			mv.addObject("evento",new Evento());
		}else {
			mv.addObject("evento", evento);
		}
		
		
		mv.addObject("mensagem","Evento Salvo Com Sucesso");
		mv.addObject("listareventos",eventoService.listarEventos());
		
		return mv;
	}
	
	
	@RequestMapping(method= RequestMethod.GET, path="evento/listar")
	public ModelAndView listarEventos (String nomeEvento) {
		
		List <Evento> eventos = this.eventoService.listarEventos();
				
		
		ModelAndView mv = new ModelAndView("evento/listar.html");
		
		mv.addObject("lista", eventos);
		mv.addObject("nome", nomeEvento);
		
		
		return mv;
	}
	
	@RequestMapping(path="evento/excluir")
	public ModelAndView excluir(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/evento/listar");
		
		try {
			eventoService.excluirEvento(id);
			redirectAttributes.addFlashAttribute("mensagem", "Evento Excluído com Sucesso");
		}catch (Exception e){
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
	
			
		}
		return mv;
	}
	

}
