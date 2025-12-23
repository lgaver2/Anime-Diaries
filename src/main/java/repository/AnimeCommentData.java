// SPDX-License-Identifier: MIT
package repository;

import java.util.Date;

/**
 * AnimeCommentData
 * The class which store the comment for one episode of one anime
 */
public class AnimeCommentData {
    private Date logDate;
    private int score;
    private String comment;

    // for Jakson which want a void constructor
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
