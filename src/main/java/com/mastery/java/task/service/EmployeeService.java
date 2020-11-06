package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    private final static Logger LOGGER = LogManager.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAll() {
        LOGGER.debug("Get all employees");
        return employeeDao.getAll();
    }

    public Employee getById(Integer id) {
        LOGGER.debug("Get employee with id = {}", id);
        return employeeDao.getById(id);
    }

    public void deleteById(Integer id) {
        LOGGER.debug("Delete employee with id {}", id);
        employeeDao.deleteById(id);
    }

    public Employee add(Employee employee) {
        LOGGER.debug("Add employee {}", employee);
        Date dateOfBirth = employee.getDateOfBirth();
        Date currentDate = new Date();
        if(dateOfBirth.compareTo(currentDate) >= 0){
            throw new DateOfBirthException(dateOfBirth.toString());
        }
        return employeeDao.add(employee);
    }

    public Employee update(Integer id, Employee employee) {
        LOGGER.debug("Update employee with id {} {}", id, employee);
        Date dateOfBirth = employee.getDateOfBirth();
        Date currentDate = new Date();
        if(dateOfBirth.compareTo(currentDate) >= 0){
            throw new DateOfBirthException(dateOfBirth.toString());
        }
        Employee currentEmployee = employeeDao.getById(id);
        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setDepartmentId(employee.getDepartmentId());
        currentEmployee.setJobTitle(employee.getJobTitle());
        currentEmployee.setDateOfBirth(employee.getDateOfBirth());
        return employeeDao.update(currentEmployee);
    }
}
