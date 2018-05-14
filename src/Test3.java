import com.Adapter.InterfaceAdapter.Sourceable;
import com.Proxy.Proxy;
import com.factory.four.MailSendFactory;
import com.factory.four.Provider;
import com.fanxing.Person;
import com.fanxing.Student;
import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.*;
import java.util.*;

/**
 * Created by Air on 2017/6/12.
 */
public class Test3 <T> extends Thread{
    Random rand = new Random();
    @Test
    public void t1(){

        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(i);
                int a = 3 / 0;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    @Test
    public void t2() throws InstantiationException, IllegalAccessException {
        Student stu = new Student();
        List<Student> studentList = new ArrayList<>();
        studentList.add(stu);
        stu.setSex("19");
        stu.setName("苏杉杉");
        Test3 tt = new Test3<Student>();
        List<Student> list = (List<Student>) tt.convert(studentList,Student.class);
        System.out.println(list.get(0).getName()+list.get(0).getSex());
    }
    private List<? extends Person> convert(List<? extends Person> order,Class<T> requiredType) throws IllegalAccessException, InstantiationException {
        T t = requiredType.newInstance();

        return order;
    }
    @Test
    public void t3() throws ParseException {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        int i = cal.get(Calendar.DAY_OF_MONTH);
//        System.err.println(i);
//
//        // 获取Calendar
//        Calendar calendar = Calendar.getInstance();
//        // 设置时间,当前时间不用设置
//        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
//         int maxDay = calendar.get(Calendar.DAY_OF_MONTH);
//        int i1 = calendar.get(Calendar.DATE);
//        System.out.println(maxDay);
//        System.out.println(i1);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm");
        Date date = sdf.parse("2013-1");
        System.out.println(date);

        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM");
        Date myDate2 = dateFormat2.parse("2010-3");
        System.out.println(myDate2);

        int maxDayByYearMonth = getMaxDayByYearMonth(2017, 8);
        System.err.println(maxDayByYearMonth);

        int i = 1;
        int k = -i;
    }
    public int getMaxDayByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        return calendar.getActualMaximum(Calendar.DATE);
    }
    @Test
    public void test5(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int i = cal.get(Calendar.MONTH)+1;
        int i2 = cal.get(Calendar.YEAR);
        System.err.println(i2);
    }
    @Test
    public void test6(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bb");
        list.add("abc");
        Set<String> set = new HashSet<>();
        set.addAll(list);
        set.size();
        System.err.println(set.size());
    }
    @Test
    public void test7(){
        System.err.println("1111111111111");
        aPrint();
        System.err.println("333333333333");
    }
    private void aPrint(){
        System.out.println("2222222222222");
        return;
    }
    @Test
    public void test8(){
        String a = "001";
        String b = a.substring(a.length() - 3, a.length());

        System.err.println(b);
    }
    @Test
    public void test9(){
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("34343");
//        for(String a : list){
//            if(a.equals("123")){
//                a = "苏杉杉";
//            }
//        }
        for(int i = 0;i< list.size();i++){
            if(list.get(i).equals("123")){
                list.set(i,"苏杉杉");
            }
        }
        System.err.println(list);
    }
    @Test
    public void test10() throws UnsupportedEncodingException {
        String a = "苏杉杉";
        int num = a.getBytes("GBK").length;
        System.err.println(num);
    }
    @Test
    public void test11() throws UnsupportedEncodingException {
        String a = "d苏杉杉";
        int num = a.getBytes("GBK").length;
        System.err.println(num);

    }
    @Test
    public void test12() throws UnsupportedEncodingException {
        String str = "我叫瑞恩，您好！我要做一个字符串截取测试，我的电话是：123456789，你没事可以打给我，我们约会！";
        System.out.println(str.length());
        System.out.println(str.getBytes("GBK").length);

        int len = str.length(), maxLen = 50, temp = 0, i = 0;

        for(; i < len && temp <= maxLen; i++)
        {
            char c = str.charAt(i);
            int charLen = String.valueOf(c).getBytes("GBK").length;
            temp += charLen;
            System.out.println(c + ", index=" + i + ", curentIndex=" + temp);
        }

        str = str.substring(0, i-1);
        System.out.println(str.length());
        System.out.println(str.getBytes().length);
        System.out.println("[" + str + "]");
    }
    @Test
    public void test13() throws UnsupportedEncodingException {
        String str = "我叫瑞恩，您好！我要做一个字符串截取测试，我的电话是：123456789，你没事可以打给我，我们约会！";
        int len  = str.length(), temp = 0, maxLen = 20, i = 0;

        for(; temp <= maxLen && i<len ; i ++){
            char c = str.charAt(i);
            int charLen = String.valueOf(c).getBytes("GBK").length;
            temp += charLen;
        }
        str = str.substring(0, i-1);
        System.err.println(str);
    }
    @Test
    public void test15(){
        String str = "Wed Sep 06 14:13:58 CST 2017";
        Date date = new Date(str);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(date);
        System.out.println(sdf.format(date));
    }

