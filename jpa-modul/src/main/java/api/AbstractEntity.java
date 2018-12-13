package api;

/**
 * Created by er22317 on 13.12.2018.
 */

import java.io.Serializable;

public abstract class AbstractEntity<ID extends Serializable> implements IEntity<ID>, Serializable {
    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getClass().getName())
                .append("{id=")
                .append(getId())
                .append("}")
                .toString();
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return !(getId() != null ? !getId().equals(that.getId()) : that.getId() != null);
    }

}
