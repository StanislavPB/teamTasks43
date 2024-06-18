package service;

import entity.Comment;
import repository.CommentRepository;

public class CommentService {
    private CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public boolean addNewComment(Comment comment) {
        repository.addComment(comment);
        return true;
    }
}
