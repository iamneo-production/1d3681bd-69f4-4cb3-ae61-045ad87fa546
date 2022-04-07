package com.examly.springapp.service;

import com.examly.springapp.model.Institute;
import com.examly.springapp.repository.InstituteRepository;
import com.examly.springapp.web.dto.InstituteSaveDto;

import CustomException.BusinessException;
import exception.ResourceNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService{
    @Autowired
    InstituteRepository instituteRepository;
    @Override
    public Institute saveInstitute(InstituteSaveDto dto) {

        Institute institute = new Institute(dto.getInstituteName(), dto.getInstituteDescription(),
                dto.getInstituteCity(),dto.getInstituteState(),dto.getInstituteEmail(),
                dto.getInstituteMobile(), dto.getNirfRank());
        
        
       
        	if(dto.getInstituteName().isEmpty()||dto.getInstituteDescription().isEmpty()||
        			 dto.getInstituteCity().isEmpty()||dto.getInstituteState().isEmpty()||
        			 dto.getInstituteEmail().isEmpty()||
                     dto.getInstituteMobile().isEmpty()) {
        		throw new  ResourceNotFound("Some Institute filelds are empty");
        	
        	}
        	
       Institute t= instituteRepository.save(institute);
        
        return t;
    }
        

    
    @Override
    public List<Institute> getAllInstitutes() {
        return instituteRepository.getAllInstitute();

    }

    @Override
    public Institute getInstituteById(long id) {
    	if(instituteRepository.findByInstituteId(id)==null) {
    		throw new ResourceNotFound("Institute not found");
    	}
        return instituteRepository.findByInstituteId(id);
    }

    @Override
    public void editInstitute(long id,InstituteSaveDto dto) {
        instituteRepository.editInstituteById(id,dto.getInstituteName(),dto.getInstituteDescription(),
                dto.getInstituteCity(),dto.getInstituteState(),dto.getInstituteEmail(),
                dto.getInstituteMobile(),dto.getNirfRank());
    }

    @Override
    public void deleteInstitute(long id) {
    	
        instituteRepository.deleteInstituteById(id);
        	   
    }

}
