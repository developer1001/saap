package com.zgc.saap.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.zgc.saap.common.constant.ResultCode;
import com.zgc.saap.common.entity.ResResult;

import lombok.Data;

@Data
public class ResResultUtil<T> {
	private static Logger LOGGER = LoggerFactory.getLogger(ResResultUtil.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static <T> ResResult<T> success(T t) {
		ResResult<T> resResult = new ResResult<T>();
		resResult.setResultCode(ResultCode.CODE_200);
		resResult.setResultMessage("OK");
		resResult.setTimestamp(sdf.format(new Date()));
		resResult.setData(t);
		LOGGER.info("result[{}]", JSONObject.toJSONString(resResult));
		return resResult;
	}

	public static ResResult success() {
		ResResult resResult = new ResResult();
		resResult.setResultCode(ResultCode.CODE_200);
		resResult.setResultMessage("OK");
		resResult.setTimestamp(sdf.format(new Date()));
		resResult.setData(null);
		return resResult;
	}
	
	public static ResResult<String> error(String msg) {
		ResResult<String> resResult = new ResResult<String>();
		resResult.setResultCode(ResultCode.CODE_500);
		resResult.setResultMessage("ERROR");
		resResult.setTimestamp(sdf.format(new Date()));
		resResult.setData(msg);
		return resResult;
	}
	
	public static ResResult<String> exception(int code, String msg) {
		ResResult<String> resResult = new ResResult<String>();
		resResult.setResultCode(code);
		resResult.setResultMessage("ERROR");
		resResult.setTimestamp(sdf.format(new Date()));
		resResult.setData(msg);
		return resResult;
	}
}
