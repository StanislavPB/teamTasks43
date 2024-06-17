package entity;

import java.time.LocalDate;

public class Comment {
    private Integer idComment;
    private String commentTo;
    private String commentFrom;
    private LocalDate dateComment;
    private String content;

    public Comment(Integer idComment, String commentTo, String commentFrom, LocalDate dateComment, String content) {
        this.idComment = idComment;
        this.commentTo = commentTo;
        this.commentFrom = commentFrom;
        this.dateComment = dateComment;
        this.content = content;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public String getCommentTo() {
        return commentTo;
    }

    public String getCommentFrom() {
        return commentFrom;
    }

    public LocalDate getDateComment() {
        return dateComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCommentTo(String commentTo) {
        this.commentTo = commentTo;
    }
}
