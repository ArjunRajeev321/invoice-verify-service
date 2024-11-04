package com.verification.verification_service.controller;

import java.util.Random;
import java.util.function.IntPredicate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verification.verification_service.common.CustomException;
import com.verification.verification_service.common.ResponseWrapper;

@RestController
@RequestMapping(value = "/verify")
public class VerifyController {

	@GetMapping
	public ResponseWrapper<String> sendReponse() {
		try {
			checkRandomValue();
			return new ResponseWrapper<>(HttpStatus.OK.value(), "Success", "Saved");
		} catch (CustomException ex) {
			return new ResponseWrapper<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Odd value!");
		} catch (Exception e) {
			return new ResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed", "");
		}
	}

	private void checkRandomValue() throws Exception {
		if (!isEvenRandom(100)) {
			throw new CustomException("Random number exception if odd!");
		}
	}

	private boolean isEvenRandom(int maxBound) throws Exception {
		Random random = new Random();
		int x = random.nextInt(100);
		IntPredicate check = number -> number % 2 == 0;
		return check.test(x);
	}

}
