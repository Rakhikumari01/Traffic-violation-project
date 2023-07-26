package com.codewithrakhi.traffic.services.Seviceimpl;

import com.codewithrakhi.traffic.entity.Penalty;
import com.codewithrakhi.traffic.entity.User;
import com.codewithrakhi.traffic.entity.Violation;
import com.codewithrakhi.traffic.exception.ResourceNotFoundException;
import com.codewithrakhi.traffic.payload.PenaltyDto;
import com.codewithrakhi.traffic.payload.ViolationDto;
import com.codewithrakhi.traffic.repositories.PenaltyRepo;
import com.codewithrakhi.traffic.repositories.UserRepo;
import com.codewithrakhi.traffic.services.PenaltyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PenaltyServiceImpl implements PenaltyService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PenaltyRepo penaltyRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public PenaltyDto addPenalty(PenaltyDto penaltyDto, Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
        Penalty penalty = this.modelMapper.map(penaltyDto, Penalty.class);

        penalty.setPenaltyType(penaltyDto.getPenaltyType());
        penalty.setFineAmount(penaltyDto.getFineAmount());
        penalty.setUser(user);

        Penalty newPenalty = this.penaltyRepo.save(penalty);
        return this.modelMapper.map(newPenalty, PenaltyDto.class);

    }

    @Override
    public void deletePenalty(Integer penaltyId) {

        Penalty penalty = this.penaltyRepo.findById(penaltyId).orElseThrow(() -> new ResourceNotFoundException("Penalty", "Penaltu id", penaltyId));

        this.penaltyRepo.delete(penalty);
    }

    @Override
    public PenaltyDto updatePenalty(PenaltyDto penaltyDto, Integer penaltyId) {

        Penalty penalty = this.penaltyRepo.findById(penaltyId).orElseThrow(() -> new ResourceNotFoundException("Penalty", "Penalty id", penaltyId));

        penalty.setPenaltyType(penaltyDto.getPenaltyType());
        penalty.setFineAmount(penaltyDto.getFineAmount());

        Penalty newPenalty = this.penaltyRepo.save(penalty);
        return this.modelMapper.map(newPenalty, PenaltyDto.class);
    }

    @Override
    public PenaltyDto getPenaltyById(Integer penaltyId) {

        Penalty penalty = this.penaltyRepo.findById(penaltyId).orElseThrow(() -> new ResourceNotFoundException("Penalty", "Penalty id", penaltyId));

        return this.modelMapper.map(penalty, PenaltyDto.class);
    }

    @Override
    public List<PenaltyDto> getPenaltyByUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " user id", userId));
        List<Penalty> penalties = this.penaltyRepo.findByUser(user);

        List<PenaltyDto> penaltyDtos = penalties.stream().map((penalty) -> this.modelMapper.map(penalty, PenaltyDto.class)).collect(Collectors.toList());

        return penaltyDtos;

    }
}
