package br.com.startapli;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.startapli.crud.CrudExample;
import br.com.startapli.entity.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CrudExample crud;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("serverTime", "Classe -> " + crud.getClassCurrent() );
		
		Person p = new Person(null, "Fake Test");
		
        p.setId(crud.save(p));
        
        crud.getListByName(p.getNome());
		
		for (Person pessoa : crud.listAll()) {
			logger.info("Pessoa -> "+ pessoa.getNome()+" tem o seguinte ID: "+pessoa.getId());
		}
		
		logger.info("Classe -> " + crud.getClassCurrent());
		logger.info("Pessoa com o ID 1 "+ crud.getPessoaResult(p.getId()).getNome());
				
		return "home";
	}
	
}
