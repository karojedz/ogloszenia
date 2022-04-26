package pl.javastart.restoffers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.restoffers.model.*;
import pl.javastart.restoffers.repository.CategoryRepository;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<OfferDto> findAll() {
        return turnOfferListIntoOfferDtoList(offerRepository.findAll());
    }

    public List<OfferDto> findAll(String title) {
        return turnOfferListIntoOfferDtoList(offerRepository.findAllByTitleContains(title));
    }

    private List<OfferDto> turnOfferListIntoOfferDtoList(List<Offer> offerList) {
        return offerList.stream()
                .map(this::offerToDto)
                .collect(Collectors.toList());
    }

    private OfferDto offerToDto(Offer offer) {
        return new OfferDto(offer.getId(), offer.getTitle(), offer.getDescription(), offer.getImgUrl(),
                offer.getPrice(), offer.getCategory().getName());
    }

    public OfferDto findById(Long id) {
        return offerToDto(offerRepository.findById(id).orElse(new Offer()));
    }

    public Long countAllBy() {
        return offerRepository.countAllBy();
    }

    public void save(OfferForm offerForm) {
        String categoryName = offerForm.getCategory();
        Category category = categoryRepository.findByName(categoryName).orElseThrow(IllegalArgumentException::new);
        Offer offer = new Offer(offerForm.getTitle(), offerForm.getDescription(), offerForm.getImgUrl(), offerForm.getPrice(), category);
        offerRepository.save(offer);
    }
}
