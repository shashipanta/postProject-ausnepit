package com.crud.CrudDemo.controller;

import com.crud.CrudDemo.dto.request.PostAddRequest;
import com.crud.CrudDemo.dto.request.PostUpdateRequest;
import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.dto.response.PostUpdateResponse;
import com.crud.CrudDemo.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest){
//
//        PostResponse createdPostResponse = postService.createPost(postRequest);
//
//        return ResponseEntity.ok(createdPostResponse);
//
//    }

    @PostMapping(value = "/create")
    public PostResponse createPost(@RequestBody PostAddRequest postRequest){
        log.info("Adding Post : {}", postRequest);
        return postService.createPost(postRequest);
    }

    // get all post
    @GetMapping("/")
    public List<PostResponse> getAllPost(){
        log.info("Getting All posts : ");
        return postService.getAllPost();
    }
    
    @GetMapping("/{id}")
    public PostResponse getSinglePost(@PathVariable("id") Long postId){
        PostResponse foundPost = postService.getSinglePost(postId);
        log.info("Single Post : {}", foundPost);
        return foundPost;
    }

    @PutMapping("/{id}")
    public PostUpdateResponse updatePost(@PathVariable("id") Long postId,
                                         @RequestBody PostUpdateRequest postUpdateRequest){
        PostUpdateResponse updatedPostResponse = postService.updatePost(postId, postUpdateRequest);
        return updatedPostResponse;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable("id") Long postId){
        postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
