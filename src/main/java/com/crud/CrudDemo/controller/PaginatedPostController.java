package com.crud.CrudDemo.controller;

import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.entity.Post;
import com.crud.CrudDemo.service.PageablePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/posts/page")
public class PaginatedPostController {

    private final PageablePostService pageablePostService;

    @GetMapping(value = "/")
    public List<PostResponse> getPaginatedPosts(){
        return pageablePostService.getAllPosts();
    }

    @GetMapping(value = "/{page-number}")
    public List<PostResponse> getPaginatedPostByPageNumber(@PathVariable("page-number") Integer pageNumber){

        return pageablePostService.getPostByPageNumber(pageNumber);
    }

    // pass both page-number and page-offset

    @GetMapping("/{page-number}/{page-offset}")
    public List<PostResponse> getPaginatedPostByPageNumberAndPageOffset(
            @PathVariable("page-number") Integer pageNumber,
            @PathVariable("page-offset") Integer pageOffset
    ){
        return pageablePostService.getPostByPageNumberAndPageOffset(pageNumber, pageOffset);
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
