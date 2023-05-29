
package com.rs.baseproject.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class NoRecordFoundForGivenIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer employeeId;
}
