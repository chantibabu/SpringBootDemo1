package com.example.springBootDemo1.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_num")
	private Address address_num;

	public Address getAddress_num() {
		return address_num;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address_num=" + address_num + "]";
	}

	public void setAddress_num(Address address_num) {
		this.address_num = address_num;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
