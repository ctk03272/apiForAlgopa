package com.ctk0327.apiForAlgopaBot.Data;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Solving {
	@EmbeddedId
	SolvingId solvingId;
	String solving;
	Date addtime;
}
