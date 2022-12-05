package org.niit.C13_S3_MongoDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Customer with specified id is not exist")
public class CustomerNotFoundException extends Exception{
}
