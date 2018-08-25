package com.ctk0327.apiForAlgopaBot.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Problems {
	@Id
	String problemId;
	String problemName;
	String link;
	String week;

}
