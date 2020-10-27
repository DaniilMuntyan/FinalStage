package kpi.trspo.restapp.entities.employees;

import kpi.trspo.restapp.entities.camera.Camera;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public final class Technician {
    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String phone;

    public void test(Camera camera) {
        Boolean isDefected = new Random().nextInt(4) == 0;
        if(isDefected) {
            camera.setIsRejected(true);
        }
    }

    public void flash(Camera camera) {
        camera.setIsFirmware(true);
    }

    public void clean(Camera camera) {
        camera.setIsWipedClean(true);
    }
}
