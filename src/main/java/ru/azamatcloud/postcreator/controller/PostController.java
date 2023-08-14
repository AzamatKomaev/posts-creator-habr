package ru.azamatcloud.postcreator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.azamatcloud.postcreator.model.Post;
import ru.azamatcloud.postcreator.request.PostRequest;
import ru.azamatcloud.postcreator.response.PostResponse;
import ru.azamatcloud.postcreator.service.PostService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<PostResponse> getAll() {
        return postService.getAll()
            .stream()
            .map(PostResponse::toPostResponse).toList();
    }

    @GetMapping("/{id}")
    public PostResponse getById(@PathVariable Integer id) {
        return PostResponse.toPostResponse(postService.getById(id));
    }

    @PostMapping("")
    public PostResponse save(@RequestBody PostRequest request) {
        Post postToSave = Post.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .authorName(request.getAuthor_name())
                .build();

        return PostResponse.toPostResponse(postService.save(postToSave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        postService.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatusCode.valueOf(401));
    }
}
