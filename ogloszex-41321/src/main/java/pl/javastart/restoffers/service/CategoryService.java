package pl.javastart.restoffers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.restoffers.model.Category;
import pl.javastart.restoffers.model.CategoryDto;
import pl.javastart.restoffers.repository.CategoryRepository;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final OfferRepository offerRepository;

    @Autowired
    CategoryService(CategoryRepository categoryRepository, OfferRepository offerRepository) {
        this.categoryRepository = categoryRepository;
        this.offerRepository = offerRepository;
    }

    public List<String> findNames() {
        return categoryRepository.findAll().stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::turnCategoryIntoCategoryDto)
                .collect(Collectors.toList());
    }

    private CategoryDto turnCategoryIntoCategoryDto(Category category) {
        CategoryDto categoryDto= new CategoryDto();
        categoryDto.setDescription(category.getDescription());
        categoryDto.setName(category.getName());
        categoryDto.setOffers(offerRepository.countAllByCategory_Id(category.getId()));
        return categoryDto;
    }
}
