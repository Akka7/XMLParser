package list.example.DangList.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SancCompanies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition="TEXT")
    private String info;

    public SancCompanies() {

    }

    public SancCompanies(String name, String info) {
        this.name = name;
        this.info = info;
    }

}
