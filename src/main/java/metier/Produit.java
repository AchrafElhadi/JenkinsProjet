package metier;

public class Produit {
    private int idProduit;
    private String Name;
    private double prix;
    private int quantite;

    public Produit(int idProduit, String name, double prix, int quantite) {
        this.idProduit = idProduit;
        Name = name;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getName() {
        return Name;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit() {
    }
}
