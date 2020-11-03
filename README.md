# cloud-security-demo
### UI
http://localhost:8080/
+ username
    ```
    admin
    ```
+ password
    ```
    123456
    ```
### api
##### 认证
+ 第三方验证地址
http://localhost:9090/oauth/token
+ 查询用户信息(第三方)
http://localhost:9090/user
+ 第三方验证地址(JWT)
http://localhost:7010/oauth/token
+ 查询用户信息(第三方JWT)
http://localhost:7010/user
##### 书籍
需要在`Request Header`携带Token 

example
```http request
GET http://localhost:8080/api/v1/book/book/
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZXN0IjoiYWRtaW4tLWhlbGxvIHdvcmxkIiwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjA0MzQ2MTQyLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImI2MTBjZTczLTU0MGEtNDVhYi05YzE4LWNkM2Q0M2ZkY2FiZiIsImNsaWVudF9pZCI6ImNsb3VkLXNlY3VyaXR5In0.X8dr80O_PK9WOb7XEYaDrtE2deh4YcZ1fLF_QYcWcfA
```
+ 查询书籍
    ```http request
    GET http://localhost:8080/api/v1/book/book/
    ```
+ 查询指定书籍
    ```http request
    GET http://localhost:8080/api/v1/book/book/{id}
    ```
+ 添加书籍
    ```http request
    POST http://localhost:8080/api/v1/book/book/
    Content-Type: application/json
    
    {
        "name": "Spring in Action",
        "category": "JAVA",
        "repertory": 10
    }
    ```

+ 修改书籍
    ```http request
    PUT http://localhost:8080/api/v1/book/book/
    Content-Type: application/json
    
    {
        "id":"4028ab15757d90cf01757d9456bb0000",
        "name": "Spring in Action",
        "category": "JAVA",
        "repertory": 10
    }
    ```
+ 测试书籍服务JWT传递并解析
    ```http request
    GET http://localhost:8080/api/v1/book/book/test
    ```

+ 书籍服务生产订单
    ```http request
    POST http://localhost:8080/api/v1/book/book/shop
    Content-Type: application/json
    
    {
        "userId": "0001",
        "goodsId": "4028ab15757d90cf01757d9456bb0000"
    }
    ```

+ 书籍服务测试JWT传递订单服务 传递并解析
    ```http request
    GET http://localhost:8080/api/v1/book/book/shop/test
    ```


##### 订单
需要在`Request Header`携带Token 

example
```http request
GET http://localhost:8080/api/v1/book/book/
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZXN0IjoiYWRtaW4tLWhlbGxvIHdvcmxkIiwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjA0MzQ2MTQyLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImI2MTBjZTczLTU0MGEtNDVhYi05YzE4LWNkM2Q0M2ZkY2FiZiIsImNsaWVudF9pZCI6ImNsb3VkLXNlY3VyaXR5In0.X8dr80O_PK9WOb7XEYaDrtE2deh4YcZ1fLF_QYcWcfA
```
+ 查询订单
    ```http request
    GET http://localhost:8080/api/v1/order/order
    ```

+ 查询指定订单
    ```http request
    GET http://localhost:8080/api/v1/order/order/{id}
    ```

+ 添加订单
    ```http request
    POST http://localhost:8080/api/v1/order/order
    Content-Type: application/json
    
    {
        "goodsId":"4028ab15757d90cf01757d9456bb0000",
        "userId":"0001"
    }
    ```

+ 修改订单
    ```http request
    PUT http://localhost:8080/api/v1/order/order
    Content-Type: application/json
    
    {
        "id": "4028ab1575819627017581b7c9ec0000",
        "userId": "0001",
        "goodsId": "4028ab15757d90cf01757d9456bb0000",
        "date": "2020-11-01T02:51:47.000+00:00"
    }
    ```
+ 测试订单服务JWT传递并解析
    ```http request
    GET http://localhost:8080/api/v1/order/order/test
    ```

### 示意图
![show](https://github.com/quan930/cloud-security-demo/blob/main/show.png)