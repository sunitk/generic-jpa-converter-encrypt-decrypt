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
package com.sunitkatkar.blogspot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sunitkatkar.blogspot.model.Employee;
import com.sunitkatkar.blogspot.service.EmployeeService;

/**
 * The home page controller
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com
 *         (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (Apr 2018)
 * @version 1.0
 *
 */
@Controller
public class IndexController {

    @Autowired
    EmployeeService empService;

    /**
     * Show the home page
     * 
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = empService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "index";
    }

    /**
     * Handle the employee creation form submission and return to home page
     * 
     * @param employee
     * @return
     */
    @PostMapping("/create")
    public String create(@ModelAttribute("employee") Employee employee) {
        empService.save(employee);
        return "redirect:/";
    }
}
