package repository;

import java.util.Date;

public class AnimeCommentData {
    private Date logDate;
    private String comment;

    public AnimeCommentData(){

    }
    public AnimeCommentData(Date logDate, String comment) {
        this.logDate = logDate;
        this.comment = comment;
    }

    public Date getLogDate() {
        return logDate;
    }

    public String getComment() {
        return comment;
    }
}
