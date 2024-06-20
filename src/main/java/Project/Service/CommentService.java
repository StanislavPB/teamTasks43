package Project.Service;

import Project.entity.Comment;
import Project.repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Long taskId, Long userId, String content) {
        Comment comment = new Comment(null, taskId, userId, content, LocalDateTime.now());
        return commentRepository.addComment(comment);
    }

    public List<Comment> findAllCommentsByTaskId(Long taskId) {
        return commentRepository.findAllCommentsByTaskId(taskId);
    }

    public Optional<Comment> findCommentById(Long commentId) {
        return commentRepository.findCommentById(commentId);
    }

    public Comment updateComment(Long commentId, String content) {
        Comment comment = commentRepository.findCommentById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        comment.setContent(content);
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.updateComment(comment);
    }

    public boolean removeComment(Long commentId) {
        Comment comment = commentRepository.findCommentById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        return commentRepository.removeComment(comment);
    }
}

