package repository;

import java.util.Date;

public class AnimeCommentData {
    private Date logDate;
    private int score;
    private String comment;

    public AnimeCommentData(){

    }
    public AnimeCommentData(Date logDate, int score, String comment) {
        this.logDate = logDate;
        this.score = score;
        this.comment = comment;
    }

    public Date getLogDate() {
        return logDate;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
