package list.example.DangList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Test(){

    }

    public Test(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sanction{" +
                "name='" + name +
                '}';
    }
}
