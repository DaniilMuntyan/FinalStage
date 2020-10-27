package kpi.trspo.restapp.controllers.employee_controllers;

import kpi.trspo.restapp.dto.employee_dto.EmployeeDTO;
import kpi.trspo.restapp.entities.employees.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kpi.trspo.restapp.services.models.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/service/final_stage/technicians")
public final class TechnicianController {

    private final EmployeeService employeeService;

    @Autowired
    public TechnicianController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Technician> create(@RequestBody EmployeeDTO employeeDTO) {
        Technician newTechnician = new Technician(employeeDTO.getName(), employeeDTO.getSurname(),
                employeeDTO.getPhone());
        return ResponseEntity.ok(this.employeeService.save(newTechnician));
    }

    @GetMapping
    public ResponseEntity<List<Technician>> show() {
        return ResponseEntity.ok(this.employeeService.findAllTechician());
    }

}
