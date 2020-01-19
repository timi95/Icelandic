package Iceland.Tech.Test.iceland.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
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
    private int SellInValue;

    @Column
    private int QualityValue;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    // @DateTimeFormat(pattern="yyyy.MM.dd")
    private LocalDate date;


    public StoreItem() {
    }


    public StoreItem(Long id, int SellInValue, int QualityValue, LocalDate date) {
        this.id = id;
        this.SellInValue = SellInValue;
        this.QualityValue = QualityValue;
        this.date = date;
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

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public StoreItem date(LocalDate date) {
        this.date = date;
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
        return Objects.equals(id, storeItem.id) && SellInValue == storeItem.SellInValue && QualityValue == storeItem.QualityValue && Objects.equals(date, storeItem.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, SellInValue, QualityValue, date);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", SellInValue='" + getSellInValue() + "'" +
            ", QualityValue='" + getQualityValue() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

    
}