package com.example.VoterDetailed.fetch.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EpicNumberNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EpicNumberNotFoundException(String message) {
        super(message);
    }
}
