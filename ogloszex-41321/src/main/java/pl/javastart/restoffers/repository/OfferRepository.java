package pl.javastart.restoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.restoffers.model.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    Long countAllBy();

    List<Offer> findAllByTitleContains(String titleFilter);

    Long countAllByCategory_Id(Long category_Id);
}
