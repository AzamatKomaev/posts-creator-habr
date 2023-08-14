package ru.azamatcloud.postcreator.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.azamatcloud.postcreator.model.Post;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {
    private Integer id;
    private String title;
    private String description;
    private String author_name;

    public static PostResponse toPostResponse(Post post) {
        return PostResponse.builder()
            .id(post.getId())
            .title(post.getTitle())
            .description(post.getDescription())
            .author_name(post.getAuthorName())
            .build();
    }

    public Post fromPostResponse() {
        return Post.builder()
            .id(id)
            .title(title)
            .description(description)
            .authorName(author_name)
            .build();
    }
}
