package com.sunitkatkar.blogspot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunitkatkar.blogspot.model.Employee;

/**
 * The service which acts as a bridge between the data access repository layer
 * and the calling layer, for example, the MVC UI layer. The UI layer remains
 * separated from the actual data access layer by using this service.
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com
 *         (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (Apr 2018)
 * @version 1.0 
 */
public interface EmployeeService {

    void save(Employee emp);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findAll();

}
