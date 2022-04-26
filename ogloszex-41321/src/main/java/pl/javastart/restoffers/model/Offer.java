package pl.javastart.restoffers.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String imgUrl;
    private double price;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;

    public Offer(String title, String description, String imgUrl, double price, Category category) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.category = category;
    }
}
