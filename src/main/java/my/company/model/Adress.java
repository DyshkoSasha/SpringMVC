package my.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "user_address")
@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_adress")
    private int id_adress;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private int house;
    @OneToOne(mappedBy = "adress", orphanRemoval = true)
    private User user;

    public Adress(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }
}
