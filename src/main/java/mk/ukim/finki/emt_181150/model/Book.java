package mk.ukim.finki.emt_181150.model;


import lombok.Data;
import mk.ukim.finki.emt_181150.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;


    @ManyToOne
    private Author author;

    private Integer avaliableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, Integer avaliableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.avaliableCopies = avaliableCopies;
    }
}
