package Project.repository;

import Project.entity.Comment;

public interface ICommentService {
    void addComment(Long taskId, Long userId, String content);
    Comment findByCommentId(Long id);
    void updateComment(Long id, String content);
    void deleteComment(Long id);
}
