package personStore;

import java.util.ArrayList;
import java.util.List;

public class Person {

	protected String name;
	protected String email;
	protected List<Skill> skillSet = new ArrayList<Skill>();
	
	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Person() {
	}

	@Override
	public String toString() {
		return "Name: " + name + " e-mail: " + email + skillSet;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		return name == person.getName();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skill> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<Skill> skillSet) {
		this.skillSet = skillSet;
	}
	
	public void addSkill(Skill skill){
		skillSet.add(skill);
	}
}
