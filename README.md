# MioHttp
-------------
 - 轻量HTTP访问框架，支持GET/POST/PUT/DELETE
 - 支持多线程断点续传的文件下载
 - 支持json/xml预处理，调用时不需要再解析，通过泛型返回需要的对象
 - 封装请求错误的代码，统一处理
 - 支持Activity生命周期绑定
 
 
## Gradle
```
dependencies {
    compile 'com.google.code.gson:gson:2.6.2'
}
```

>## Version

>v2.0.0
 - 封装MioRequest，HTTPURLConnection<br/>
 - 支持GET/POST/PUT/DELETE<br/>
  
>v2.0.1
 - 加入多线程断点续传文件下载，支持暂停下载和进度更新 <br />

>v2.0.2
 - 预处理数据，直接返回对象，支持自动JSON/XML生成对象 <br />

>v2.0.4
 - 封装请求错误的代码，统一处理 <br />

>v2.0.5
 - 支持Activity生命周期绑定，通过MioRequestManager来管理所有的请求 <br />

>v2.0.6
 - 加入TIMEOUT重试机制，不需手动刷新 <br />

>v2.0.7
 - 支持单文件上传与多文件上传。<br />
 - 最近会更新。<br />
 
## Usage

### Get请求Json，直接返回对象
```java


```

### Get请求Xml，直接返回对象
```java


```

### Get请求String
```java


```

### DownloadFiles
```java


```

### MioRequest与Activity生命周期绑定

```java
// 实现request与Activity生命周期绑定
MioRequestManager.getInstance().cancelRequest(toString());        
```


-------------

## Thanks

- [android-volley](https://github.com/mcxiaoke/android-volley)
