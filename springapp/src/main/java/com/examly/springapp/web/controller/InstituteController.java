package com.examly.springapp.web.controller;

import com.examly.springapp.constants.Constants;
import com.examly.springapp.model.Institute;
import com.examly.springapp.service.InstituteService;
import com.examly.springapp.web.dto.InstituteSaveDto;

import exception.ResourceNotFound;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class InstituteController {
    @Autowired
    InstituteService instituteService;


    @PostMapping(Constants.ADD_INSTITUTE_URL_MAPPING)
    @ResponseBody
    public String addInstitute(@RequestBody InstituteSaveDto instituteSaveDto){
    	try {
        instituteService.saveInstitute(instituteSaveDto);
        return Constants.INSTITUTE_SAVED;
    	}
    	catch(Exception e) {
    		return Constants.INSTITUTE_FIELDS_EMPTY;
    	}
    }

    @GetMapping(Constants.VIEW_ALL_INSTITUTE_URL_MAPPING)
    @ResponseBody
    public List<Institute> viewInstitutes(){
        return  instituteService.getAllInstitutes();
    }

    @GetMapping(Constants.VIEW_INSTITUTE_BY_ID_URL_MAPPING)
    @ResponseBody
    public Institute viewInstitute(@PathVariable(Constants.INSTITUTE_ID) long instituteId){
    	
       return   instituteService.getInstituteById(instituteId);
    
    }
    
    
    

    @PutMapping(Constants.EDIT_INSTITUTE_URL_MAPPING)
    @ResponseBody
    public String editInstitute(@RequestBody InstituteSaveDto dto, @PathVariable(Constants.INSTITUTE_ID) long id ){
       try {
    	instituteService.editInstitute(id,dto);
        return Constants.INSTITUTE_EDITED;
       }
       catch(Exception e) {
    	   return Constants.INSTITUTE_FIELDS_EMPTY;
       }
    }

    @DeleteMapping(Constants.DELETE_INSTITUTE_URL_MAPPING)
    @ResponseBody
    String deleteInstitute( @PathVariable(Constants.INSTITUTE_ID) long id){
    
    		try {
    			instituteService.deleteInstitute(id);
    			return Constants.INSTITUTE_DELETED;
    		}
    		catch(Exception e) {
    			return Constants.INSTITUTE_NOT_FOUND;
    		}
    		
        
    }

}
