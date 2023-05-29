package carscatalog;

import data.ProgInfoDataStore;
import utils.CatalogInterface;

public class CarsCatalog implements CatalogInterface {

    public CarsCatalog(){
    }

    @Override
    public String getAuthorName() {
        return ProgInfoDataStore.authorName;
    }

    @Override
    public String getProgName() {
        return ProgInfoDataStore.progName;
    }

}
