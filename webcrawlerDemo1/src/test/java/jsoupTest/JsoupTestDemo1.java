package jsoupTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.net.URL;

public class JsoupTestDemo1 {
    @Test
    public void testUrl() throws Exception {
        //解析url地址,第一个参数是访问的url，第二个参数是访问时候的超时时间
        Document doc = Jsoup.parse(new URL("https://s.taobao.com/search?q=手机"), 1000);

        //使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("image").first().text();

        //打印
        System.out.println(title);
    }

}
