package kpi.trspo.restapp.repositories.machine_repo;

import kpi.trspo.restapp.entities.machines.Packer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PackerRepository extends JpaRepository<Packer, UUID> {

}