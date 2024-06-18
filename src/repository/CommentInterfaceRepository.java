package repository;

import entity.Comment;

public interface CommentInterfaceRepository {

    Comment addComment(Comment comment);

    boolean removeComment(Comment comment);




}
