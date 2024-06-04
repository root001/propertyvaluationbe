package com.mcb.abdulbasit.valuation.service;

import com.mcb.abdulbasit.valuation.exception.EntityNotFoundException;
import com.mcb.abdulbasit.valuation.model.Facility;
import com.mcb.abdulbasit.valuation.model.dto.FacilityRequest;
import com.mcb.abdulbasit.valuation.model.dto.FacilityResponse;
import com.mcb.abdulbasit.valuation.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final FacilityRepository facilityRepository;

    public FacilityResponse createFacility(FacilityRequest facilityRequest){
        Facility facility = new Facility();
        //map request model to facility object, then persist.
        Facility createdFac = facilityRepository.save(facility);
        String msg = ObjectUtils.isNotEmpty(createdFac) ? "Facility creation successful " : "Facility creation failed";
        return new FacilityResponse();
    }

    public Facility getFacility(Integer id){
        if(id > 0)
            throw new IllegalArgumentException("facility id cannot be null or empty.");
        Optional<Facility> facility = facilityRepository.findById(id);
        if(!facility.isPresent()){
            // return no user custom error msg
            throw new EntityNotFoundException("Facility not found");
        }
        return facility.get();
    }

    public List<Facility> getAllFacilities(){
        return facilityRepository.findAll();
    }
}
