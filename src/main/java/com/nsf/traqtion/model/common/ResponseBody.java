package com.nsf.traqtion.model.common;

/**
 * ResponseBody is Response template used to maintain response template/structure consistent across the application.
 * @author HTC Global Services
 *
 */
public class ResponseBody {

	public Boolean isSuccess = Boolean.TRUE;
	public String statusMsg;
	public String errorCode;
	public String errorMsg;
	public Object data;
	
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseBody [isSuccess=" + isSuccess + ", statusMsg=" + statusMsg + ", errorCode=" + errorCode
				+ ", errorMsg=" + errorMsg + ", data=" + data + "]";
	}
	
}
