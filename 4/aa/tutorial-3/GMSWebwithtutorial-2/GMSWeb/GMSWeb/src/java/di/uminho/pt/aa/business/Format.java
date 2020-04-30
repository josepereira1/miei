package di.uminho.pt.aa.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Format implements Serializable {
    @Id
    private int kind;
    private String description;

    public Format(){

    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Format{" +
                "kind=" + kind +
                ", description='" + description + '\'' +
                '}';
    }
}
