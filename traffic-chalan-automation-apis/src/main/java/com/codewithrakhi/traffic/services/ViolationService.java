package com.codewithrakhi.traffic.services;

import com.codewithrakhi.traffic.payload.ViolationDto;

import java.util.List;

public interface ViolationService {


    ViolationDto addViolation(ViolationDto violationDto, Integer userId);

    ViolationDto updateViolation(ViolationDto violationDto, Integer violationId);

    void deleteViolation(Integer violationId);

    ViolationDto getViolationById(Integer violationId);

    List<ViolationDto> getViolationByUser(Integer userId);

    //testing on github (creating new branch and adding)
    List<ViolationDto> getViolationByPenalty(Integer penaltyId);

    //testing on github (creating new branch and adding)
    List<ViolationDto> getViolationByVehicleNo(Integer vehiclenumber);
}
