package mk.ukim.finki.emt_181150.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSchemaTypes;



@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author(){

    }
}
