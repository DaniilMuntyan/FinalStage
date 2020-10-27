package kpi.trspo.restapp.services.models;

import kpi.trspo.restapp.entities.machines.Packer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kpi.trspo.restapp.repositories.machine_repo.PackerRepository;

import java.util.List;
import java.util.UUID;

@Service
public final class MachineService {

    private final PackerRepository packerRepository;

    @Autowired
    public MachineService(PackerRepository packerRepository) {
        this.packerRepository = packerRepository;
    }

    public Packer findPacker(UUID packerId) {
        if(packerId == null)
            return null;

        return this.packerRepository.findById(packerId).orElse(null);
    }

    public Packer save(Packer packer) {
        return this.packerRepository.save(packer);
    }

    public List<Packer> findAllPackers() {
        return this.packerRepository.findAll();
    }

}
