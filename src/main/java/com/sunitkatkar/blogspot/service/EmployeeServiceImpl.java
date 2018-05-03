/**
 * Copyright 2018 onwards - Sunit Katkar (sunitkatkar@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
