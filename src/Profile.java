public class Profile {
    String nom,prenom,pseudo;

    Profile(String nom,String prenom, String pseudo){
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }
    @Override
    public String toString(){
        return "Nom: "+nom+" Prenom: "+prenom+" Pseudo: "+pseudo;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
