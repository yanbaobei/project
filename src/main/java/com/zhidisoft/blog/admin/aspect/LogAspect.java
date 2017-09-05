package com.zhidisoft.blog.admin.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * ��־ jdk�Ķ�̬����֧����ע�룬ֻ֧�ֽӿڷ�ʽע��
 * 
 * @author REN
 *
 */

@Component
@Aspect
public class LogAspect {

	// TODO ��ô�Ѳ�����־��ŵ����ݿ�
/*	@Before("execution(* com.zhidisoft.blog.admin.service..*.*(..))")
	public void beforeAdvice() {
		System.out.println("����ִ��ǰ��¼");
	}*/
}
