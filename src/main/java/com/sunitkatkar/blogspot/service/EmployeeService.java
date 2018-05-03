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
