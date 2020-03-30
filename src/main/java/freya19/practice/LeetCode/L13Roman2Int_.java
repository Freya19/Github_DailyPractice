package freya19.practice.LeetCode;

public class L13Roman2Int_ {
    public int roman2Int(String roms){
        if(roms==null||roms.length()==0) return 0;

        int ret = 0;
        if(roms.contains("CM")) ret-=200; //视频中用的是roms.indexOf("CM")!=-1作为判断条件的，编译器推荐用contains
        if(roms.contains("CD")) ret-=200;
        if(roms.contains("XC")) ret-=20;
        if(roms.contains("XL")) ret-=20;
        if(roms.contains("IX")) ret-=2;
        if(roms.contains("IV")) ret-=2;

        for(char c:roms.toCharArray()){  // 字符是 ' ' 单引号括起来的
            if(c =='M') ret += 1000;
            else if(c =='D') ret += 500;
            else if(c =='C') ret += 100;
            else if(c =='L') ret += 50;
            else if(c =='X') ret += 10;
            else if(c =='V') ret += 5;
            else if(c =='I') ret += 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        String r = "CMXLIX";

        L13Roman2Int_ rom = new L13Roman2Int_();
        System.out.println(rom.roman2Int(r));

    }
}
