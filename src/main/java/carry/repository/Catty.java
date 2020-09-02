package carry.repository;

public class Catty {
    Cat cat = null;
    CatPicture catPicture = null;

    public Catty(Cat cat, CatPicture catPicture) {
        this.cat = cat;
        this.catPicture = catPicture;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setCatPicture(CatPicture catPicture) {
        this.catPicture = catPicture;
    }

    public Cat getCat() {
        return cat;
    }

    public CatPicture getCatPicture() {
        return catPicture;
    }
}
