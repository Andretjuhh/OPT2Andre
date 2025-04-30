public class Deelnemer {
    private String naam;
    private String email;

    Deelnemer (String naam, String email) {
        this.naam = naam;
        this.email = email;
    }

    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }
}
