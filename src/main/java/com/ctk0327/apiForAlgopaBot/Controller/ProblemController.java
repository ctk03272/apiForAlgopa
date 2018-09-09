package com.ctk0327.apiForAlgopaBot.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctk0327.apiForAlgopaBot.Data.Now;
import com.ctk0327.apiForAlgopaBot.Data.Problems;
import com.ctk0327.apiForAlgopaBot.Data.Solving;
import com.ctk0327.apiForAlgopaBot.Repository.NowRepository;
import com.ctk0327.apiForAlgopaBot.Repository.ProblemRepository;
import com.ctk0327.apiForAlgopaBot.Repository.SolvingRepository;
import com.ctk0327.apiForAlgopaBot.Utils.Constants;
import com.ctk0327.apiForAlgopaBot.Utils.Constants.Member;

@RestController
public class ProblemController {

	@Autowired
	ProblemRepository problemRepository;

	@Autowired
	NowRepository nowRepository;

	@Autowired
	SolvingRepository solvingRepository;

	@RequestMapping(value = "/problemses/thisweek", method = RequestMethod.GET)
	@ResponseBody
	public List<Problems> findAllBoards() {
		Optional<Now> now = nowRepository.findById(Integer.valueOf(1));
		String week = now.get().getWeek();
		String problemNumber = now.get().getProblem();
		Optional<Problems> nowProblem = problemRepository.findById(problemNumber);
		String problem = nowProblem.get().getProblemName();
		ArrayList<Problems> ar = new ArrayList<>();
		problemRepository.findAll().forEach((a) -> {
			if (a.getWeek().equals(week)) {
				a.setMendatory(problem);
				ar.add(a);
			}
		});
		return ar;
	}

	@RequestMapping(value = "/problemses/thisweek/{week}/{problem}", method = RequestMethod.GET)
	@ResponseBody
	public void addThisWeek(@PathVariable String week, @PathVariable String problem) {
		nowRepository.deleteById(1);
		nowRepository.save(new Now(1, week, problem));
	}

	@RequestMapping(value = "/solving", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<Member, ArrayList<String>> findSolving() {
		Optional<Now> now = nowRepository.findById(Integer.valueOf(1));
		String week = now.get().getWeek();
		String problemNumber = now.get().getProblem();
		Optional<Problems> nowProblem = problemRepository.findById(problemNumber);
		String problem = nowProblem.get().getProblemName();
		ArrayList<Problems> ar = new ArrayList<>();
		problemRepository.findAll().forEach((a) -> {
			if (a.getWeek().equals(week)) {
				ar.add(a);
			}
		});
		ArrayList<String> problemNumbers = new ArrayList<>();
		ar.forEach((a) -> {
			problemNumbers.add(a.getProblemId());
		});
		HashMap<Member, ArrayList<String>> solving = new HashMap<>();
		Member[] users = Constants.Member.values();
		for (Member member : users) {
			ArrayList<String> solvings = new ArrayList<>();
			solvingRepository.findAll().forEach((a) -> {
				if (a.getUserId().equals(member.name()) && problemNumbers.contains(a.getProblemId())
						&& !solvings.contains(a.getProblemId())) {
					solvings.add(a.getProblemId());
				}
				solving.put(member, solvings);
			});
			System.out.println(member.name());
		}
		return solving;
	}
}
