package Iceland.Tech.Test.iceland.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * StoreItem
 */
@Entity
public class StoreItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    public int SellInValue;

    @Column
    public int QualityValue;

    public StoreItem() {
    }



    public StoreItem(Long id, int SellInValue, int QualityValue) {
        this.id = id;
        this.SellInValue = SellInValue;
        this.QualityValue = QualityValue;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSellInValue() {
        return this.SellInValue;
    }

    public void setSellInValue(int SellInValue) {
        this.SellInValue = SellInValue;
    }

    public int getQualityValue() {
        return this.QualityValue;
    }

    public void setQualityValue(int QualityValue) {
        this.QualityValue = QualityValue;
    }

    public StoreItem id(Long id) {
        this.id = id;
        return this;
    }

    public StoreItem SellInValue(int SellInValue) {
        this.SellInValue = SellInValue;
        return this;
    }

    public StoreItem QualityValue(int QualityValue) {
        this.QualityValue = QualityValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StoreItem)) {
            return false;
        }
        StoreItem storeItem = (StoreItem) o;
        return Objects.equals(id, storeItem.id) && SellInValue == storeItem.SellInValue && QualityValue == storeItem.QualityValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, SellInValue, QualityValue);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", SellInValue='" + getSellInValue() + "'" +
            ", QualityValue='" + getQualityValue() + "'" +
            "}";
    }

    
}