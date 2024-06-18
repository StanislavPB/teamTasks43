package repository;

import entity.Comment;
import java.util.List;

public class CommentRepository implements CommentInterfaceRepository{

    private List<Comment> comments;

    public CommentRepository(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public Comment addComment(Comment comment) {
        comments.add(comment);
        return null;
    }

    @Override
    public boolean removeComment(Comment comment) {
        return comments.remove(comment);
    }

}
