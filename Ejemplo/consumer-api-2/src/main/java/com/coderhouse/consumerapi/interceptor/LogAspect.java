package com.coderhouse.consumerapi.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.coderhouse.consumerapi.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    void beforeAdviceMethodAll() {
        System.out.println("Se ejecuta antes de método en el Controller");
    }

    @After("log()")
    void afterAdviceMethodAll() {
        System.out.println("Se ejecuta luego de método en el Controller");
    }

//    //Define el método a ejecutar antes de ingresar al cut plane
//    @Before("log()")
//    public void doBefore(JoinPoint joinPoint) {
//        //Obtenemos el objeto HttpServletRequest que tiene los datos relacionados en el request
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();  //Obtenemos los objetos de  request
//        String url = request.getRequestURL().toString();   //Obtenemos la url invocada
//        String ip = request.getRemoteAddr();     //Obtenemos la direcion ip del objeto requerido
//        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
//        //Obtenemos el nombre del metodo del request del objeto solicitado
//        Object[] args = joinPoint.getArgs();     //Obtenemos los parametros del request del objeto solicitado
//        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
//        System.out.println("Request : " + requestLog);
//    }
//
//    @After("log()")
//    public void doAfter() {
//        System.out.println("------------doAfter-----------------------");
//    }
//
//    //Define el metodo para los valores devueltos por el Controller y loguea por consola
//    @AfterReturning(returning = "result", pointcut = "log()")
//    public void doAfterReturning(Object result) {
//        System.out.println("Result : " + result);
//    }
//
//    //Define una clase interna que representa la informacion relevante para loguear del request
//    private class RequestLog {
//        private String url;
//        private String ip;
//        private String classMethod;
//        private Object[] args;
//
//        public RequestLog(String url, String ip, String classMethod, Object[] args) {
//            this.url = url;
//            this.ip = ip;
//            this.classMethod = classMethod;
//            this.args = args;
//        }
//
//        @Override
//        public String toString() {
//            return "{" +
//                    "url='" + url + '\'' +
//                    ", ip='" + ip + '\'' +
//                    ", classMethod='" + classMethod + '\'' +
//                    ", args=" + Arrays.toString(args) +
//                    '}';
//        }
//    }
}



