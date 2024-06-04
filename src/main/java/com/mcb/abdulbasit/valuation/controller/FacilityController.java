package com.mcb.abdulbasit.valuation.controller;

import com.mcb.abdulbasit.valuation.constant.AppConstants;
import com.mcb.abdulbasit.valuation.model.dto.FacilityRequest;
import com.mcb.abdulbasit.valuation.model.dto.FacilityResponse;
import com.mcb.abdulbasit.valuation.service.FacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstants.FACILITY)
@RequiredArgsConstructor
@Slf4j
public class FacilityController {

    private final FacilityService facilityService;

    public ResponseEntity<FacilityResponse> createFacility(@RequestBody FacilityRequest facilityRequest){

        return ResponseEntity.ok(facilityService.createFacility(facilityRequest));
    }
}
