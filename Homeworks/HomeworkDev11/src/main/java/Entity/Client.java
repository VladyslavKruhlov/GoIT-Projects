package Entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Client")
@Data

public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="NAME", length = 200)
    private String name;

    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client{id=").append(id);
        sb.append(", name='").append(name).append('\'');

        // For tickets

        if (tickets != null && !tickets.isEmpty()) {
            sb.append(", ticketIds=[");
            int lastIndex = tickets.size() - 1;

            for (int i = 0; i < lastIndex; i++) {
                sb.append(tickets.get(i).getId()).append(", ");
            }
            sb.append(tickets.get(lastIndex).getId());
            sb.append("]");
        } else {
            sb.append(", ticketIds=[]");
        }

        sb.append('}');
        return sb.toString();
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("Client{id=").append(id);
//        sb.append(", name='").append(name).append('\'');
//
//        if (tickets != null) {
//            sb.append(", ticketIds=[");
//
//            for (Ticket ticket : tickets) {
//                sb.append(ticket.getId()).append(", ");
//            }
//            sb.append("]");
//        }
//
//        sb.append('}');
//        return sb.toString();
    }
//    @ElementCollection
//    @CollectionTable(name = "Ticket", joinColumns = @JoinColumn(name ="client_id"))
//    @Column(name="id")
//    private List<String> ticketList;
}
