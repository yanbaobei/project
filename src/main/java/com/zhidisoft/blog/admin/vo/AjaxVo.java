package com.zhidisoft.blog.admin.vo;

/**
 * ajax请求返回类
 * 
 * @author REN
 *
 */
public class AjaxVo {
	private String errorCode; // 错误码
	private String errorMsg; // 错误信息

	private Object data; // 附加信息

	public String getErrorCode() {
		return errorCode;
	}

	public AjaxVo setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public AjaxVo setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public AjaxVo setData(Object data) {
		this.data = data;
		return this;
	}
	
	

	@Override
	public String toString() {
		return "AjaxVo [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", data=" + data + "]";
	}
	/*public static void main(String[] args) {
		AjaxVo vo = new AjaxVo().setErrorCode("1001").setErrorMsg("yonghusdlfhdsj");
		System.out.println(vo);
	}*/
}
