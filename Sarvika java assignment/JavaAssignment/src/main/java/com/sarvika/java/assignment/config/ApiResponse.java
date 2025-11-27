package com.sarvika.java.assignment.config;

public class ApiResponse {

	private int status;
	private String message;
	private Object data;

	public ApiResponse() {
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public static class Builder {

		private int status;
		private String message;
		private Object data;

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder data(Object data) {
			this.data = data;
			return this;
		}

		public ApiResponse build() {
			ApiResponse res = new ApiResponse();
			res.status = this.status;
			res.message = this.message;
			res.data = this.data;
			return res;
		}
	}

	public static Builder builder() {
		return new Builder();
	}

}
