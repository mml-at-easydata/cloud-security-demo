package cn.lilq.cloudsecurity.cloudapicommon.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 09:17
 * 响应类 response
 */

public class Response implements Serializable {
    private Integer code;
    private String errorMsg;
    private Object data;

    public Response(Integer code, String errorMsg, Object data) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public Response() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(code, response.code) &&
                Objects.equals(errorMsg, response.errorMsg) &&
                Objects.equals(data, response.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, errorMsg, data);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}