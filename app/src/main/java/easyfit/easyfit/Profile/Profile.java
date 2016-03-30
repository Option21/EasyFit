package easyfit.easyfit.Profile;

public class Profile {

    private String name;
    private String mail;
    private int age;
    private int poids;
    private float taille;

    private boolean entrainementProgram;

    public Profile(String nom, String email, int age, int poids, float taille){
        this.name = nom;
        this.mail = mail;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
    }

    public Profile(){
        this.name = "";
        this.mail = "";
        this.age = 0;
        this.poids = 0;
        this.taille = 0f;
        entrainementProgram = false;
    }

    public String getName(){
        return this.name;
    }
    public String getMail() {
        return this.mail;
    }
    public int getAge(){
        return this.age;
    }
    public int getPoids(){
        return this.poids;
    }
    public float getTaille(){
        return this.taille;
    }
    public boolean getEntrainementProgram(){
        return this.entrainementProgram;
    }

    public void setName(String nom){
        this.name = nom;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setAge(int num){
        this.age = num;
    }
    public void setPoids(int poids){
        this.poids = poids;
    }
    public void setTaille(float num){
        this.taille = num;
    }
    public void setEntrainementProgram(boolean value){
        this.entrainementProgram= value;
    }

}
