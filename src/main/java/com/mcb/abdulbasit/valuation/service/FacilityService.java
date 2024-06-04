package com.mcb.abdulbasit.valuation.service;

import com.mcb.abdulbasit.valuation.exception.EntityNotFoundException;
import com.mcb.abdulbasit.valuation.model.Facility;
import com.mcb.abdulbasit.valuation.model.dto.FacilityRequest;
import com.mcb.abdulbasit.valuation.model.dto.FacilityResponse;
import com.mcb.abdulbasit.valuation.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final FacilityRepository facilityRepository;

    /**
     * createFacility
     *
     * @param facilityRequest
     * @return FacilityResponse
     */
    public FacilityResponse createFacility(FacilityRequest facilityRequest) {
        Facility facility = Facility.builder()

                .build();
        //map request model to facility object, then persist.
        Facility createdFac = facilityRepository.save(facility);
        if (ObjectUtils.isNotEmpty(createdFac)) {
            return new FacilityResponse("Facility creation successful", createdFac.getId());
        }
        return new FacilityResponse("Facility creation failed", null);
    }

    /**
     * getFacility
     *
     * @param id
     * @return Facility
     */
    public Facility getFacility(Integer id) {
        if (id > 0)
            throw new IllegalArgumentException("facility id cannot be null or empty.");
        Optional<Facility> facility = facilityRepository.findById(id);
        if (!facility.isPresent()) {
            // return no user custom error msg
            throw new EntityNotFoundException("Facility not found");
        }
        return facility.get();
    }

    /**
     * getAllFacilities
     *
     * @return List<Facility>
     */
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    public String createFacilityReference() {
        int currYear = LocalDate.now().getYear();
        int currMonth = LocalDate.now().getMonthValue();

        DecimalFormat mFormat = new DecimalFormat("00");
        String monthStr = mFormat.format(Double.valueOf(currMonth));

        String lastFacilityReference = facilityRepository.findFosReferenceNo();

        if (StringUtils.isNotEmpty(lastFacilityReference) ){
            String lastFacilitySeq = lastFacilityReference.substring(lastFacilityReference.lastIndexOf("/")+1);

            int nextFacilityRefSeq = Integer.parseInt(lastFacilitySeq) + 1;

            String facilityRefBuilder = currYear + "/" + monthStr + "/";

            return facilityRefBuilder + String.format("%04d", nextFacilityRefSeq);
        }

        return currYear + "/" + monthStr + "/0001";
    }
}
