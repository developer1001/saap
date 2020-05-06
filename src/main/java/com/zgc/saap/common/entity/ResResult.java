package com.zgc.saap.common.entity;

import lombok.Data;
/**
 * 返回结果
 * @date 2020-04-30 15:24:28
 * @author yang
 */
@Data
public class ResResult<T> {
	private int resultCode;
	private String resultMessage;
	private T data;
	private String timestamp;
}
