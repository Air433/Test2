import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * Created by ouyanggang on 2018/1/18.
 */
public class Test5 {
  @Test
  public void test1() throws InterruptedException {
    Test3 test3 = new Test3();
    test3.start();
    Test3 test2 = new Test3();
    test2.start();
    Test3.aaa();
    Thread.sleep(1000000);
  }
  @Test
  public void test2(){
    int n = 10;
    for (int i = 0; ~i < n; i--) {
      System.err.println("=");
    }

  }
  @Test
  public void test3(){

    for (int i = 0; i < 10; i++) {
      System.err.println(~i);
    }
    int i = 0;
    while (1==1){

    }
  }
  @Test
  public void test5() throws MalformedURLException {
    String url = "http://www.qq.com";
    String result = sendGet(url);
    System.err.println(result);

  }
  @Test
  public void test6() throws MalformedURLException {
    String url = "https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_10483621106537465991%22%7D&n_type=0&p_from=1";
    String regsult = sendGet(url);
    System.err.println(regsult.length());
    int i = 0;
    while (1==1){
      if (regsult == null){
        return;
      }
      String imgSrc = regexString(regsult, "src=\"(.+?)\"");
      //System.err.println(string);
      int idd = regexInt(regsult, "src=\"(.+?)\"");
      //System.err.println(i);
      String img = regexString(imgSrc, "https:(.+?png)");
      if (img!=null){
        System.err.println(img);
      }

      regsult = regsult.substring(idd);

      if ("Nothind".equals(imgSrc)){
        break;
      }
    }

  }
  private String regexString(String result, String regex){
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(result);
    boolean b = matcher.find();
    if (b){
      return matcher.group();
    }
    return null;
  }
  private int regexInt(String result, String regex){
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(result);
    boolean b = matcher.find();
    if (b){
      int end = matcher.end();
      return end;
    }
   return 0;
  }
  private String sendGet(String url2) throws MalformedURLException {

    //创建一个URL实例
    URL url = new URL(url2);
    String data = null;
    String result = null;
    try {
      //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
      InputStream is = url.openStream();
      InputStreamReader isr = new InputStreamReader(is, "utf-8");


      //为字符输入流添加缓冲
      BufferedReader br = new BufferedReader(isr);
      data = br.readLine();//读取数据

      while (data != null) {//循环读取数据
        //System.out.println(data);//输出数据
        data = br.readLine();
        result = result + data;
      }



      br.close();
      isr.close();
      is.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }


}
