package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Planet")

public class Planet {
    @Id
    private String id;

    @Column(name="NAME", length = 500)
    private String name;

}
