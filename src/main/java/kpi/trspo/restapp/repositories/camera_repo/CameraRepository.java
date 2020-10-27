package kpi.trspo.restapp.repositories.camera_repo;

import kpi.trspo.restapp.entities.camera.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CameraRepository extends JpaRepository<Camera, UUID> {

}
