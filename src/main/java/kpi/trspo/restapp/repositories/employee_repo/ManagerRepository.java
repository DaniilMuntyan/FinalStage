package kpi.trspo.restapp.repositories.employee_repo;

import kpi.trspo.restapp.entities.employees.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, UUID> {

}
