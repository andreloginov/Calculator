public enum RomanToArabic {

    I("I", 1), II("II", 2), III("III", 3), IV("IV", 4),
    V("V", 5), VI("VI", 6), VII("VII", 7), VIII("VIII", 8),
    IX("IX", 9), X("X", 10), XX("XX", 20), XXX("XXX", 30), XL("XL", 40),
    L("L", 50), LX("LX", 60), LXX("LXX", 70), LXXX("LXXX", 80),
    XC("XC", 90), C("C", 100);

    private final String roman;
    private final int arabic;
    RomanToArabic(String roman, int arabic) {
        this.roman = roman;
        this.arabic = arabic;
    }

    public String getRoman(){
        return this.roman;
    }
    public int getArabic(){
        return this.arabic;
    }

    public int toArabic(String roman){
        for (RomanToArabic obj : this.values()){
            if (obj.getRoman().equals(roman)){
                return obj.getArabic();
            }
        }

        return 0;
    }

    public String toRoman(int romanSum){
        for (RomanToArabic obj : this.values()){
            if (obj.getArabic() == romanSum){
                return obj.getRoman();
            }
        }
        return null;
    }

    /*public StringBuilder split(int romanSum){
        StringBuilder translated = new StringBuilder();
        if (romanSum%10 != 0 || romanSum>10){
            if (romanSum<=0){
                System.out.println("Прекращена работы программы. Не может быть отрицательных числе в римской системе.");
            }
            int a = 10;
            while (romanSum >= a){
                a *=10;
            }
            a = a/10;
            int remain = romanSum%a;
            int romanSum1 = romanSum;
            romanSum -= remain;

            translated.append(this.toRoman(romanSum));
            if (remain == 0){
                System.out.println("От изначальной цифры "+ romanSum+", получили целую : "+romanSum1+". Остаток: "+ remain);
                return translated;
            }
            System.out.println("От изначальной цифры "+ romanSum+", получили целую : "+romanSum1+". Остаток: "+ remain);
            return split(remain);
        }
        else {
            return translated.append(toRoman(romanSum));
        }
    }*/

}
