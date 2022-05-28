package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ICatalogueMetierImpl implements ICatalogueMetier {

    @Override
    public void AddProduit(Produit p) {
         try {
            Connection connect = SingletonConnection.getConnection();
            PreparedStatement po=connect.prepareStatement("insert into produit (Name,Prix,Quantite)  values (?,?,?)");
            po.setString(1,p.getName());
            po.setDouble(2,p.getPrix());
             po.setInt(3,p.getQuantite());

             po.executeUpdate();
             po.close();
             connect.close();
         }
        catch (Exception o){
            o.printStackTrace();
        }
    }

    @Override
    public List<Produit> ProduitsMC(String mc)  {
        List<Produit>po=new ArrayList<Produit>();
        try {
            Connection connect = SingletonConnection.getConnection();
            PreparedStatement p = connect.prepareStatement("select * from produit where Name like ?");
            p.setString(1, "%"
                    +mc+"%");
            ResultSet r=p.executeQuery();
            while (r.next())
            {
                Produit pr=new Produit(r.getInt("ID_PROD"),r.getString("Name"),r.getDouble("Prix"),r.getInt("Quantite"));
                po.add(pr);
                System.out.println(r.getInt("ID_PROD"));
            }
            p.close();
            connect.close();
        }
       catch (Exception o){
            o.printStackTrace();
       }
        return po;
    }

    @Override
    public List<Produit> AllProduits() {
        List <Produit> po=new ArrayList<Produit>();
        Produit pro=new Produit();
        try {
            Connection connect = SingletonConnection.getConnection();
            PreparedStatement p= connect.prepareStatement("select * from produit");
            ResultSet s= p.executeQuery();
            while (s.next())
            {
                pro.setIdProduit(s.getInt("ID_PROD"));
                pro.setName(s.getString("Name"));
                pro.setPrix(s.getDouble("Prix"));
                pro.setQuantite(s.getInt("Quantite"));
                po.add(pro);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(s.getString("Name"));
            }
            p.close();
            connect.close();
        }
        catch (Exception o){
            o.printStackTrace();
        }
        return po;

    }
}
