package kpi.trspo.restapp.entities.employees;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String phone;
}
