package br.com.acbueno.consumer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.consumer.model.Employee;
import br.com.acbueno.consumer.model.EmployeeToJson;
import br.com.acbueno.consumer.repository.EmployeeRepository;

@Service
public class EmployeeService {
  
  @Autowired
  private ModelMapper mapper;

  @Autowired
  private EmployeeRepository employeeRepository;


  public Employee createOrUpdate(EmployeeToJson employeeJson) {
    Employee map = mapper.map(employeeJson, Employee.class);
    return  employeeRepository.save(map);

  }

}


