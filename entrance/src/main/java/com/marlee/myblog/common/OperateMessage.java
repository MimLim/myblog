package com.marlee.myblog.common;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Ajax操作返回信息
 *
 */
public class OperateMessage implements Serializable {

	private static final long serialVersionUID = -7295464290183189928L;

	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_FAIL = "fail";
	public static final String STATUS_ERROR = "error";
	public static final String STATUS_WARN = "warn";

	private String status;
	private Object data;
	private String message;

	@JSONField(serialize = false)
	public boolean isSuccess() {
		return STATUS_SUCCESS.equals(getStatus());
	}

	/**
	 * @param status
	 */
	public OperateMessage(String status) {
		super();
		this.status = status;
	}

	public static OperateMessage success(String message, Object data) {
		OperateMessage am = new OperateMessage(STATUS_SUCCESS);
		am.setMessage(message);
		am.setData(data);
		return am;
	}

	public static OperateMessage success(String message) {
		OperateMessage am = new OperateMessage(STATUS_SUCCESS);
		am.setMessage(message);
		return am;
	}

	public static OperateMessage failue(Map<String, String> errors) {
		OperateMessage am = new OperateMessage(STATUS_FAIL);
		Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>(1);
		data.put("errors", errors);
		am.setData(data);
		return am;
	}

	public static OperateMessage error(String message) {
		OperateMessage am = new OperateMessage(STATUS_ERROR);
		am.setMessage(message);
		return am;
	}

	public static OperateMessage warn(String message) {
		OperateMessage am = new OperateMessage(STATUS_WARN);
		am.setMessage(message);
		return am;
	}

	public OperateMessage data(Object data) {
		this.data = data;
		return this;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public OperateMessage setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public OperateMessage setData(Object data) {
		this.data = data;
		return this;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public OperateMessage setMessage(String message) {
		this.message = message;
		return this;
	}

}