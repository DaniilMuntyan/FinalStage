package kpi.trspo.restapp.services.models;

import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.entities.employees.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kpi.trspo.restapp.repositories.employee_repo.ManagerRepository;
import kpi.trspo.restapp.repositories.employee_repo.TechnicianRepository;

import java.util.List;
import java.util.UUID;

@Service
public final class EmployeeService {

    private final ManagerRepository managerRepository;

    private final TechnicianRepository technicianRepository;

    @Autowired
    public EmployeeService(ManagerRepository managerRepository, TechnicianRepository technicianRepository) {
        this.managerRepository = managerRepository;
        this.technicianRepository = technicianRepository;
    }

    public Technician findTechnician(UUID technicianId) {
        if (technicianId == null)
            return null;

        return this.technicianRepository.findById(technicianId).orElse(null);
    }

    public Manager findManager(UUID managerId) {
        if (managerId == null)
            return null;

        return this.managerRepository.findById(managerId).orElse(null);
    }

    public List<Manager> findAllManagers() {
        return this.managerRepository.findAll();
    }

    public List<Technician> findAllTechician() {
        return this.technicianRepository.findAll();
    }

    public Manager save(Manager manager) {
        return this.managerRepository.save(manager);
    }

    public Technician save(Technician technician) {
        return this.technicianRepository.save(technician);
    }
}
