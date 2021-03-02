package com.txb.study.exception;

/**
 * 自定义异常类 ROOT
 * @author Administrator
 *
 */
public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2027846681553881370L;

	public CustomException() {}
	public CustomException(String message) {super(message);}
	public CustomException(Throwable cause) {
		super(cause);
	}
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}
