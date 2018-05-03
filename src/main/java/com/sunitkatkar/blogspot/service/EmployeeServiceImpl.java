/**
 * 
 */
package com.sunitkatkar.blogspot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunitkatkar.blogspot.model.Employee;
import com.sunitkatkar.blogspot.repository.EmployeeRepository;

/**
 * The actual implementation of the {@link EmployeeService}
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com
 *         (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (Apr 2018)
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    /*
     * (non-Javadoc)
     * 
     * @see com.sunitkatkar.blogspot.service.EmployeeService#save(com.sunitkatkar.
     * blogspot.model.Employee)
     */
    @Override
    public void save(Employee emp) {
        empRepo.save(emp);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sunitkatkar.blogspot.service.EmployeeService#findByFirstName(java.lang.
     * String)
     */
    @Override
    public List<Employee> findByFirstName(String firstName) {

        return empRepo.findByFirstName(firstName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sunitkatkar.blogspot.service.EmployeeService#findAll()
     */
    @Override
    public List<Employee> findAll() {

        return empRepo.findAll();
    }

}
