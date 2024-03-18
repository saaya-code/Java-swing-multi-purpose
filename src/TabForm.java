public class TabForm {
    public Formulaire f;
    public Profile p;
    TabForm(String nom, String prenom, String pseudo){
        p = new Profile(nom, prenom, pseudo);
        f = new Formulaire(p);
    }
}
