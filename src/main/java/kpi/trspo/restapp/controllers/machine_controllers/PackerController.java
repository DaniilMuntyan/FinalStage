package kpi.trspo.restapp.controllers.machine_controllers;

import kpi.trspo.restapp.dto.machine_dto.MachineDTO;
import kpi.trspo.restapp.entities.machines.Packer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kpi.trspo.restapp.services.models.MachineService;

import java.util.List;

@RestController
@RequestMapping("/api/service/final_stage/packers")
public final class PackerController {

    private final MachineService machineService;

    @Autowired
    public PackerController(MachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping
    public ResponseEntity<Packer> create(@RequestBody MachineDTO machineDTO) {
        Packer newPacker = new Packer(machineDTO.getName());
        return ResponseEntity.ok(this.machineService.save(newPacker));
    }

    @GetMapping
    public ResponseEntity<List<Packer>> show() {
        return ResponseEntity.ok(this.machineService.findAllPackers());
    }

}
