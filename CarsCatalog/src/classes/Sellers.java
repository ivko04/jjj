
package classes;


public class Sellers {
  
    private String mail;
    private String password;
    
    
    public Sellers(){
        this.mail = "";
        this.password = "";
    }
    
    
    public Sellers(String mail, String password){
        this.mail = mail;
        this.password = password;
    }
    
    
     public String getSellersMail() {
        return mail;
    }
     
     
     public void setSellersMail(String mail) {
        this.mail = mail;
    }
     
     
     public String getSellersPassword() {
        return password;
    }
     
     
     public void setSellersPassword(String password) {
        this.password = password;
    }
     
   
}
