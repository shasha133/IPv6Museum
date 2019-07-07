package museum.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class HttpServletOfEncode extends HttpServletRequestWrapper {
    //设置request装饰器的默认编码属性
    private String encode;
    //无参构造器
    public HttpServletOfEncode(HttpServletRequest request) {
        super(request);
    }
    //定义有参构造器
    public HttpServletOfEncode(HttpServletRequest request, String encode) {
        super(request);
        this.encode = encode;
    }
    /*
     * 重写getparameter
     */
    @Override
    public String getParameter(String name) {
        //调用的是父类getParameter获取传过来的参数
        String value = super.getParameter(name);

        /*
         * 1.开始转码，
         * 2.定义一个中间变量valueLast
         */
        String valueLast = null;

        //给valueLast赋值
        try {
            /*
             * 判断value是否是null，
             * 如果是会null，那么就给valueLast赋值null，
             * 如果不是，就将value的内容用ISO-8859-1解码，然后用UTF-8在编码后返回一个字符串给valueLast
             */
            valueLast = value==null?null:new String(value.getBytes("ISO-8859-1"),encode);
            super.setAttribute(name,valueLast);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return valueLast;
    }
}
