# study-project

a study project and verify some problems


welcome to join me


## 用户权限设计



## API swagger3集成 
配置类 Swagger3Configuration
### swagger访问地址
```http request
http://localhost:8080/chenyi/swagger-ui/index.html
```



## EndPoint配置
### 健康检查
```http request
http://localhost:8080/chenyi/actuator/health
```


## 引入Thymeleaf

###  配置Thymeleaf
- 配置视图解析器
- 配置引擎
- 配置视图

###  页面Thymeleaf引入问题
1. 引入需要加入thymeleaf声明
`<html lang="en" xmlns:th="http://www.thymeleaf.org">`
2. 引入路径问题
使用th标签，@{/}，根路径为/
```
<script th:src="@{/webjars/jquery/3.1.1/jquery.min.js}"></script>
<script th:src="@{/webjars/bootstrap/3.3.5/js/bootstrap.min.js}"></script>
<link rel="stylesheet" th:href="@{/webjars/bootstrap/3.3.5/css/bootstrap.min.css}"/>
```


## 增加全局错误配置
