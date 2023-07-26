package com.codewithrakhi.traffic.services;


import com.codewithrakhi.traffic.payload.PenaltyDto;

import java.util.List;

public interface PenaltyService {

    PenaltyDto addPenalty(PenaltyDto penaltyDto, Integer userId);

    void deletePenalty(Integer penaltyId);

    PenaltyDto updatePenalty(PenaltyDto penaltyDto, Integer penaltyId);

    PenaltyDto getPenaltyById(Integer penaltyId);

    List<PenaltyDto> getPenaltyByUser(Integer userId);


}
