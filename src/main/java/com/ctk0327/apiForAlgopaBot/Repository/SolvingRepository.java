package com.ctk0327.apiForAlgopaBot.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ctk0327.apiForAlgopaBot.Data.Solving;
import com.ctk0327.apiForAlgopaBot.Data.SolvingId;

public interface SolvingRepository extends CrudRepository<Solving, SolvingId> {

}
