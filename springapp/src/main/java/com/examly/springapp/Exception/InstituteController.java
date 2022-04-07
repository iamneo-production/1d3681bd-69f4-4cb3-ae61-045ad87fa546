package com.examly.springapp.web.controller;

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


    @PostMapping("/**/addInstitute")
    @ResponseBody
    public String addCourse(@RequestBody InstituteSaveDto instituteSaveDto){
        instituteService.saveInstitute(instituteSaveDto);
        return "Institute Saved";
    }

    @GetMapping("/**/viewInstitutes")
    @ResponseBody
    public List<Institute> viewInstitutes(){
        return  instituteService.getAllInstitutes();
    }

    @GetMapping("/**/viewInstitute/{instituteId}")
    @ResponseBody
    public Institute viewInstitute(@PathVariable("instituteId") long instituteId){

        return instituteService.getInstituteById(instituteId);

    }
    
    
    

    @PutMapping("/editInstitute")
    @ResponseBody
    public String editInstitute(@RequestBody InstituteSaveDto dto, @RequestParam("instituteId") long id ){
        instituteService.editInstitute(id,dto);
        return "Institute Edited";
    }

    @DeleteMapping("/**/deleteInstitute")
    @ResponseBody
    String deleteInstitute( @RequestParam("instituteId") long id){
    	if(instituteService.getInstituteById(id)==null)
    		throw new ResourceNotFound("Institute not found to be deleted");
        instituteService.deleteInstitute(id);
        return "Institute Deleted";
    }

}
