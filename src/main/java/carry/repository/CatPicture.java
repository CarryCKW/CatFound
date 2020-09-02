package carry.repository;

import java.sql.Blob;

public class CatPicture {
    private Long id;
    private Blob blob;

    public Long getId() {
        return id;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }
}
