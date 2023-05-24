package com.crud.CrudDemo.service.serviceImpl;

import com.crud.CrudDemo.dto.request.PostAddRequest;
import com.crud.CrudDemo.dto.request.PostUpdateRequest;
import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.dto.response.PostUpdateResponse;
import com.crud.CrudDemo.entity.Post;
import com.crud.CrudDemo.exception.PostNotFoundException;
import com.crud.CrudDemo.repository.PostRepo;
import com.crud.CrudDemo.service.PostService;
import com.crud.CrudDemo.utils.DateTimeToString;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    private final PostRepo postRepo;
    private final DateTimeToString dateTimeToString;

    @Override
    public PostResponse createPost(PostAddRequest postRequest) {

        Post postToSave = PostAddRequest.postBuildFromRequest(postRequest);

        postToSave = postRepo.save(postToSave);

        PostResponse savedPostResponse = PostResponse.preparePostResponse(postToSave);

        return savedPostResponse;
    }

    @Override
    public PostResponse getSinglePost(Long id) {

        Post foundPost = postRepo.findById(id).orElseThrow(PostNotFoundException::new);

        return PostResponse.preparePostResponse(foundPost);
    }

    @Override
    public List<PostResponse> getAllPost() {
        return postRepo.findAll()
                .stream()
                .map(post ->
                    PostResponse.preparePostResponse(post)
                )
                .collect(Collectors.toList());
    }

    @Override
    public PostUpdateResponse updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Post postToUpdate = postRepo.findById(postId).orElseThrow(PostNotFoundException::new);

        postToUpdate = postRepo.save(preparePostUpdate(postUpdateRequest, postToUpdate));

        return PostUpdateResponse.postUpdateResponseBuilder(postToUpdate);
    }

    @Override
    public void deletePost(Long postId) {

        Post post = postRepo.findById(postId).orElseThrow(PostNotFoundException::new);
        postRepo.delete(post);
    }

    @Override
    public List<PostResponse> getFirstPageSortedByPostTitle() {

        Pageable findFirstPageSortedByPostTitle = PageRequest.of(1, 5, Sort.by("title"));

        Page<Post> posts = postRepo.findAll(findFirstPageSortedByPostTitle);

        return posts.stream()
                .map(PostResponse::preparePostResponse)
                .collect(Collectors.toList());
    }


    //    Create postResponse
//    public PostResponse preparePostResponse(Post post){
//
//    }

    public Post preparePostUpdate(PostUpdateRequest postUpdateRequest, Post foundPost){
        Post post = new Post();
        post.setId(foundPost.getId());
        if(postUpdateRequest.getTitle() != null) post.setTitle(postUpdateRequest.getTitle());
        if(postUpdateRequest.getDescription() != null) post.setDescription(postUpdateRequest.getDescription());

        // get created timestamp
        post.setCreatedAt(foundPost.getCreatedAt());

        return post;
    }

}
