package com.ctk0327.apiForAlgopaBot.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SolvingId implements Serializable {
	@Column(name = "problem_id")
	private String problemId;

	@Column(name = "user_id")
	private String userId;
}
