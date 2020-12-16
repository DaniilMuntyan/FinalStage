package kpi.trspo.restapp.rabbitmq;

import kpi.trspo.restapp.dto.employee_dto.EmployeeDTO;
import kpi.trspo.restapp.dto.machine_dto.MachineDTO;
import kpi.trspo.restapp.dto.requests.final_stage.FinalCheckDTO;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.entities.employees.Technician;
import kpi.trspo.restapp.entities.machines.Packer;
import kpi.trspo.restapp.rabbitmq.config.MessagingConfig;
import kpi.trspo.restapp.services.FinalStageService;
import kpi.trspo.restapp.services.models.EmployeeService;
import kpi.trspo.restapp.services.models.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class Listeners {

    private final RabbitTemplate template;

    private final EmployeeService employeeService;

    private final MachineService machineService;

    private final FinalStageService finalStageService;

    @Autowired
    public Listeners(MachineService machineService, EmployeeService employeeService, FinalStageService finalStageService, RabbitTemplate template) {
        this.machineService = machineService;
        this.employeeService = employeeService;
        this.finalStageService = finalStageService;
        this.template = template;
    }

    @RabbitListener(queues = MessagingConfig.CREATE_MANAGER_QUEUE)
    public void createManager(EmployeeDTO employeeDTO) {
        Manager newManager = new Manager(employeeDTO.getName(), employeeDTO.getSurname(), employeeDTO.getPhone());
        this.employeeService.save(newManager);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_MANAGER_ROUTING,
                this.employeeService.save(newManager));
    }

    @RabbitListener(queues = MessagingConfig.GET_ALL_MANAGERS_QUEUE)
    public void getAllManagers(String string) throws Exception {
        System.out.println("getAllManagers. " + string);
        List<Manager> managers = this.employeeService.findAllManagers();
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_ALL_MANAGERS_ROUTING, managers);
    }

    @RabbitListener(queues = MessagingConfig.CREATE_TECHNICIAN_QUEUE)
    public void createTechnician(EmployeeDTO employeeDTO) throws Exception {
        Technician newTechnician = new Technician(employeeDTO.getName(), employeeDTO.getSurname(),
                employeeDTO.getPhone());
        this.employeeService.save(newTechnician);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_TECHNICIAN_ROUTING, newTechnician);
    }

    @RabbitListener(queues = MessagingConfig.GET_TECHNICIANS_QUEUE)
    public void getAllTechnicians(String string) throws Exception {
        System.out.println("getAllTechnicians. " + string);
        List<Technician> technicians = this.employeeService.findAllTechician();
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_ALL_TECHNICIANS_ROUTING, technicians);
    }

    @RabbitListener(queues = MessagingConfig.CREATE_PACKER_QUEUE)
    public void createPacker(MachineDTO machineDTO) throws Exception {
        System.out.println("In createPacker");
        Packer newPacker = new Packer(machineDTO.getName());
        this.machineService.save(newPacker);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_PACKER_ROUTING, newPacker);
    }

    @RabbitListener(queues = MessagingConfig.GET_PACKERS_QUEUE)
    public void getAllPackers(String string) throws Exception {
        System.out.println("getAllPackers. " + string);
        List<Packer> packers = this.machineService.findAllPackers();
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_ALL_PACKERS_ROUTING, packers);
    }

    @RabbitListener(queues = MessagingConfig.FINAL_STAGE_QUEUE)
    public void finalStage(FinalCheckDTO finalCheckDTO) throws Exception {
        UUID technicianId = finalCheckDTO.getTechnicianId();
        UUID managerId = finalCheckDTO.getManagerId();
        UUID packerId = finalCheckDTO.getPackerId();
        Camera camera = finalCheckDTO.getCamera();
        Camera newCamera = this.finalStageService.finalStage(technicianId, managerId, packerId, camera);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.RESPONSE_FINAL_STAGE_ROUTING, newCamera);
    }
}
