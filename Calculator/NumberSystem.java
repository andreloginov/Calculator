public enum NumberSystem {
    ROMAN("ROMAN"), ARABIC("ARABIC");
    private String name;
    NumberSystem(String name){
        this.name = name;
    }
    public String getName(){
        return this.name();
    }


}
