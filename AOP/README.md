# AOP记录
## 项目讲解
包目录
```java
#使用aspectj结合注解的方式实现aop
com.troyqu.annotation.aop.aspectj

#使用interceptor结合注解实现的aop
com.troyqu.annotation.aop.interceptor
```
com.troyqu.annotation.aop.aspectj
```sh
com.troyqu.annotation.aop.aspectj.annotation包保存定义的注解类
com.troyqu.annotation.aop.aspectj.aop包保存定义的aop页面类，和aop处理方法逻辑
-- AspectAnnotationAop 基于Aspect和pointcut注解 @annotation方式声明的AOP
-- AspectExectionAop 基于Aspect和pointcut注解 execution表达式方式声明的AOP
-- AspectWithinAop 基于Aspect和pointcut注解 @Within方式声明的AOP
-- HumanAnnotationAop 基于Aspect和 @annotation方式声明的AOP
-- TroyAnnotationAop 基于Aspect和 @annotation方式声明的AOP
com.troyqu.annotation.aop.aspectj.controller包保存示例controller接口，使用annotation包中的注解，被aop包中的类切割
com.troyqu.annotation.aop.aspectj.execcontroller包保存为AspectExecutionAop进行展示的接口
```
com.troyqu.annotation.aop.interceptor包下目录结构比较简单不做太多说明
## 关注点
### 多个AOP命中同一个目标
当有多个AOP声明类命中同一个目标的时候，可以通过对AOP声明类配置Order接口来声明AOP的执行顺序，可以通过调整com.troyqu.annotation.aop.aspectj.aop包下AspectAnnotationAOP和HumanAnnotationAOP中的Order顺序来验证。<br>
执行步骤:
1. 调整com.troyqu.annotation.aop.aspectj.aop包下AspectAnnotationAOP和HumanAnnotationAOP中的Order的value；
2. 触发com.troyqu.annotation.aop.aspectj.controller包下AnnotationController下("/asp/testHuman")接口和("/asp/testHuman/{name}")接口来查看结果