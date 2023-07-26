package com.codewithrakhi.traffic.payload;

import com.codewithrakhi.traffic.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PenaltyDto {

    private int penaltyId;

    @NotEmpty
    private int fineAmount;

    @NotEmpty
    @Size(max = 25, message = "penalty description should not be more than 25 characters")
    private String penaltyType;

    private UserDto user;
}
