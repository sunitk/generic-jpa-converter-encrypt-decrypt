/**
 * 
 */
package com.sunitkatkar.blogspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunitkatkar.blogspot.model.Employee;
import java.lang.String;
import java.util.List;

/**
 * JPA Entity Repository which provides access to all database operations for
 * the 'employee' table
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com  (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (Apr 2018)
 * @version 1.0
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstname);
}
