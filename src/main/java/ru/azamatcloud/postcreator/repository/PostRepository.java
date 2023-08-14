package ru.azamatcloud.postcreator.repository;

import org.springframework.data.repository.ListCrudRepository;
import ru.azamatcloud.postcreator.model.Post;

import java.util.Optional;

public interface PostRepository extends ListCrudRepository<Post, Integer> {
    Optional<Post> findById(Integer id);
}
