package com.examly.springapp.service;

import com.examly.springapp.model.Institute;
import com.examly.springapp.repository.InstituteRepository;
import com.examly.springapp.web.dto.InstituteSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService{
    @Autowired
    InstituteRepository instituteRepository;
    @Override
    public String saveInstitute(InstituteSaveDto dto) {

        Institute institute = new Institute(dto.getInstituteName(), dto.getInstituteDescription(),
                dto.getInstituteCity(),dto.getInstituteState(),dto.getInstituteEmail(),
                dto.getInstituteMobile(), dto.getNirfRank());
        instituteRepository.save(institute);
        return "saved";
    }

    @Override
    public List<Institute> getAllInstitutes() {
        return instituteRepository.getAllInstitute();

    }

    @Override
    public Institute getInstituteById(long id) {
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
