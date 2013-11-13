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

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CrudExample crud;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("classCurrent", "Class -> " + crud.getClassCurrent() );
		
		Person p = new Person(null, "Fake Test");
		
        	p.setId(crud.save(p));
        
        	crud.getListByName(p.getNome());
		
		for (Person personCurrent : crud.listAll()) {
			logger.info("Person -> "+ personCurrent.getName()+" this is o ID: "+personCurrent.getId());
		}
		
		logger.info("Name of the Person ID One 1 "+ crud.getPessoaResult(p.getId()).getName());
				
		return "home";
	}
	
}
