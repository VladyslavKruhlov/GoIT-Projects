package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
@Entity
@Table(name="Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id",  nullable = false, referencedColumnName = "id")
    private Client clientId;

    @ManyToOne(targetEntity = Planet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "from_planet_id", nullable = false, referencedColumnName = "id")
    private Planet from;

    @ManyToOne(targetEntity = Planet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "to_planet_id", nullable = false, referencedColumnName = "id")
    private Planet to;
}
