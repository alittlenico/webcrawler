import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class postParamDemo1 {

    public static void main(String[] args) throws Exception{
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpPost对象，设置url访问地址
        HttpPost httpPost = new HttpPost("http://www.itcast.cn/");
        //声明List集合，封装表单中的参数
        List<NameValuePair> list = new ArrayList<>();
        //设置请求地址是：http://yun.itheima.com/search?keys=Java
        list.add(new BasicNameValuePair("keys","java"));
        //创建表单的Entity对象,第一个参数就是封装好的表单数据，第二个参数就是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list,"utf8");
        //设置表单的Entity对象到Post请求中
        httpPost.setEntity(formEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content.length());
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(response!=null){
                response.close();
            }
        }




    }
}
