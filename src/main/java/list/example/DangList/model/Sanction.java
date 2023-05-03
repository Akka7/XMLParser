package list.example.DangList.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Sanction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition="TEXT")
    private String info;

    public Sanction(){

    }

    public Sanction(String name, String info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Sanction{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

}
