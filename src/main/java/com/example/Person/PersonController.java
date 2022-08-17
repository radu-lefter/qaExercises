package com.example.Person;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PersonController {


    private List<Persons> people = new ArrayList<>();
    
    @GetMapping("/test")
    public String test(@RequestParam(defaultValue = "user") String name) {
        return "Hello, "+ name;
    }
    
    @GetMapping("/add")
    public float add(@RequestParam() float num1, @RequestParam() float num2) {
        //int fNum = 3;
        //int sNum = 5;
        
        Calculator calc = new Calculator(num1, num2);
		
		Calculation cal = new Calculation();
		
		float addition = cal.add(calc.getfNumber(), calc.getsNumber());
		return addition;
    }
    
    @GetMapping("/sub")
    public float sub(@RequestParam() float num1, @RequestParam() float num2) {
        
        Calculator calc = new Calculator(num1, num2);
		
		Calculation cal = new Calculation();
		
		float substraction = cal.sub(calc.getfNumber(), calc.getsNumber());
		return substraction;
    }
    
    @GetMapping("/mul")
    public float mul(@RequestParam() float num1, @RequestParam() float num2) {
        
        Calculator calc = new Calculator(num1, num2);
		
		Calculation cal = new Calculation();
		
		float multiplication = cal.mul(calc.getfNumber(), calc.getsNumber());
		return multiplication;
    }
    
    @GetMapping("/div")
    public float div(@RequestParam() float num1, @RequestParam() float num2) {
        
        Calculator calc = new Calculator(num1, num2);
		
		Calculation cal = new Calculation();
		
		float division = cal.div(calc.getfNumber(), calc.getsNumber());
		return division;
    }
    
    // Create
    @PostMapping("/create")
    public boolean addPerson(Persons person) {
        return this.people.add(person);
    }
    
    @GetMapping("/getAll")
    public List<Persons> getAll() {
        return this.people;
    }

    @PutMapping("/update")
    public Persons updatePerson(@PathParam("id") int id, @RequestBody Persons person) {
        // Remove existing Person with matching 'id'
        this.people.remove(id);
        // Add new Person in its place
        this.people.add(id, person);
        // Return updated Person from List
        return this.people.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public Persons removePerson(@PathVariable int id) {
        // Remove Person and return it
        return this.people.remove(id);
    }
}
