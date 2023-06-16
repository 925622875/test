package com.zhu.test;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2023-05-12 18:43
 */
public class TextFileSys {

    HashMap<String,String[]> file = new HashMap<>();

    public TextFileSys(){

    }

    int open(String filename,String mode){


        switch (mode) {
            case "r":{
                if (!file.containsKey(filename)){
                    return -1;
                }
                String[] strings = file.get(filename);
                if(strings[1].equals("1")){
                    return -1;
                }
                strings[1] = "1";
                strings[2] = "0";
                strings[3] = "y";
                strings[4] = "n";
                return 0;
            }
            case "r+":{
                if (!file.containsKey(filename)){
                    return -1;
                }
                String[] strings = file.get(filename);
                if(strings[1].equals("1")){
                    return -1;
                }
                strings[1] = "1";
                strings[2] = "0";
                strings[3] = "y";
                strings[4] = "y";
                return 0;
            }
            case "w":{
                if (!file.containsKey(filename)){
                    String[] strings = new String[5];
                    strings[0] = "";
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "n";
                    strings[4] = "y";
                    file.put(filename,strings);
                    return 0;
                }else{
                    String[] strings = file.get(filename);
                    if (strings[1].equals("1")){
                        return -1;
                    }
                    strings[0] = "";
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "n";
                    strings[4] = "y";
                    return 0;
                }
            }
            case "w+":{
                if (!file.containsKey(filename)){
                    String[] strings = new String[5];
                    strings[0] = "";
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "y";
                    strings[4] = "y";
                    file.put(filename,strings);
                    return 0;
                }else{
                    String[] strings = file.get(filename);
                    if (strings[1].equals("1")){
                        return -1;
                    }
                    strings[0] = "";
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "y";
                    strings[4] = "y";
                    return 0;
                }
            }
            case "a":{
                if (!file.containsKey(filename)){
                    String[] strings = new String[5];
                    strings[0] = "";
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "n";
                    strings[4] = "y";
                    file.put(filename,strings);
                    return 0;
                }else{
                    String[] strings = file.get(filename);
                    if (strings[1].equals("1")){
                        return -1;
                    }
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "n";
                    strings[4] = "y";
                    return 0;
                }
            }
            case "a+":{
                if (!file.containsKey(filename)){
                    String[] strings = new String[5];
                    strings[0] = "";
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "y";
                    strings[4] = "y";
                    file.put(filename,strings);
                    return 0;
                }else{
                    String[] strings = file.get(filename);
                    if (strings[1].equals("1")){
                        return -1;
                    }
                    strings[1] = "1";
                    strings[2] = "1";
                    strings[3] = "y";
                    strings[4] = "y";
                    return 0;
                }
            }

        }
        return -1;
    }

    int close(String filename){
        if (!file.containsKey(filename)){
            return -1;
        }
        String[] strings = file.get(filename);
        if (strings[1].equals("1")){
            strings[1] = "0";
            return 0;
        }
        return -1;
    }

    int write(String filename,String content){
        if (!file.containsKey(filename)){
            return -1;
        }
        String[] strings = file.get(filename);
        if (strings[1].equals("1") && strings[4].equals("y")){
            if (strings[2].equals("0")){
                strings[0] = content + strings[0];
            }else{
                strings[0] = strings[0] + content;
            }
            strings[2] = "1";
            return strings[0].length();
        }
        return -1;
    }

    String readALL(String filename){
        if (!file.containsKey(filename)){
            return "error";
        }
        String[] strings = file.get(filename);
        if (strings[1].equals("1") && strings[3].equals("y")){
            if (strings[0].length() == 0){
                return null;
            }else{
                return strings[0];
            }
        }
        return "error";
    }
}
