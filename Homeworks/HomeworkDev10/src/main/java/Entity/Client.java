package Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Client")
@Data

public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="NAME", length = 200)
    private String name;
}
