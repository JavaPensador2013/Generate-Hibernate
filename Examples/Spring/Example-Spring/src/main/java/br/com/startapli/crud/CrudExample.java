package br.com.startapli.crud;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.startapli.entity.Person;

import com.startapli.hibernate.crud.TemplateCrud;

@Resource(name="templateConnection")
public class CrudExample extends TemplateCrud<Person>{

	public CrudExample(String pathJson, List<String> packages) throws Exception {
		super(pathJson, packages);
	}
	
	public Person getPessoaResult(Long id){
		return (Person) currentSession().createCriteria(Person.class).add(Restrictions.idEq(id)).uniqueResult();
	}
	
	public List<Person> getListByName(String name){
		Query query = currentSession().createQuery("From Person p where p.nome = :name");
		query.setParameter("name", name);
		
		return this.getListResultDevelop(query);
	}
}
