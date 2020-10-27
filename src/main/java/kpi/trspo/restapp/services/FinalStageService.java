package kpi.trspo.restapp.services;

import java.util.AbstractMap.SimpleImmutableEntry;

import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.entities.employees.Technician;
import kpi.trspo.restapp.entities.machines.Packer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kpi.trspo.restapp.services.models.CameraService;
import kpi.trspo.restapp.services.models.EmployeeService;
import kpi.trspo.restapp.services.models.MachineService;
import kpi.trspo.restapp.services.validation.ValidService;

import java.util.UUID;

@Service
public final class FinalStageService {

    private final CameraService cameraService;

    private final EmployeeService employeeService;

    private final MachineService machineService;

    private final ValidService validService;

    @Autowired
    public FinalStageService(CameraService cameraService, EmployeeService employeeService,
                             MachineService machineService, ValidService validService) {
        this.cameraService = cameraService;
        this.employeeService = employeeService;
        this.machineService = machineService;
        this.validService = validService;
    }

    private void test(Technician technician, Camera camera) {
        technician.test(camera);
    }

    private void flash(Technician technician, Camera camera) {
        technician.flash(camera);
    }

    private void clean(Technician technician, Camera camera) {
        technician.clean(camera);
    }

    private void pack(Packer packer, Camera camera) {
        packer.pack(camera);
    }

    private void order(Manager manager, Camera camera) {
        manager.orderDetails(camera);
    }

    public Camera finalStage(UUID technicianId, UUID managerId, UUID packerId, Camera camera) throws Exception {
        Technician technician = this.getTechnicianAndCamera(technicianId);

        SimpleImmutableEntry<Manager, Packer> manager_packer = this.getManagerAndPacker(managerId, packerId);
        Manager manager = manager_packer.getKey();
        Packer packer = manager_packer.getValue();

        this.test(technician, camera);

        if(!camera.getIsRejected()) {
            this.flash(technician, camera);
            this.clean(technician, camera);
            this.pack(packer, camera);

        } else {
            this.order(manager, camera);
        }

        return this.cameraService.save(camera);
    }

    private SimpleImmutableEntry<Manager, Packer> getManagerAndPacker(UUID managerId, UUID packerId) throws Exception {
        this.validService.checkValidId(managerId, Manager.class);
        this.validService.checkValidId(packerId, Packer.class);

        Manager manager = this.employeeService.findManager(managerId);
        Packer packer = this.machineService.findPacker(packerId);

        this.validService.checkObjectNotFound(manager, managerId);
        this.validService.checkObjectNotFound(packer, packerId);

        return new SimpleImmutableEntry<>(manager, packer);
    }

    private Technician getTechnicianAndCamera(UUID technicianId) throws Exception {
        this.validService.checkValidId(technicianId, Technician.class);

        Technician technician = this.employeeService.findTechnician(technicianId);

        this.validService.checkObjectNotFound(technician, technicianId);

        return technician;
    }
}
