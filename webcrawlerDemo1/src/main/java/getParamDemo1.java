import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

public class getParamDemo1 {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = "http://yun.itheima.com/search";
        URIBuilder uriBuilder = new URIBuilder(uri);
        uriBuilder.setParameter("keys","java");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        System.out.println(httpGet);
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
            if(response!=null){
                response.close();
            }
        }
    }
}
