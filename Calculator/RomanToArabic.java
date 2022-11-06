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

    public String getRoman() {
        return this.roman;
    }

    public int getArabic() {
        return this.arabic;
    }

    public int toArabic(String roman) {
        for (RomanToArabic obj : RomanToArabic.values()) {
            if (obj.getRoman().equals(roman)) {
                return obj.getArabic();
            }
        }

        try {
            Integer.parseInt(roman);
            return 0;
        } catch (NumberFormatException e) {
            throw new RuntimeException("т.к строка не является математической операцией.");
        }
    }

    public String toRoman(int romanSum) {
        for (RomanToArabic obj : RomanToArabic.values()) {
            if (obj.getArabic() == romanSum) {
                return obj.getRoman();
            }
        }
        return null;
    }
}