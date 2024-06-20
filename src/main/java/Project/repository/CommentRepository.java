package Project.repository;

import Project.entity.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommentRepository {
    private List<Comment> comments = new ArrayList<>();
    private Long counter = 0L;

    public Comment addComment(Comment comment) {
        comment.setId(++counter);
        comments.add(comment);
        return comment;
    }

    public List<Comment> findAllCommentsByTaskId(Long taskId) {
        return comments.stream()
                .filter(comment -> comment.getTaskId().equals(taskId))
                .collect(Collectors.toList());
    }

    public Optional<Comment> findCommentById(Long commentId) {
        return comments.stream()
                .filter(comment -> comment.getId().equals(commentId))
                .findFirst();
    }

    public Comment updateComment(Comment updatedComment) {
        Comment comment = findCommentById(updatedComment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        comment.setContent(updatedComment.getContent());
        comment.setTimestamp(updatedComment.getTimestamp());
        return comment;
    }

    public boolean removeComment(Comment comment) {
        return comments.remove(comment);
    }
}
