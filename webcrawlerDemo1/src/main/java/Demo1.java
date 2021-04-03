import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo1 {

    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                if(response!=null){
                    response.close();
                }
                if(httpClient!=null){
                    httpClient.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }




    }
}
