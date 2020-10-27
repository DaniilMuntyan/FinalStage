package kpi.trspo.restapp.services.models;

import kpi.trspo.restapp.entities.camera.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kpi.trspo.restapp.repositories.camera_repo.CameraBackRepository;
import kpi.trspo.restapp.repositories.camera_repo.CameraBodyRepository;
import kpi.trspo.restapp.repositories.camera_repo.CameraLensRepository;
import kpi.trspo.restapp.repositories.camera_repo.CameraRepository;

import java.util.List;
import java.util.UUID;

@Service
public final class CameraService {

    private final CameraRepository cameraRepository;

    @Autowired
    public CameraService(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public Camera save(Camera camera) {
        return this.cameraRepository.save(camera);
    }
}
