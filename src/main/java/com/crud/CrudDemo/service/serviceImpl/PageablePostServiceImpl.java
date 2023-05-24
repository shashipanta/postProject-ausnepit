package com.crud.CrudDemo.service.serviceImpl;

import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.entity.Post;
import com.crud.CrudDemo.exception.PageNotValidException;
import com.crud.CrudDemo.exception.PostNotFoundException;
import com.crud.CrudDemo.repository.PageableAndSortablePostRepo;
import com.crud.CrudDemo.service.PageablePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PageablePostServiceImpl implements PageablePostService {

    private final PageableAndSortablePostRepo pageableAndSortablePostRepo;

    Pageable firstPageWithFivePosts = PageRequest.of(0, 5);
    Pageable thirdPageWithTwoPosts = PageRequest.of(3, 2);


    // get first five posts
    @Override
    public List<PostResponse> getAllPosts() {

        // default returns Page<Type> we can use List<Type> by our custom method
        Page<Post> firstFivePosts = pageableAndSortablePostRepo.findAll(firstPageWithFivePosts);

        List<PostResponse> firstFivePostResposne =
                firstFivePosts.stream()
                        .map(post -> PostResponse.preparePostResponse(post))
                        .collect(Collectors.toList());
        return firstFivePostResposne;

    }

    public List<PostResponse> getThirdPageWithTwoPosts(){

        Page<Post> posts = pageableAndSortablePostRepo.findAll(thirdPageWithTwoPosts);

        return posts.stream()
                    .map(post -> PostResponse.preparePostResponse(post))
                    .collect(Collectors.toList());
    }

    @Override
    public List<PostResponse> getPostByPostTitle(String postTitle) {

        List<Post> foundPosts = pageableAndSortablePostRepo.findPostByTitle(postTitle, firstPageWithFivePosts);

        return foundPosts.stream()
                    .map(PostResponse::preparePostResponse)
                    .collect(Collectors.toList());

    }

    // By default this gives us 2 entries given in page number
    @Override
    public List<PostResponse> getPostsByOffset(Integer pageNumber) {
        // page starts from 0 so make
        pageNumber = pageNumber -1;

        if(pageNumber < 0) throw new PageNotValidException(pageNumber+1);

        Pageable findPostByOffset = PageRequest.of(pageNumber, 2);

        Page<Post> posts = pageableAndSortablePostRepo.findAll(findPostByOffset);

        int totalPagesAvailable = posts.getTotalPages();

        if (totalPagesAvailable < pageNumber) throw new PageNotValidException(pageNumber+1);

        return posts.getContent()
                .stream()
                .map(PostResponse::preparePostResponse)
                .collect(Collectors.toList());
    }
}
