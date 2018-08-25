package com.ctk0327.apiBotAlgopaBot.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctk0327.apiForAlgopaBot.Data.Problems;
import com.ctk0327.apiForAlgopaBot.Repository.ProblemRepository;

@RestController
public class ProblemController {

	@Autowired
	ProblemRepository problemRepository;


	@RequestMapping(value = "/problemses/{week}", method = RequestMethod.GET)
	@ResponseBody
	public List<Problems> findAllBoards(@PathVariable String week) {
		ArrayList<Problems> ar = new ArrayList<>();
		problemRepository.findAll().forEach((a)->{
			if(a.getWeek().equals(week)) {
				ar.add(a);
			}
		});
		return ar;
	}
}
