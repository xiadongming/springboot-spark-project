package com.itchina.globalexception;

import com.itchina.common.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Date: 2021/2/28 13:09
 * @Desc: 全局异常统一处理类
 */
@Controller
public class GlobalExceptionController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private ErrorAttributes errorAttributes;
    public GlobalExceptionController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * Web页面错误处理
     */
/*    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }*/
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ApiResponse errorApiHandler(HttpServletRequest request, final Exception ex, final WebRequest req) {
        //ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> attrMap = this.errorAttributes.getErrorAttributes(req, false);
        int status = getStatus(request);
        return ApiResponse.ofMessage(status, String.valueOf(attrMap.getOrDefault("message", "error")));
    }

    /**
     * 处理页面之外的api，如json/xml
     * spring-boot-autoconfigure
     * <version>1.5.7.RELEASE</version> 的包
     **/
/*    @RequestMapping(value = ERROR_PATH, method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request) {
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> attrMap = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        int status = getStatus(request);
        return ApiResponse.ofMessage(status,String.valueOf(attrMap.getOrDefault("message","error")));
    }*/

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }
        return 500;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
