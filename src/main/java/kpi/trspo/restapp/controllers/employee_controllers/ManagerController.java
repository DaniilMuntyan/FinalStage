package kpi.trspo.restapp.controllers.employee_controllers;

import kpi.trspo.restapp.dto.employee_dto.EmployeeDTO;
import kpi.trspo.restapp.entities.employees.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kpi.trspo.restapp.services.models.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/service/final_stage/managers")
public final class ManagerController {

    private final EmployeeService employeeService;

    @Autowired
    public ManagerController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Manager> create(@RequestBody EmployeeDTO employeeDTO) {
        Manager newManager = new Manager(employeeDTO.getName(), employeeDTO.getSurname(), employeeDTO.getPhone());
        return ResponseEntity.ok(this.employeeService.save(newManager));
    }

    @GetMapping
    public ResponseEntity<List<Manager>> show() {
        return ResponseEntity.ok(this.employeeService.findAllManagers());
    }

}
