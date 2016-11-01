import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class MapTest2{
  public static void main(String[] args)throws IOException{
     String content = readFile(".\\poem.txt");
     StringBuilder sbuilder = new StringBuilder();

     Map<Integer, String> tmap = new TreeMap<Integer, String>();
     Map<Character, Integer> hmap = new HashMap<Character, Integer>();
     //把字符串转化为数组
     char[] s = content.toCharArray();
     //向映射中添加数据
     for(int i = 0; i < s.length; i ++){
       char s1 = s[i];
       int t = 0;
       for(int j = 0; j < s.length; j ++){
         if(s1 == s[j]) t++;
         hmap.put(s1, t);//向map中放入键值
       }
     }
     
     //遍历 
     Set<Character> hkey = hmap.keySet();//得到键值的set集合
     Iterator<Character> iter = hkey.iterator();
     while(iter.hasNext()){
       char key = iter.next();
       int value = hmap.get(key);
       String sva = tmap.get(value);
       if(sva == null)
          sva = "";
       sva = sva + String.valueOf(key) + ";";
       tmap.put(value, sva);
     }
    
     Set<Integer> tkey = tmap.keySet();
     Iterator<Integer> iter1 = tkey.iterator();
     while(iter1.hasNext()){
       int times = iter1.next();
       String cont = tmap.get(times);
       String[] new_cont = cont.split(";");
       for(int i = 0; i < new_cont.length; i ++){
          sbuilder.insert(0, "字符:"+new_cont[i]+"  "+"次数:"+String.valueOf(times)+"\n");
       }
       sbuilder.append('\n');
     }
     System.out.printf("%s", sbuilder);
  }

  static String readFile(String fileName) throws IOException{
    	StringBuilder sb = new StringBuilder("");
        String s1="";
      int c1;
      FileInputStream f1= new FileInputStream(fileName);		
      InputStreamReader in = new InputStreamReader(f1, "UTF-8");

      while ((c1 = in.read()) != -1) {
        sb.append((char) c1);
      }        
        return sb.toString();
  }
}
