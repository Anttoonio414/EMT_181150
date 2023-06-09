package mk.ukim.finki.emt_181150.model.dto;

import lombok.Data;
import mk.ukim.finki.emt_181150.model.enumerations.Category;

@Data

public class BookDto {

    private String name;
    private Category category;
    private long author;
    private Integer avaliableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, long author, Integer avaliableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.avaliableCopies = avaliableCopies;
    }
}
