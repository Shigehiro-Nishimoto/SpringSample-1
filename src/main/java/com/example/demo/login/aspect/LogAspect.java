//パッケージの宣言
package com.example.demo.login.aspect;

//必要なアノテーションのインポート
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//AOPのクラスであることを宣言するとともに、DIコンテナでのBeanの定義を行う。
@Aspect
@Component
public class LogAspect{

	
//@Aroundを用いて、@Controllerがついたclassの処理が行われた際、以下の処理を行うという記述。
	@Around("bean(*Controller)")
	public Object startLog(ProceedingJoinPoint jp)
	throws Throwable {
	
	System.out.println("メソッド 開始："+jp.getSignature());

	try{
		Object result=jp.proceed();

	System.out.println("メソッド 終了："+jp.getSignature());
	
	return result;

		}catch(Exception e) {
			System.out.println("メソッド異常終了 :"+jp.getSignature());
			e.printStackTrace();throw e;
		}
	}
}