package kpi.trspo.restapp.entities.camera;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kpi.trspo.restapp.entities.employees.Manager;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cameras")

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public final class Camera {
    @Id
    private UUID camera_id;

    private String innerInfo;
    private Boolean isPacked = false;
    private Boolean isFirmware = false;
    private Boolean isWipedClean = false;
    private Boolean isRejected = false;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "back_id")
    @NonNull
    private CameraBack cameraBack;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "body_id")
    @NonNull
    private CameraBody cameraBody;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lens_id")
    @NonNull
    private CameraLens cameraLens;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
