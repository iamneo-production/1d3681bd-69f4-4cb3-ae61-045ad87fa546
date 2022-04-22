package com.examly.springapp.web.dto;
import com.examly.springapp.constants.Constants;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddReviewDto {
    @NotNull(message = Constants.USER_ID_VALIDATION)
    private Long userId;
    @NotNull(message = Constants.COURSE_ID_VALIDATION)
    private Long courseId;
    @NotEmpty
    @Size(min=1,max=10000,message =Constants.REVIEW_SIZE_VALIDATION )
    private String message;
    @NotEmpty
    @Range(min = 0,max=5, message=Constants.STAR_RATING_VALIDATION)
    private long starRating;

    public AddReviewDto() {
    }

    public AddReviewDto(long userId, long courseId, String message, long starRating) {
        this.userId = userId;
        this.courseId = courseId;
        this.message = message;
        this.starRating = starRating;
    }

    public AddReviewDto(String message, long starRating) {
        this.message = message;
        this.starRating = starRating;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getStarRating() {
        return starRating;
    }

    public void setStarRating(long starRating) {
        this.starRating = starRating;
    }
}
