package kpi.trspo.restapp.entities.employees;

import kpi.trspo.restapp.entities.camera.Camera;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
public final class Manager {
    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String phone;

    public Manager(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public void orderDetails(Camera camera) {
        System.out.println("Ordered " + camera.getCamera_id());
    }
}
