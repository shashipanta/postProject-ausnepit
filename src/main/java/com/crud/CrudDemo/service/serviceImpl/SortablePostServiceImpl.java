package com.crud.CrudDemo.service.serviceImpl;

import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.entity.Post;
import com.crud.CrudDemo.repository.PageableAndSortablePostRepo;
import com.crud.CrudDemo.service.SortablePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SortablePostServiceImpl implements SortablePostService {

    private final PageableAndSortablePostRepo pageableAndSortablePostRepo;
    @Override
    public List<PostResponse> getSortedPost() {
        Sort findPostSortedById = Sort.by("id");

        Iterable<Post> sortedPostIterable = pageableAndSortablePostRepo.findAll(findPostSortedById);

        Stream<Post> sortedPostStream = StreamSupport.stream(sortedPostIterable.spliterator(), false);

        return sortedPostStream
                .map(PostResponse::preparePostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostResponse> getPostSortedByTitle() {
        Iterable<Post> iterable = pageableAndSortablePostRepo.findAll(Sort.by("title"));

        Stream<Post> postStream = StreamSupport.stream(iterable.spliterator(), false);

        return postStream
                .map(PostResponse::preparePostResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<PostResponse> getPostSortedByAttribute(String attributeName) {

        if(attributeName.length() == 0) attributeName = "id";

        Iterable<Post> postIterable = pageableAndSortablePostRepo.findAll(Sort.by(attributeName));

        Stream<Post> postStream = StreamSupport.stream(postIterable.spliterator(), false);

        return postStream
                .map(PostResponse::preparePostResponse)
                .collect(Collectors.toList());

    }
}
