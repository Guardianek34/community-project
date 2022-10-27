package com.example.communitysystem.posts;

import com.example.communitysystem.comments.Comment;
import com.example.communitysystem.comments.CommentRepository;
import com.example.communitysystem.comments.dto.CommentDTO;
import com.example.communitysystem.posts.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @PostMapping
    public Post addPost(@RequestBody PostDTO dto){
        return postRepository.save(dto.toPost());
    }

    @PatchMapping("/{id}/description")
    public Post changeDescription(@PathVariable("id") long id,
                                  @RequestBody String content){
        Post post = postRepository.findById(id).get(); // welp that's ugly
        post.changeContent(content);
        return postRepository.save(post);
    }

    @PostMapping("/{id}/comment")
    public Comment addComment(@PathVariable("id") long postId,
                              @RequestBody CommentDTO dto){
        Post post = postRepository.findById(postId).get();
        Comment newComment = dto.toComment();

        post.addComment(dto.toComment());

        return commentRepository.save(newComment);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") long postId){
        return postRepository.findById(postId).get();
    }


}
