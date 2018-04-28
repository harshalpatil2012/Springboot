package com.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.model.AppUser;
import com.springboot.model.Rank;
import com.springboot.model.Trainingstatus;
import com.springboot.repositories.RankRepository;
import com.springboot.repositories.TrainingStatusRepository;
import com.springboot.service.UserService;
import com.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserService userService; // Service which will do all data retrieval/manipulation work
	@Autowired
	RankRepository rankRepo;
	@Autowired
	TrainingStatusRepository traingStatRepo;

	// -------------------Retrieve All
	// Users---------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<AppUser>> listAllUsers() {
		logger.debug("INSIDE listAllUsers******************************");
		List<AppUser> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<AppUser>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// AppUser------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") int id) {
		logger.debug("INSIDE getUser******************************");
		logger.info("Fetching AppUser with id {}", id);
		AppUser user = userService.findById(id);
		if (user == null) {
			logger.error("AppUser with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("AppUser with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AppUser>(user, HttpStatus.OK);
	}

	// -------------------Create a
	// AppUser-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody AppUser user, UriComponentsBuilder ucBuilder) {
		logger.debug("INSIDE createUser******************************");
		logger.info("Creating AppUser : {}", user);

		/*
		 * if (userService.isUserExist(user)) {
		 * logger.error("Unable to create. A AppUser with name {} already exist",
		 * user.getName()); return new ResponseEntity( new
		 * CustomErrorType("Unable to create. A AppUser with name " + user.getName() +
		 * " already exist."), HttpStatus.CONFLICT); }
		 */

		String rank = user.getRank().getRank();
		Rank rankObj = rankRepo.findByRank(rank);
		String status = user.getTrainingstatus().getTrainingStatus();
		Trainingstatus trainingStatus = traingStatRepo.findByTrainingStatus(status);
		user.setRank(rankObj);
		user.setTrainingstatus(trainingStatus);
		AppUser createdUser = userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<AppUser>(createdUser, HttpStatus.CREATED);
	}

	// ------------------- Update a AppUser
	// ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody AppUser user) {
		logger.debug("INSIDE createUser******************************");
		logger.info("Updating AppUser with id {}", id);

		// AppUser currentUser = userService.findById(id);

		/*
		 * if (currentUser == null) {
		 * logger.error("Unable to update. AppUser with id {} not found.", id); return
		 * new ResponseEntity(new CustomErrorType("Unable to upate. AppUser with id " +
		 * id + " not found."), HttpStatus.NOT_FOUND); }
		 * 
		 * currentUser.setName(user.getName()); currentUser.setAge(user.getAge());
		 * currentUser.setSalary(user.getSalary());
		 */
		String rank = user.getRank().getRank();
		Rank rankObj = rankRepo.findByRank(rank);
		user.setRank(rankObj);
		userService.updateUser(user);
		return new ResponseEntity<AppUser>(user, HttpStatus.OK);
	}

	// ------------------- Delete a AppUser-----------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting AppUser with id {}", id);

		AppUser user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. AppUser with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. AppUser with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<AppUser> deleteAllUsers() {
		logger.info("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
	}

}