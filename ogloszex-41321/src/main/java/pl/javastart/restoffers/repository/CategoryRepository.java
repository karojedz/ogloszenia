package pl.javastart.restoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.restoffers.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String categoryName);
}
