package Project.repository;

import Project.entity.Comment;

import java.util.HashMap;
import java.util.Map;


public class CommentRepository {

    private final Map<Long, Comment> commentMap = new HashMap<>();
    private long idCounter = 0;

    public synchronized Long generateId() {
        return ++idCounter;
    }

    public void addComment(Comment comment) {
        commentMap.put(comment.getId(), comment);
    }

    public Comment findByCommentId(Long id) {
        return commentMap.get(id);
    }

    public void updateComment(Comment comment) {
        commentMap.put(comment.getId(), comment);
    }

    public void deleteComment(Long id) {
        commentMap.remove(id);
    }
    }

