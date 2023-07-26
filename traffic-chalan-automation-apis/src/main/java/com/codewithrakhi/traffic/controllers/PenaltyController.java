package com.codewithrakhi.traffic.controllers;


import com.codewithrakhi.traffic.payload.ApiResponse;
import com.codewithrakhi.traffic.payload.PenaltyDto;
import com.codewithrakhi.traffic.payload.ViolationDto;
import com.codewithrakhi.traffic.services.PenaltyService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class PenaltyController {

    @Autowired
    private PenaltyService penaltyService;

    @PostMapping("/user/penalty/{userId}")                                          //added @RequestParam : error
    public ResponseEntity<PenaltyDto> addPenalty(@RequestBody PenaltyDto penaltyDto, @PathVariable Integer userId) {

        PenaltyDto addPenalty = this.penaltyService.addPenalty(penaltyDto, userId);
        return new ResponseEntity<PenaltyDto>(addPenalty, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/penalty/{penaltyId}")
    public ResponseEntity<ApiResponse> deletePenalty(@PathVariable Integer penaltyId) {
        this.penaltyService.deletePenalty(penaltyId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("penalty is successfully deleted!!", true), HttpStatus.OK);
    }

    @PutMapping("/update/penalty/{penaltyId}")
    public ResponseEntity<PenaltyDto> updatePenalty(@RequestBody PenaltyDto penaltyDto, @PathVariable Integer penaltyId) {
        PenaltyDto updatePenalty = this.penaltyService.updatePenalty(penaltyDto, penaltyId);
        return new ResponseEntity<PenaltyDto>(updatePenalty, HttpStatus.OK);
    }

    @GetMapping("/getpenaltyById/{penaltyId}")
    public ResponseEntity<PenaltyDto> getPenaltyById(@PathVariable Integer penaltyId) {
        PenaltyDto getPenaltyById = this.penaltyService.getPenaltyById(penaltyId);
        return new ResponseEntity<PenaltyDto>(getPenaltyById, HttpStatus.OK);
    }

    @GetMapping("/getPenaltyByUser/{userId}")
    public ResponseEntity<List<PenaltyDto>> getPenaltyByUser(@PathVariable Integer userId) {
        List<PenaltyDto> getPenaltyByUser = this.penaltyService.getPenaltyByUser(userId);
        return new ResponseEntity<List<PenaltyDto>>(getPenaltyByUser, HttpStatus.OK);
    }

}
