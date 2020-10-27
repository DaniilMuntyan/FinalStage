package kpi.trspo.restapp.entities.machines;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance
@DiscriminatorColumn

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Machine {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    @NonNull
    private String name;
}
