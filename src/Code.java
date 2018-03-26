import java.io.*;
import java.util.*;

public class Code {
    public Map<String, String> map = new HashMap<String, String>();

    Code(String str, File f, Boolean bool) throws Exception {
        if(f.exists()){
            System.out.println("该文件已存在,将读取内容！");
        }else {
            writeFile(f, str);
        }
        readFile(f, bool);
    }

    private void writeFile(File f, String fileContent) throws IOException {
        FileOutputStream fop = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append(fileContent);
        writer.close();
        fop.close();
        System.out.println("文件创建成功");
    }

    private void readFile(File f, Boolean bool) throws Exception {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        while (line != null) {
            line = br.readLine();
            if(line != null) {
                map(line, map, bool);
            }
        }
    }

    private void map(String str, Map map, Boolean bool) throws Exception {
        String[] arr = str.split(" ");
        if(map.containsKey(arr[0])){
         throw new Exception();
        }else{
            if(bool){
                map.put(arr[0], arr[1]);
            }else{
                map.put(arr[1], arr[0]);
            }
        }
    }

    private void encrypt(Map map, String str){
        String s = "";
        for (int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            s += (map.get(Character.toString(ch)) == null)?Character.toString(ch):map.get(Character.toString(ch));
        }
        System.out.println("加密后的文本：" + s);
    }

    private void decrypt(Map map, String str){
        String s = "";
        for (int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            s += (map.get(Character.toString(ch)) == null)?Character.toString(ch):map.get(Character.toString(ch));
        }
        System.out.println("解密后的文本：" + s);
    }

    public void output(Map<String, String> parameters){

        for (String string:parameters.keySet()) {
            System.out.println(string + "-->" + parameters.get(string));
        }
    }

    public static void main(String[] args) throws Exception {
        do{
            System.out.println("输入要执行的操作是加密还是解密，1代表加密0代表解密！");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            boolean bool = (option == 1)?true:false;
            File f = new File("D:/mapping.txt");
            Code a = new Code("a A\r\nb B\r\nT c\r\nH d", f, bool);
            a.output(a.map);//打印map
            if ((bool == true)) {
                System.out.println("请输入要加密的文本：");
                Scanner input1 = new Scanner(System.in);
                String str = input1.nextLine();
                a.encrypt(a.map, str);
            } else {
                System.out.println("请输入要解密的文本：");
                Scanner input1 = new Scanner(System.in);
                String str = input1.nextLine();
                a.decrypt(a.map, str);
            }
        }while(true);
    }
}
