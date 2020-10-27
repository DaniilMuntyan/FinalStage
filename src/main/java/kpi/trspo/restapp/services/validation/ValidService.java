package kpi.trspo.restapp.services.validation;

import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.entities.employees.Technician;
import kpi.trspo.restapp.entities.machines.Packer;
import kpi.trspo.restapp.exception.InvalidRequestException;
import kpi.trspo.restapp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class ValidService {

    public void checkValidId(UUID id, Class className) throws InvalidRequestException {
        if (id != null)
            return;
    }

    public void checkObjectNotFound(Camera camera, UUID id) throws ResourceNotFoundException {
        if (camera != null)
            return;

        throw new ResourceNotFoundException(String.format("Camera with id %s does not exist", id));
    }

    public void checkObjectNotFound(Technician technician, UUID id) throws ResourceNotFoundException {
        if (technician != null)
            return;

        throw new ResourceNotFoundException(String.format("Technician with id %s does not exist", id));
    }

    public void checkObjectNotFound(Manager manager, UUID id) throws ResourceNotFoundException {
        if (manager != null)
            return;

        throw new ResourceNotFoundException(String.format("Manager with id %s does not exist", id));
    }

    public void checkObjectNotFound(Packer packer, UUID id) throws ResourceNotFoundException {
        if (packer != null)
            return;

        throw new ResourceNotFoundException(String.format("Pack machine with id %s does not exist", id));
    }
    //endregion
}
