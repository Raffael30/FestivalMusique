package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Soliste;
import com.inti.service.ISolisteService;

/**
 * @author Raphaël EYCHENNE
 * 
 * Permet de réaliser les opérations CRUD
 */

@Controller
@RequestMapping("soliste")
public class SolisteController {

	@Autowired
	ISolisteService iss;

	@GetMapping("getAllSoliste")
	public String getAllSoliste(Model m) {
		
		m.addAttribute("listeSoliste", iss.getAllSoliste());
		return "getAllSoliste";
	}

	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste soliste) {

		iss.saveSoliste(soliste);
		return "redirect:getAllSoliste";
	}

	@GetMapping("updateSoliste/{num}")
	public String updateSoliste(@PathVariable("num") Long num, Model m) {
		m.addAttribute("soliste", iss.getSoliste(num));
		return "formUpdateSoliste";
	}

	@GetMapping("deleteSoliste/{num}")
	public String deleteSoliste(@PathVariable("num") Long num) {
		
		iss.deleteSoliste(num);
		return "redirect:getAllSoliste";
	}

}
