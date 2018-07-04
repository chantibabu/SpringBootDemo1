package com.example.springBootDemo1.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootDemo1.Model.Address;
import com.example.springBootDemo1.Model.Student;
import com.example.springBootDemo1.Repository.AddressRepository;
import com.example.springBootDemo1.Repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class CrudController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	@GetMapping(value="/getValues")
	public List<Student> getStudent(){
		List<Student> students=studentRepository.findAll();
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getAddress_num());
		}
		return studentRepository.findAll();
	}
	
	@PostMapping(value="/saveValues")
	public Student saveStudents(@RequestBody Map<String,String> data){
		Student s=new Student();
		Address a = new Address();
		a.setCity(data.get("city"));
		a.setState(data.get("state"));
		a.setDistrict(data.get("district"));
		a.setDoorNo(data.get("doorNo"));
		Address a1=addressRepository.save(a);
		s.setName(data.get("name"));
		s.setAddress_num(a1);
		studentRepository.save(s);
		return s;
	}

	
	

}
