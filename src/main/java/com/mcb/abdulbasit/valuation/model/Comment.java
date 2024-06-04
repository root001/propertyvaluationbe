package com.mcb.abdulbasit.valuation.model;

import com.mcb.abdulbasit.valuation.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {
    @NonNull
    private String body;

}
