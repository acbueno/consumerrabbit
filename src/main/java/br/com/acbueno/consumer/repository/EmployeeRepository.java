package br.com.acbueno.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.acbueno.consumer.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {


}
