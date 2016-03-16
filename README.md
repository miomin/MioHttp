#MioHttp
-------------

##Function
1、支持GET/POST/PUT/DELETE<br>
2、支持HTTPClient和HttpUrlConnection<br>
3、多线程断点续传文件下载，支持暂停下载和进度更新<br>
4、封装请求错误的代码，同意处理<br>
4、预处理数据，直接返回对象<br>
5、支持取消请求，支持Activity生命周期绑定,为每个Request绑定Tag与Activity向管理，通过MioRequestManager来管理所有的MioRequest<br>
6、TIMEOUT重试，不需要用户手动刷新，可以在文件中配置最多重试的次数<br>(在MioHttpUrlConnectionUtil里抛出封装好的InterruptedIOException超时异常，在MioRequestTask中捕获异常，并且使用递归做重传，如果最终还是失败，return Exception)
7、多任务HTTP请求队列<br>
8、缓存刷新机制<br>

-------------


## Usage

###Get请求Json，直接返回对象
```java


```

###Get请求Xml，直接返回对象
```java


```

###Get请求String
```java


```

###DownloadFiles
```java


```

###MioRequest与Activity生命周期绑定

```java

        // 实现request与Activity生命周期绑定
        MioRequestManager.getInstance().cancelRequest(toString());
        
```


-------------

## Thanks

- [android-volley](https://github.com/mcxiaoke/android-volley)
