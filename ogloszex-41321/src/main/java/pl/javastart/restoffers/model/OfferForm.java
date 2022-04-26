package pl.javastart.restoffers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferForm {

    private String title;
    private String description;
    private String imgUrl;
    private double price;
    private String category;
}
