package pl.javastart.restoffers.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    private Long id;
    private String title;
    private String description;
    private String imgUrl;
    private double price;
    private String category;
}
