package com.examly.springapp.web.controller;

import com.examly.springapp.model.Review;
import com.examly.springapp.service.ReviewService;
import com.examly.springapp.web.dto.AddReviewDto;
import com.examly.springapp.web.dto.GetReviewsByCourseId;
import com.examly.springapp.web.dto.GetReviewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.constants.Constants;
import javax.validation.Valid;

import java.util.List;

@RestController
public class ReviewController {

	
    @Autowired
    ReviewService reviewService;

    @PostMapping(Constants.ADD_REVIEW_URL_MAPPING)
    @ResponseBody
    public String addReview(@Valid @RequestBody AddReviewDto dto){
        try {
        return reviewService.addReview(dto);
        }
        catch(Exception e) {
        	return Constants.REVIEW_EMPTY;
        }
    }

    @PutMapping(Constants.EDIT_REVIEW_URL_MAPPING)
    @ResponseBody
    public String editReview(@Valid @RequestBody AddReviewDto dto, @PathVariable(Constants.REVIEW_ID) long id){
    	try {
        return reviewService.editReview(dto,id);
    	}
    	catch(Exception e) {
        	return Constants.REVIEW_EMPTY;
        }
    }

    @DeleteMapping(Constants.DELETE_REVIEW_URL_MAPPING)
    @ResponseBody
    public String deleteReview(@PathVariable(Constants.REVIEW_ID) long id){
    	try {
        return reviewService.deleteReview(id);
    	}
    	catch(Exception e) {
    		return Constants.COURSE_NOT_FOUND;
    	}
    }

    @GetMapping(Constants.GET_REVIEWS_BY_COURSE_ID)
    @ResponseBody
    public List<GetReviewsByCourseId> getReviewsByCourseId(@PathVariable(Constants.COURSE_ID) long courseId){
          return reviewService.getReviewsByCourseId(courseId);
    }

    @GetMapping(Constants.GET_REVIEWS_BY_USER_ID)
    @ResponseBody
    public List<GetReviewsByCourseId> getReviewsByUserId(@PathVariable(Constants.USER_ID) long userId){
        return reviewService.getReviewsByUserId(userId);
    }
}
