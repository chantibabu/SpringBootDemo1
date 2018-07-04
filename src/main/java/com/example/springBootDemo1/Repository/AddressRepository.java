package com.example.springBootDemo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootDemo1.Model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
