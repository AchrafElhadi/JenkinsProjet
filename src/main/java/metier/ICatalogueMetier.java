package metier;

import java.sql.SQLException;
import java.util.List;

public interface ICatalogueMetier {
public List<Produit>AllProduits();
public List<Produit>ProduitsMC(String mc) throws SQLException;
public void AddProduit(Produit p);


}
