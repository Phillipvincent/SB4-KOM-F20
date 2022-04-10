package dk.sdu.mmmi.cbse.asteroidsystem;

public enum AsteroidType {
    Large("LARGE"),
    MEDIUM("MEDIUM"),
    SMALL("SMALL");

    private String size;

    private AsteroidType(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }
}
