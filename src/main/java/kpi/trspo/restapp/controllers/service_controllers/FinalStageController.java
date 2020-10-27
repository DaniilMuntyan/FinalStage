package kpi.trspo.restapp.controllers.service_controllers;

import kpi.trspo.restapp.dto.requests.final_stage.FinalCheckDTO;
import kpi.trspo.restapp.entities.camera.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kpi.trspo.restapp.services.FinalStageService;

import java.util.UUID;

@RestController
@RequestMapping("/api/service/final_stage/check")
public final class FinalStageController {

    private final FinalStageService finalStageService;

    @Autowired
    public FinalStageController(FinalStageService finalStageService) {
        this.finalStageService = finalStageService;
    }

    @PostMapping
    public ResponseEntity<Camera> finalStageMethod(@RequestBody FinalCheckDTO finalCheckDTO) throws Exception {
        UUID technicianId = finalCheckDTO.getTechnicianId();
        UUID managerId = finalCheckDTO.getManagerId();
        UUID packerId = finalCheckDTO.getPackerId();
        Camera camera = finalCheckDTO.getCamera();

        Camera newCamera = this.finalStageService.finalStage(technicianId, managerId, packerId, camera);

        return ResponseEntity.ok(newCamera);
    }



}
