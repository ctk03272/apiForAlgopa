package com.ctk0327.apiForAlgopaBot.Data;

import java.util.Date;
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
	@Id
	String problemId;
	String userId;
	String solving;
	Date addtime;
}
