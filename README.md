# exception-helper

##使用方式

1.gradle配置
```gradle
    implementation 'com.github.120011676:ladybird-spring-boot-web-helper:latest.release'
```

2.java启动文件配置
```java
@SpringBootApplication(scanBasePackages = {"com.github.qq120011676.ladybird"}, scanBasePackageClasses = Application.class)
public class Application {
```

3.application.yml配置
```yaml
ladybird:
  restful-exception:
    code-name: errCode
    message-name: errMsg
    messages:
      no_login:
        httpStatus: 401
        message: 未登录
      no_authority:
        httpStatus: 403
        message: 无权限
```

###代码使用
```java
ControllerHelper.getHttpServletRequest();
```