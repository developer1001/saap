package com.zgc.saap.config.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgc.saap.common.entity.ResResult;
import com.zgc.saap.common.enu.ResultStatusCode;
import com.zgc.saap.common.utils.ResResultUtil;

/**
 * 资源请求失败/找不到，拦截处理
 * @date 2019-12-10 14:57:46
 * @author yang
 */
@RestController
public class ResourceExceptionHandler implements ErrorController{
	private static final Logger logger = LoggerFactory.getLogger(ResourceExceptionHandler.class);
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping(value = "/error")
    public ResResult<String> error(HttpServletRequest request, HttpServletResponse response) {
		//请求路径下资源找不到
		logger.error(ResultStatusCode.REQUEST_NOT_FOUND.getMsg());
		return ResResultUtil.exception(ResultStatusCode.REQUEST_NOT_FOUND.getCode(), "resource does not exist!");
    }
}
