package myJoin.common.vo;

import java.io.Serializable;

import myJoin.common.enumx.ResponseEnum;
/**
 * 响应数据封装
 * @author user
 *
 */

public class ResponseInfo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3775572753019305474L;
	/** 响应状态码 **/
    private String resCode;
    /** 响应内容 **/
    private String resMsg;
    /** 流程编号 业务编号 **/
    private String flowId;
    /** 返回数据**/
    private T t;
    public ResponseInfo() {

    }

    public ResponseInfo(String resCode, String resMsg, String flowId, T t) {
		super();
		this.resCode = resCode;
		this.resMsg = resMsg;
		this.flowId = flowId;
		this.t = t;
	}

	public ResponseInfo(ResponseEnum responseEnum){
    	this.resCode = responseEnum.getCode();
    	this.resMsg = responseEnum.getDesc();
    }
    public ResponseInfo(ResponseEnum responseEnum, String flowId) {
	this.resCode = responseEnum.getCode();
	this.resMsg = responseEnum.getDesc();
	this.flowId = flowId;
    }

    public ResponseInfo(String resCode, String resMsg) {
	this.resCode = resCode;
	this.resMsg = resMsg;
    }

    public ResponseInfo(String resCode, String resMsg, String flowId) {
	this.resCode = resCode;
	this.resMsg = resMsg;
	this.flowId = flowId;
    }

    public String getResCode() {
	return resCode;
    }

    public void setResCode(String resCode) {
	this.resCode = resCode;
    }

    public String getResMsg() {
	return resMsg;
    }

    public void setResMsg(String resMsg) {
	this.resMsg = resMsg;
    }

    public String getFlowId() {
	return flowId;
    }

    public void setFlowId(String flowId) {
	this.flowId = flowId;
    }

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}


}