    @Test
    public void test16(){
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("abc");
        list.add("ppp");
        String[] strings = list.toArray(new String[0]);
        System.out.println(strings);
    }
    @Test
    public void test17(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        a.remove(5);
    }
    @Test
    public void test18(){
        dest(()->{

        });
    }
    void dest(com.Bridge.Sourceable sourceable){

    }
    @Test
    public void test19(){
        Map<String,String> map = new HashMap();
        map.put("2","3");

        String o = map.get("2");
        System.out.println(o);

        String p = map.get("3");
        System.out.println(p);
    }
    @Test
    public void test20(){
        Map<Integer, Integer> map = new HashMap();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        Object[] objects = map.values().toArray();
        List<SecurityManager> objects1 = Arrays.asList(map.values().toArray(new SecurityManager[]{}));
        System.err.println( Arrays.asList(map.values().toArray()));
    }
    @Test
    public void test21(){
      String str = "RSTHOT11017000006";
      String regex = "(?<=^RSTH|^RSAC).*";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(str);
      if (matcher.find()){
        System.out.println(matcher.group());
      }
    }
    @Test
    public void test22(){
        System.err.println(String.format("我%s;%s", "你", null));
    }
    @Test
    public void test23(){
        if (1==1){
            System.err.println("1");
        }else if (2==2){
            System.err.println("2");
        }
    }
    @Test
    public void test25(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -3);
        Date time = calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        System.err.println(sdf.format(time));
    }
    @Test
    public void test26(){
        Integer  i = 2;
        String str = "2";
        if (i==Integer.valueOf(str)){
            System.err.println(11111);
        }
    }
    @Test
    public void test27(){
        int[] arr = {2,3,4,5};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.err.println(arr[i]+"----"+arr[j]);
            }
        }
        String[] arr2 = {"sf","sdf","sf","wrf","sfds"};
        System.err.println(String.join(",",arr2));
    }
    @Test
    public void test28(){
        int[] i = {1,3,2,5,6};
        int[] j = {2,5,9};
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(5);
        arr.add(6);
        arr2.add(2);
        arr2.add(5);
        List<Integer> collect = arr.stream().filter(x -> arr2.stream().anyMatch(y -> y==x)).collect(Collectors.toList());
        System.err.println(collect);
    }

    @Test
    public void test29(){
      for (int i = 0; i < 10; i++) {
        System.out.println(i);
        for (int j = 0; j < 5; j++) {
          System.err.println(j);
          if (j==3){
            break;
          }
        }
      }
    }
    @Test
    public void test30(){
        System.out.println(1);
        int i = 0;
        switch (i){
            default:
                break;
        }
        System.out.println(2);
    }
    public void aa(){
        return;
    }
    @Test
    public void test31(){
        int[] i = new int[0];
        i[0] = 2;
        System.err.println(i[0]);
    }
    @Test
    public void test32(){
        BigDecimal bigDecimal = new BigDecimal(BigInteger.ONE);
        System.err.println(bigDecimal.compareTo(BigDecimal.ZERO));
    }
    @Test
    public void test33(){
        Provider provider = new MailSendFactory();
        com(provider);
    }

    public void com(Provider provider){
        this.com1(provider);
        System.err.println("父");
    }
    public void com(MailSendFactory mailSendFactory){
        this.com2(mailSendFactory);
        System.err.println("子");
    }

    public void com1(Provider provider){
        System.err.println("父");
    }
    public void com2(MailSendFactory mailSendFactory){
        System.err.println("子");
    }

    @Test
    public void test36(){
//        HashMap<String,Object> list = new HashMap<>();
//        list.put("123", "aa");
//        list.put("123", "bb");
//        System.err.println(list);
//        String a = "123";
//        String b = "123";
//        System.err.println(Objects.equals(a,b));
//        Set<String> set = list.keySet();
        List<HashMap<String,Object>> list = new ArrayList<>();
//        HashMap<String,Object> all = new HashMap<>();
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("123","abc");
        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("123","ccc");
        list.add(map1);
        list.add(map2);
        //List<Set<String>> sets = list.stream().map(x -> x.keySet()).collect(Collectors.toList());
//        Set<String> key = new HashSet<>();
//        list.forEach(x-> key.addAll(x.keySet()));
       // List<HashMap<String,Object>> ccList = new ArrayList<>();
        HashMap<String,Object> all = new HashMap<>();
        list.forEach(x->all.putAll(x));

        System.err.println(all);
    }
    @Test
    public void test37(){
        String abc = "abc";
        System.err.println(reverse(abc));
    }
    public static String reverse(String str){
        if (str == null || str.length()<=1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }
    @Test
    public void test38(){
        String regex = "[1-9]||[1-2][0-9]||[3][0-1]";
        String i = "1";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(i);
//        boolean matches = matcher.matches();
        for (int j = 0;j<=50;j++){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(String.valueOf(j));
            boolean matches = matcher.matches();
            System.err.println(j+"----------"+String.valueOf(matches));
        }
//        System.err.println(matches);
    }
    @Test
    public void test39(){
        System.err.println(getLastDayOfMonth(2017,2));
    }
    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        int i = cal.get(Calendar.DATE);
        return String.valueOf(i);
    }
    @Test
    public void test41(){
        Vector vector = new Vector();
        Map map = new HashMap();
        Set set = map.keySet();
        System.err.println(set.toString());
    }
    @Test
    public void test42() throws ClassNotFoundException, IllegalAccessException {
        Class<?> aClass = Class.forName("MethodGetName");
        MethodGetName methodGetName = new MethodGetName();
        methodGetName.setName("苏杉杉");
        Class<? extends MethodGetName> aClass1 = methodGetName.getClass();
        Method[] methods = aClass1.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            System.err.println(methodName);
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> clas : parameterTypes) {
                String parameterName = clas.getName();
                String typeName = clas.getTypeName();
                //System.err.println("字段类型"+typeName);
                System.err.println(parameterName);
            }
        }

        Field[] fields = aClass1.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.err.println(field.getName());
            Object o = field.get(methodGetName);
            System.err.println("字段类型"+field.getType().getName());
            System.err.println(o);
        }
    }
    @Test
    public void test43() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        MethodGetName methodGetName = new MethodGetName();
        methodGetName.setName("苏杉杉");
        Class<? extends MethodGetName> methodGetNameClass = methodGetName.getClass();
        Field[] fields = methodGetNameClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = field.get(methodGetName);
            if (o!=null){
                System.err.println(o);
                Class<TagOrder> orderClass = TagOrder.class;
                Method[] methods = orderClass.getDeclaredMethods();
                for (Method method : methods) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    for (Class<?> parameterType : parameterTypes) {
                        if (field.getType().getName().equals(parameterType.getTypeName())){
                            TagOrder tagOrder = orderClass.newInstance();
                            method.invoke(tagOrder,o);
                            System.err.println("相同");
                            return;
                        }
                    }
                }
            }
        }
    }
    @Test
    public void test45(){
        String name = "苏杉杉";
        Object o = name;
        TagOrder tagOrder = new TagOrder();

    }
    @Test
    public void test46() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        MethodGetName methodGetName = new MethodGetName();
        methodGetName.setName("苏杉杉");
        TagOrder tagOrder = new TagOrder();
       addTagLog(methodGetName,  TagOrder.class);
    }
    private void addTagLog(MethodGetName methodGetName, Class tClass)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<? extends MethodGetName> methodGetNameClass = methodGetName.getClass();
        Field[] fields = methodGetNameClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = field.get(methodGetName);
            if (o!=null){
                System.err.println(o);
                //Class<TagOrder> orderClass = TagOrder.class;
                Method[] methods = tClass.getDeclaredMethods();
                for (Method method : methods) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    for (Class<?> parameterType : parameterTypes) {
                        if (field.getType() == parameterType){
                            Object newInstance = tClass.newInstance();
                            method.invoke(newInstance,o);
                            System.err.println("相同");
                            return;
                        }
                    }
                }
            }
        }
    }
    @Test
    public void test48(){
        String a = "苏杉杉";
        String[] b = {"啊啊"};
        String a2 = "苏杉杉";
        String[] b2 = {"啊啊"};
        System.err.println(a.getClass());
        System.err.println(b.getClass());
        MethodGetName m = new MethodGetName();
        MethodGetName m2 = new MethodGetName();
        MethodGetName[] mm = new MethodGetName[2];
        System.err.println(11);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.err.println(methodName);
    }
    @Test
    public void test49(){
        int p = 1;
        switch (p){
            case 1:
                System.err.println("第一");
                break;
            case 2:
                System.err.println("第二");
                break;
        }
        System.err.println(1);
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        System.err.println(methodName);

        System.out.println("------进入methodB----------");
        StackTraceElement elements[] = Thread.currentThread().getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            StackTraceElement stackTraceElement=elements[i];
            String className=stackTraceElement.getClassName();
            String methodName=stackTraceElement.getMethodName();
            String fileName=stackTraceElement.getFileName();
            int lineNumber=stackTraceElement.getLineNumber();
            System.out.println("StackTraceElement数组下标 i="+i+",fileName="
                +fileName+",className="+className+",methodName="+methodName+",lineNumber="+lineNumber);
        }
    }
    @Test
    public void test50() throws InvocationTargetException, IllegalAccessException {
        System.err.println(getMe(new TagOrder(),new MethodGetName()));
    }
    private<T> String getMe(T... ts) throws InvocationTargetException, IllegalAccessException {
        StackTraceElement elements[] = Thread.currentThread().getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            StackTraceElement stackTraceElement=elements[i];
            String className=stackTraceElement.getClassName();
            String methodName=stackTraceElement.getMethodName();
            String fileName=stackTraceElement.getFileName();
            int lineNumber=stackTraceElement.getLineNumber();
            System.out.println("StackTraceElement数组下标 i="+i+",fileName="
                +fileName+",className="+className+",methodName="+methodName+",lineNumber="+lineNumber);
        }
        T t = ts[0];
        System.err.println("-----t1:"+t.getClass());
        T t2 = ts[1];
        System.err.println("-----t2:"+t2.getClass());
        //Method[] methods = this.getClass().getDeclaredMethods();
        //methods[0].invoke("sdf",ts);
        return Thread.currentThread().getStackTrace()[1].getMethodName();

    }
    @Test
    public void test1() throws InterruptedException {
        MethodGetName methodGetName1 = new MethodGetName();
        MethodGetName methodGetName2 = new MethodGetName();
        methodGetName1.start();
        methodGetName2.start();

    }
    @Test
    public void test2(){
        String years = Integer.toString(Calendar.getInstance().get(Calendar.YEAR)).substring(2, 4);
        System.err.println(years);
    }
    @Test
    public void test3(){
        String years = "2565,55l165,56484";
        String regex = "\\d+(,\\d+)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(years);
        boolean matches = matcher.matches();
        System.err.println(matches);
    }
    @Test
    public void test60() throws UnsupportedEncodingException {
        byte[] result = {'r','g'};
        String aa = new String(result);
        System.err.println(aa);
    }
    @Test
    public void test61(){
        String name = "广州市";
        int length = name.length();
        if ("市".equals(name.substring(length-1))){
            name = name.substring(0, length-1);
        }
        System.err.println(name);
    }
    @Test
    public void test62(){

    }
    synchronized static public void bbb() throws InterruptedException {
        System.err.println(Thread.currentThread().getName()+"------"+"bbb");
        Thread.sleep(10000);
        aaa();
    }
    public static void aaa(){
        System.err.println(Thread.currentThread().getName()+"------"+"aaa");
    }
    @Override
    public void run(){
        try {
            bbb();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test70() throws IOException {
        File file = new File("D:\\work\\waybill.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter writer = new PrintWriter(fileWriter);
        writer.println("-----箱号："+3+"----运单号："+6545);
        writer.flush();
        writer.close();
    }
    @Test
    public void test71(){
        int a = 1;
        int b = 2;
        System.err.println($$.eq(a, b));
    }
    @Test
    public void test72(){
        String a = "ø";
        System.err.println(a);
    }
    @Test
    public void test73(){
        Map<String, Employee> map = new HashMap<>();
        Employee employee = new Employee();
        employee.setCount(2);
        employee.setAnnualSalary(1000);
        Employee employee2 = new Employee();
        employee2.setCount(3);
        employee2.setAnnualSalary(11000);
        Employee employee3 = new Employee();
        employee3.setCount(32);
        employee3.setAnnualSalary(50000);
        map.put("hx", employee);
        map.put("tb", employee2);
        map.put("kk", employee3);

        List<Map.Entry<String, Employee>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Employee>>() {
            @Override
            public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
                return -Integer.valueOf(o1.getValue().getAnnualSalary()).compareTo(Integer.valueOf(o2.getValue().getAnnualSalary()));
            }
        });
        System.err.println(list);
    }
    @Test
    public void test75(){
        System.err.println($$.getRandomCharAndNumr(4));
    }
    @Test
    public void test76(){
        long startTime = System.currentTimeMillis();    //获取开始时间

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("D:/userFile.txt"));
            for (int i = 0; i < 10000000; i++) {
                int salary = produceInt(200000,50000);
                int bouns =  produceInt(20000,5000);
                String name = $$.getRandomCharAndNumr(4);
                pw.println(name+","+salary+","+bouns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.close();
        }
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("写入时间：" + (endTime - startTime) + "ms");

        long startReadTime = System.currentTimeMillis();    //获取开始时间

        BufferedReader bur = null;
        String file = "D:/userFile.txt";
        Map<String, Employee> map = new HashMap<>();
        try {
            bur = new BufferedReader(new FileReader(file));
            String str;
            while ((str = bur.readLine())!=null){
                String inName = str.substring(0, 2);
                String salary = str.substring(str.indexOf(",")+1,str.lastIndexOf(","));
                String bounds = str.substring(str.lastIndexOf(",")+1,str.length());
                //System.err.println(inName+"---"+salary+"-----"+bounds);
                int sa = Integer.parseInt(salary);
                int bo = Integer.parseInt(bounds);
                if (map.containsKey(inName)){
                    Employee employee = map.get(inName);
                    employee.setAnnualSalary(employee.getAnnualSalary()+ sa + bo);
                    employee.setCount(employee.getCount()+1);
                }else {
                    Employee employee = new Employee();
                    employee.setAnnualSalary(sa + bo);
                    employee.setCount(1);
                    employee.setInName(inName);
                    map.put(inName,employee);
                }
            }
            long endReadTime = System.currentTimeMillis();    //获取开始时间
            System.out.println("读取和加载数据时间：" + (endReadTime - startReadTime) + "ms");
            //System.err.println(map.values());
            long startSortTime = System.currentTimeMillis();    //获取开始时间
            List<Map.Entry<String, Employee>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Entry<String, Employee>>() {
                @Override
                public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
                    return -Integer.valueOf(o1.getValue().getAnnualSalary()).compareTo(Integer.valueOf(o2.getValue().getAnnualSalary()));
                }
            });
//            System.err.println(list);
            long endSortTime = System.currentTimeMillis();    //获取开始时间
            System.out.println("排序时间：" + (endSortTime - startSortTime) + "ms");
//            int i = 0;
//            for (Entry<String, Employee> stringEmployeeEntry : list) {
//                System.err.println(stringEmployeeEntry.getValue());
//                i++;
//                if (i>100){
//                    break;
//                }
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int produceInt(int max, int min){

        return rand.nextInt(max-min+1)+min;
    }

    @Test
    public void test77() throws InstantiationException, IllegalAccessException {
        long startTime = System.currentTimeMillis();    //获取开始时间

        PrintWriter pw = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos= null;


        String context = "";
        try {
            pw = new PrintWriter(new FileWriter("D:/userFile2.txt"));
            fos=new FileOutputStream("D:/userFile2.txt");
            bos=new BufferedOutputStream(fos);

            for (int i = 0; i < 2000; i++) {
                Random rand = new Random();
                int salary = rand.nextInt(200000-50000+1)+50000;
                int bouns = rand.nextInt(20000-5000+1)+5000;
                String name = $$.getRandomCharAndNumr(4);
                //pw.println(name+","+salary+","+bouns);

                context= context + name+","+salary+','+bouns+"\r\n";

            }
          byte[] contextBytes = context.getBytes();
          Byte b[] = new Byte[contextBytes.length];

          for (int i = 0; i < contextBytes.length; i++) {
            b[i] = contextBytes[i];
          }

//          Integer arr1[] = { 1, 2, 3, 4, 5, 6, 7 };
          List<Byte[]> bytes1 = convert5(b, 1024);

          List<byte[]> bytes2 = new ArrayList<>();

          List<Byte[]> list = new ArrayList<>();

          for (int i = 0; i < bytes1.size(); i++) {
            Object[] objects =  bytes1.get(i);
            Byte[] kk = new Byte[objects.length];
            for (int i1 = 0; i1 < objects.length; i1++) {
              kk[i1] = (Byte)objects[i1];
            }
           list.add(kk);

          }

          for (int i = 0; i < list.size(); i++) {
            byte[] bb= new byte[list.get(i).length];
            for (int i1 = 0; i1 < list.get(i).length; i1++) {
              bb[i1] = list.get(i)[i1];
            }
            bytes2.add(bb);
          }


//          for (Byte[] bytes3 : bytes1) {
//            byte[] bb = new byte[bytes3.length];
//            for (int i = 0; i < bytes3.length; i++) {
//              bb[i] = bytes3[i];
//            }
//            bytes2.add(bb);
//          }

//          List<byte[]> list = convert(context.getBytes(), 1024);

            for (byte[] bytes : bytes2) {
              bos.write(bytes,0,bytes.length);
            }

            bos.flush();
            bos.close();
            //pw.println(context);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("写入时间：" + (endTime - startTime) + "ms");

        long startReadTime = System.currentTimeMillis();    //获取开始时间

        BufferedReader bur = null;
        String file = "D:/userFile.txt";
        Map<String, Employee> map = new HashMap<>();
        try {
            bur = new BufferedReader(new FileReader(file));
            String str;
            while ((str = bur.readLine())!=null){
                String inName = str.substring(0, 2);
                String salary = str.substring(str.indexOf(",")+1,str.lastIndexOf(","));
                String bounds = str.substring(str.lastIndexOf(",")+1,str.length());
                //System.err.println(inName+"---"+salary+"-----"+bounds);
                int sa = Integer.parseInt(salary);
                int bo = Integer.parseInt(bounds);
                if (map.containsKey(inName)){
                    Employee employee = map.get(inName);
                    employee.setAnnualSalary(employee.getAnnualSalary()+ sa + bo);
                    employee.setCount(employee.getCount()+1);
                }else {
                    Employee employee = new Employee();
                    employee.setAnnualSalary(sa + bo);
                    employee.setCount(1);
                    employee.setInName(inName);
                    map.put(inName,employee);
                }
            }
            long endReadTime = System.currentTimeMillis();    //获取开始时间
            System.out.println("读取和加载数据时间：" + (endReadTime - startReadTime) + "ms");
            //System.err.println(map.values());
            long startSortTime = System.currentTimeMillis();    //获取开始时间
            List<Map.Entry<String, Employee>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Entry<String, Employee>>() {
                @Override
                public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
                    return -Integer.valueOf(o1.getValue().getAnnualSalary()).compareTo(Integer.valueOf(o2.getValue().getAnnualSalary()));
                }
            });
            // System.err.println(list);
            long endSortTime = System.currentTimeMillis();    //获取开始时间
            System.out.println("排序时间：" + (endSortTime - startSortTime) + "ms");
            int i = 0;
            for (Entry<String, Employee> stringEmployeeEntry : list) {
                System.err.println(stringEmployeeEntry.getValue());
                i++;
                if (i>100){
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  @Test
  public void test78(){
    long startTime = System.currentTimeMillis();    //获取开始时间

    PrintWriter pw = null;
    FileOutputStream fos = null;
    BufferedOutputStream bos= null;

    OutputStreamWriter writer = null;
    BufferedWriter bw = null;

    String context = "";
    try {
      pw = new PrintWriter(new FileWriter("D:/userFile2.txt"));
      fos=new FileOutputStream("D:/userFile2.txt");
      bos=new BufferedOutputStream(fos);

      OutputStream os = new FileOutputStream("D:/userFile2.txt");
      writer = new OutputStreamWriter(os);
      bw = new BufferedWriter(writer);

      for (int i = 0; i < 2000; i++) {
        Random rand = new Random();
        int salary = rand.nextInt(200000-50000+1)+50000;
        int bouns = rand.nextInt(20000-5000+1)+5000;
        String name = $$.getRandomCharAndNumr(4);
        //pw.println(name+","+salary+","+bouns);

        context= context + name+","+salary+','+bouns+"\r\n";

      }

      bw.write(context);
      bw.flush();
      //pw.println(context);
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      pw.close();
    }
    long endTime = System.currentTimeMillis();    //获取结束时间

    System.out.println("写入时间：" + (endTime - startTime) + "ms");

    long startReadTime = System.currentTimeMillis();    //获取开始时间

    BufferedReader bur = null;
    String file = "D:/userFile.txt";
    Map<String, Employee> map = new HashMap<>();
    try {
      bur = new BufferedReader(new FileReader(file));
      String str;
      while ((str = bur.readLine())!=null){
        String inName = str.substring(0, 2);
        String salary = str.substring(str.indexOf(",")+1,str.lastIndexOf(","));
        String bounds = str.substring(str.lastIndexOf(",")+1,str.length());
        //System.err.println(inName+"---"+salary+"-----"+bounds);
        int sa = Integer.parseInt(salary);
        int bo = Integer.parseInt(bounds);
        if (map.containsKey(inName)){
          Employee employee = map.get(inName);
          employee.setAnnualSalary(employee.getAnnualSalary()+ sa + bo);
          employee.setCount(employee.getCount()+1);
        }else {
          Employee employee = new Employee();
          employee.setAnnualSalary(sa + bo);
          employee.setCount(1);
          employee.setInName(inName);
          map.put(inName,employee);
        }
      }
      long endReadTime = System.currentTimeMillis();    //获取开始时间
      System.out.println("读取和加载数据时间：" + (endReadTime - startReadTime) + "ms");
      //System.err.println(map.values());
      long startSortTime = System.currentTimeMillis();    //获取开始时间
      List<Map.Entry<String, Employee>> list = new ArrayList<>(map.entrySet());
      Collections.sort(list, new Comparator<Entry<String, Employee>>() {
        @Override
        public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
          return -Integer.valueOf(o1.getValue().getAnnualSalary()).compareTo(Integer.valueOf(o2.getValue().getAnnualSalary()));
        }
      });
      // System.err.println(list);
      long endSortTime = System.currentTimeMillis();    //获取开始时间
      System.out.println("排序时间：" + (endSortTime - startSortTime) + "ms");
      int i = 0;
      for (Entry<String, Employee> stringEmployeeEntry : list) {
        System.err.println(stringEmployeeEntry.getValue());
        i++;
        if (i>100){
          break;
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    private List<byte[]> convert(byte[] b, int len){

        List<byte[]> list = new ArrayList<>();
        if (b.length < len){
            list.add(b);
            return list;
        }
        int l = b.length / len == 0? b.length / len : (b.length / len) +1;

        for (int i = 0; i < l; i++) {
          if (i < l -1){
            byte[] bb = new byte[len];
            for (int j = 0; j < len; j++) {
              bb[j] = b[j + i * len];
            }
            list.add(bb);
          }
          if (i == l-1){
            int len1 = b.length - (len * (b.length / len));
            int startLen = b.length - len1;
            byte[] bb = new byte[len1];
            int p = 0;
            for (int j = startLen; j < b.length; j++) {
              bb[p] = b[j];
              p++;
            }
            list.add(bb);
          }
        }

        return list;
    }


  public  <T> List<T[]> convert2(T[] b, int len) throws IllegalAccessException, InstantiationException {

    List<T[]> list = new ArrayList<>();
    if (b.length < len){
      list.add(b);
      return list;
    }
    int l = b.length / len == 0? b.length / len : (b.length / len) +1;

    for (int i = 0; i < l; i++) {
      if (i < l -1){

        T[] bb = (T[]) new Object[len];

        for (int j = 0; j < len; j++) {
          bb[j] = b[j + i * len];
        }
        list.add(bb);
      }
      if (i == l-1){
        int len1 = b.length - (len * (b.length / len));
        int startLen = b.length - len1;
        T[] bb = (T[]) new Object[len1];
        int p = 0;
        for (int j = startLen; j < b.length; j++) {
          bb[p] = b[j];
          p++;
        }
        list.add(bb);
      }
    }

    return list;
  }

  @SuppressWarnings("unchecked")
  private <T> List<Object[]> convert3(Object[] b,int len) throws IllegalAccessException, InstantiationException {

    List<Object[]> list = new ArrayList<>();
    if (b.length < len){
      list.add(b);
      return (List) list;
    }
    int l = b.length / len == 0? b.length / len : (b.length / len) +1;

    for (int i = 0; i < l; i++) {
      if (i < l -1){

        Object[] bb =  new Object[len];

        for (int j = 0; j < len; j++) {
          bb[j] = b[j + i * len];
        }
        list.add(bb);
      }
      if (i == l-1){
        int len1 = b.length - (1024 * (b.length / len));
        int startLen = b.length - len1;
        Object[] bb = new Object[len1];
        int p = 0;
        for (int j = startLen; j < b.length; j++) {
          bb[p] = b[j];
          p++;
        }
        list.add(bb);
      }
    }

    return  list;
  }
    @Test
    public void test79(){
        byte[] a = new byte[200000];
        for (int i = 0; i < 1025; i++) {

        }
        for (byte b : a) {
            System.err.println(b);
        }
    }


  @SuppressWarnings("unchecked")
  public <T> void test2(T[] a) {
    T[] b = (T[]) new Object[a.length];
    for (int i = 0; i < a.length; i++) {
      b[i] = a[i];
    }

    for (int i = 0; i < b.length; i++) {
      System.out.println(b[i]);
    }
  }
  @Test
  public void test80() throws InstantiationException, IllegalAccessException {
    System.err.println(6/5);
    Integer arr1[] = { 1, 2, 3, 4, 5, 6, 7 };
    List<Integer[]> integers = dianDao(arr1, 3);
    System.out.println();
    Byte[] arr2 = {2,3,4,5,6,};
    List<Byte[]> bytes = dianDao(arr2, 3);
    convert2(arr1,3);
  }

  public <T> List<T[]> dianDao(T[] b, int len){
    List<T[]> list = new ArrayList<>();
    if (b.length < len){
      list.add(b);
      return list;
    }
    int l = b.length / len == 0? b.length / len : (b.length / len) +1;

    for (int i = 0; i < l; i++) {
      if (i < l -1){

        T[] bb = (T[]) new Object[len];

        for (int j = 0; j < len; j++) {
          bb[j] = b[j + i * len];
        }
        list.add(bb);
      }
      if (i == l-1){
        int len1 = b.length - (len * (b.length / len));
        int startLen = b.length - len1;
        T[] bb = (T[]) new Object[len1];
        int p = 0;
        for (int j = startLen; j < b.length; j++) {
          bb[p] = b[j];
          p++;
        }
        list.add(bb);
      }
    }

    return list;
  }

  public  <T> List<T[]> convert5(T[] b, int len) throws IllegalAccessException, InstantiationException {

    List<T[]> list = new ArrayList<>();
    if (b.length < len){
      list.add(b);
      return list;
    }
    int l = b.length / len == 0? b.length / len : (b.length / len) +1;

    for (int i = 0; i < l; i++) {
      if (i < l -1){

//        T[] bb = (T[]) new Object[len];

        Object o = Array.newInstance(b.getClass(), len);

        for (int j = 0; j < len; j++) {
//          bb[j] = b[j + i * len];
         Array.set(o, j, b[j + i * len]);
        }
//        list.add(bb);
        list.add((T[]) o);
      }
      if (i == l-1){
        int len1 = b.length - (len * (b.length / len));
        int startLen = b.length - len1;
//        T[] bb = (T[]) new Object[len1];
        Object o = Array.newInstance(b.getClass(), len1);
        int p = 0;
        for (int j = startLen; j < b.length; j++) {
//          bb[p] = b[j];
          Array.set(o, p,  b[j]);
          p++;
        }
        list.add((T[])o);
      }
    }

    return list;
  }

  public  <T> List<T[]> convert6(T[] b, int len) throws IllegalAccessException, InstantiationException {

    List<T[]> list = new ArrayList<>();
    if (b.length < len){
      list.add(b);
      return list;
    }
    int l = b.length / len == 0? b.length / len : (b.length / len) +1;

    for (int i = 0; i < l; i++) {
      if (i < l -1){

        Object[] bb = new Object[len];

        for (int j = 0; j < len; j++) {
          bb[j] = b[j + i * len];
        }
        T[] by = (T[]) Array.newInstance(b.getClass().getComponentType(), len);

        for (int i1 = 0; i1 < by.length; i1++) {
          by[i1] = (T)bb[i1];
        }

        list.add(by);
      }
      if (i == l-1){
        int len1 = b.length - (len * (b.length / len));
        int startLen = b.length - len1;
        Object[] bb =  new Object[len1];
        int p = 0;
        for (int j = startLen; j < b.length; j++) {
          bb[p] = b[j];
          p++;
        }
        T[] bp = (T[]) Array.newInstance(b.getClass().getComponentType(), len1);

        for (int i1 = 0; i1 < bp.length; i1++) {
          bp[i1] = (T)bb[i1];
        }

        list.add(bp);
      }
    }

    return list;
  }

  @Test
  public void test82() throws InstantiationException, IllegalAccessException {
    long startTime = System.currentTimeMillis();    //获取开始时间

    PrintWriter pw = null;
    FileOutputStream fos = null;
    BufferedOutputStream bos= null;


    String context = "";

    StringBuilder sb = new StringBuilder();

    try {
      pw = new PrintWriter(new FileWriter("D:/userFile2.txt"));
      fos=new FileOutputStream("D:/userFile2.txt");
      bos=new BufferedOutputStream(fos);

      int num = 10000000;

      for (int k = 0; k < num; k++)  {
        Random rand = new Random();
        int salary = rand.nextInt(200000-50000+1)+50000;
        int bouns = rand.nextInt(20000-5000+1)+5000;
        String name = $$.getRandomCharAndNumr(4);
        //pw.println(name+","+salary+","+bouns);
          sb.append(name+","+salary+','+bouns+"\r\n");
          if (num < 500 || (k!=0 && k %100000==0) || k == num - 1){

              byte[] contextBytes = sb.toString().getBytes();
              Byte b[] = new Byte[contextBytes.length];

              for (int i = 0; i < contextBytes.length; i++) {
                  b[i] = contextBytes[i];
              }

//          Integer arr1[] = { 1, 2, 3, 4, 5, 6, 7 };
              List<Byte[]> bytes1 = convert6(b, 50000);

              List<byte[]> bytes2 = new ArrayList<>();

              List<Byte[]> list = new ArrayList<>();

              for (int i = 0; i < bytes1.size(); i++) {

                  Byte[] bytes = bytes1.get(i);
                  //System.err.println(bytes);
                  Object[] objects =  bytes1.get(i);
                  Byte[] kk = new Byte[objects.length];
                  for (int i1 = 0; i1 < objects.length; i1++) {
                      kk[i1] = (Byte)objects[i1];
                  }
                  list.add(kk);

              }

              for (int i = 0; i < list.size(); i++) {
                  byte[] bb= new byte[list.get(i).length];
                  for (int i1 = 0; i1 < list.get(i).length; i1++) {
                      bb[i1] = list.get(i)[i1];
                  }
                  bytes2.add(bb);
              }


//          for (Byte[] bytes3 : bytes1) {
//            byte[] bb = new byte[bytes3.length];
//            for (int i = 0; i < bytes3.length; i++) {
//              bb[i] = bytes3[i];
//            }
//            bytes2.add(bb);
//          }

//          List<byte[]> list = convert(context.getBytes(), 1024);

              for (byte[] bytes : bytes2) {
                  fos.write(bytes,0,bytes.length);
              }



              //pw.println(context);

              sb = new StringBuilder();
          }
//        context= context + name+","+salary+','+bouns+"\r\n";


      }
        fos.flush();
        fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      pw.close();
    }
    long endTime = System.currentTimeMillis();    //获取结束时间

    System.out.println("写入时间：" + (endTime - startTime) + "ms");

    long startReadTime = System.currentTimeMillis();    //获取开始时间

    BufferedReader bur = null;
    String file = "D:/userFile.txt";
    Map<String, Employee> map = new HashMap<>();
    try {
      bur = new BufferedReader(new FileReader(file));
      String str;
      while ((str = bur.readLine())!=null){
        String inName = str.substring(0, 2);
        String salary = str.substring(str.indexOf(",")+1,str.lastIndexOf(","));
        String bounds = str.substring(str.lastIndexOf(",")+1,str.length());
        //System.err.println(inName+"---"+salary+"-----"+bounds);
        int sa = Integer.parseInt(salary);
        int bo = Integer.parseInt(bounds);
        if (map.containsKey(inName)){
          Employee employee = map.get(inName);
          employee.setAnnualSalary(employee.getAnnualSalary()+ sa + bo);
          employee.setCount(employee.getCount()+1);
        }else {
          Employee employee = new Employee();
          employee.setAnnualSalary(sa + bo);
          employee.setCount(1);
          employee.setInName(inName);
          map.put(inName,employee);
        }
      }
      long endReadTime = System.currentTimeMillis();    //获取开始时间
      System.out.println("读取和加载数据时间：" + (endReadTime - startReadTime) + "ms");
      //System.err.println(map.values());
      long startSortTime = System.currentTimeMillis();    //获取开始时间
      List<Map.Entry<String, Employee>> list = new ArrayList<>(map.entrySet());
      Collections.sort(list, new Comparator<Entry<String, Employee>>() {
        @Override
        public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
          return -Integer.valueOf(o1.getValue().getAnnualSalary()).compareTo(Integer.valueOf(o2.getValue().getAnnualSalary()));
        }
      });
      // System.err.println(list);
      long endSortTime = System.currentTimeMillis();    //获取开始时间
      System.out.println("排序时间：" + (endSortTime - startSortTime) + "ms");
      int i = 0;
      for (Entry<String, Employee> stringEmployeeEntry : list) {
        System.err.println(stringEmployeeEntry.getValue());
        i++;
        if (i>100){
          break;
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
    @Test
    public void test83(){
        long startTime = System.currentTimeMillis();    //获取开始时间

        FileInputStream fis=null;
        FileOutputStream fos=null;
        try
        {
            File f1=new File("D:/userFile.txt");
            File f2=new File("D:/userFile3.txt");

            fis=new FileInputStream(f1);
            fos=new FileOutputStream(f2);

            byte[] bs=new byte[50000];
            Date d=new Date();
            int i;
            System.out.println("不带缓冲的 50000B 开始："+d.toString());
            while((i=fis.read(bs))!=-1)
            {
                fos.write(bs,0,i);
            }
            Date d2=new Date();
            System.out.println("不带缓冲的 50000B 结束："+d2.toString());
            long endTime = System.currentTimeMillis();    //获取结束时间

            System.out.println("写入时间：" + (endTime - startTime) + "ms");

        }catch(IOException ex)
        {
            System.out.println(ex);
        }finally
        {
            try{
                fis.close();
                fos.close();
            }catch(IOException ex)
            {
                System.out.println(ex);
            }
        }
    }
    private static boolean isChineseByBlock(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C//jdk1.7
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D//jdk1.7
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) {
            return true;
        }
        return false;
    }

    // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChineseByBlock(c)) {
                return false;
            }
        }
        return true;
    }
    public static String chineseOrEnglise(String str){
        if (isChinese(str)){
            return "中文";
        }
        boolean matches = str.matches("[a-zA-Z]+");
        if (matches){
            return "英文";
        }

        return "既不是中文也不是英文或者既有英文也有中文";
    }
    @Test
    public void testz1(){
        System.err.println(chineseOrEnglise("曾大神迟到了"));
    }
    @Test
    public void test111(){
        System.err.println(BigDecimal.ONE.add(BigDecimal.ONE));
    }

    @Test
    public void test222(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
//        list.add("c");
//        list.add("d");
        System.err.println(list.subList(0,3));
    }
    @Test
    public void test99() throws InstantiationException, IllegalAccessException {
        Employee employee = test112(Employee.class);
        System.err.println(employee);
        Employee employee2 = test112(Employee.class);
        System.err.println(employee==employee2);
    }

    public <T extends PersonK, K extends PersonK> T test112(Class<T> tClass, K k) throws Exception {
        T t = tClass.newInstance();
        t.setInName("苏杉杉");
        t.setCount(333);
        t.setAnnualSalary(3333333);
        k.getAnnualSalary();
        return t;
    }
    public <T extends PersonK> T test112(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        t.setInName("苏杉杉");
        t.setCount(333);
        t.setAnnualSalary(3333333);
        return t;
    }
    @Test
    public void testX(){
        int x = 584625*557474/34645654+345345-23434+Math.abs(-11111)-Math.abs(-333005);
        System.err.println(x);
    }
    @Test
    public void test100(){
        int i = 200;
        Integer integer = new Integer(200);
        System.err.print(integer == new Integer(200));
        System.err.println(integer.toString());

        List a = new ArrayList();
        //new ArrayList<String>().forEach(x -> x.equals("a")?a.add(x):a.add(x));
    }
    @Test
    public void test101(){
        String s = "单号：{{code}}";
        String newCode = s.replace("{{code}}", "newCode");
        System.err.println(newCode);
    }
    @Test
    public void test102(){
        String str = "acccddda";
        String replace = str.replace("a", "k");
        System.err.println(replace);
    }
    @Test
    public void test103(){
        TestStaticMethod.test1();

        String name = "黄俊能";
        TestStaticMethod testStaticMethod = new TestStaticMethod() {

            @Override
            public void test3(String name) {
                System.err.println(name+"是大神");
            }
        };
        testStaticMethod.test();

        TestStaticMethod testStaticMethod2 = (String name2)->{
            System.err.println(name2+"是大神");
        };
        testStaticMethod.test3(name);
        testStaticMethod2.test3(name);
    }

    @Test
    public void test105(){
//        List<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("789");
//        list.forEach(x->{
//
//            System.err.println(x);
//
//        });
        ByteArrayOutputStream baos = null;
        OutputStream b64os = null;

        String encodeId;

        byte[] bytes = "2".getBytes();
        try {
            baos = new ByteArrayOutputStream();
            b64os = MimeUtility.encode(baos, "base64");
            try {
               b64os.write(bytes);
               System.err.println(baos.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test106() throws UnsupportedEncodingException {
        String base64 = URLEncoder.encode("base64","utf-8");
        System.err.println(base64);
        URLDecoder.decode("base64", base64);
    }
    @Test
    public void test107(){
        int index = 36;
        String result = "";
        if (index < 10) {
            result ="0000"+index;
        }
        if (index >= 10 && index < 100) {
            result ="000"+index;
        }
        if (index >= 100 && index < 1000) {
            result ="00"+index;
        }
        if (index >=1000 && index < 10000){
            result = "0"+ index;
        }

        System.err.println(result);
    }
    @Test
    public void test108(){
        List list = new ArrayList();
        list.add(3);
        list.add(5);
        list.add(6);
        list.forEach(System.err::println);
    }
    @Test
    public void test109(){
        String regex="[1-9]||[1][0]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("0");
        if (matcher.matches()){
            System.err.println("正确");
        }
    }

    @Test
    public void test110(){
        String str = "刘浩文系度睇电影，增大神系度沟女";

        String regex = "刘浩文|增大神";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String group = matcher.group();
            System.err.println(group);
        }

    }
}
