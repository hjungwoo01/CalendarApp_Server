package com.hjungwoo01.calendarappserver;

import com.hjungwoo01.calendarappserver.repositories.event.EventRepository;
import com.hjungwoo01.calendarappserver.repositories.memo.MemoRepository;
import com.hjungwoo01.calendarappserver.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestApiApplication {
	@Autowired
	UserRepository userRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	MemoRepository memoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
