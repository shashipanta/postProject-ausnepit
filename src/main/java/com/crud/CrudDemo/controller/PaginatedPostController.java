package com.crud.CrudDemo.controller;

import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.service.PageablePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/post/page")
public class PaginatedPostController {

    private final PageablePostService pageablePostService;

    @GetMapping(value = "/")
    public List<PostResponse> getPaginatedPosts(){
        return pageablePostService.getAllPosts();
    }

    @GetMapping(value = "/{page-number}")
    public List<PostResponse> getPaginatedPostByPageNumber(@PathVariable("page-number") Integer pageNumber){

        return pageablePostService.getPostsByOffset(pageNumber);
    }

    @GetMapping(value = "/third-page")
    public List<PostResponse> getThirdPageWithTwoPosts(){
        return pageablePostService.getThirdPageWithTwoPosts();
    }

    @GetMapping(value = "/find-by-title/{title}")
    public List<PostResponse> getPaginatedPostByTitle(@PathVariable("title") String postTitle){
        return pageablePostService.getPostByPostTitle(postTitle);
    }
}
