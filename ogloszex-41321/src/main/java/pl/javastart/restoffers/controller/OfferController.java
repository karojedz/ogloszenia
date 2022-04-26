package pl.javastart.restoffers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.model.OfferForm;
import pl.javastart.restoffers.service.OfferService;
import pl.javastart.restoffers.model.OfferDto;

import java.util.List;

@RestController @RequestMapping("/api")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers")
    List<OfferDto> findAll() {
        return offerService.findAll();
    }

    @GetMapping("/offers/title/{title}")
    List<OfferDto> findAll(@PathVariable String title) {
        return offerService.findAll(title);
    }

    @PostMapping("/offers")
    public void save(@RequestBody OfferForm offerForm) {
        offerService.save(offerForm);
    }

    @GetMapping("/offers/{id}")
    OfferDto find(@PathVariable Long id) {
        return offerService.findById(id);
    }

    @GetMapping("offers/count")
    Long count() {
        return offerService.countAllBy();
    }

}
