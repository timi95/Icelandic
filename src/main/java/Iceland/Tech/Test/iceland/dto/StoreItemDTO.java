package Iceland.Tech.Test.iceland.dto;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * StoreItemDTO
 */
public class StoreItemDTO {

  
    public int sellInValue;

    public int qualityValue;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern="yyyy.MM.dd")
    private LocalDate date;


    public StoreItemDTO() {
    }

    public StoreItemDTO(int sellInValue, int qualityValue, LocalDate date) {
        this.sellInValue = sellInValue;
        this.qualityValue = qualityValue;
        this.date = date;
    }

    public int getSellInValue() {
        return this.sellInValue;
    }

    public void setSellInValue(int sellInValue) {
        this.sellInValue = sellInValue;
    }

    public int getQualityValue() {
        return this.qualityValue;
    }

    public void setQualityValue(int qualityValue) {
        this.qualityValue = qualityValue;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StoreItemDTO sellInValue(int sellInValue) {
        this.sellInValue = sellInValue;
        return this;
    }

    public StoreItemDTO qualityValue(int qualityValue) {
        this.qualityValue = qualityValue;
        return this;
    }

    public StoreItemDTO date(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StoreItemDTO)) {
            return false;
        }
        StoreItemDTO storeItemDTO = (StoreItemDTO) o;
        return sellInValue == storeItemDTO.sellInValue && qualityValue == storeItemDTO.qualityValue && Objects.equals(date, storeItemDTO.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellInValue, qualityValue, date);
    }

    @Override
    public String toString() {
        return "{" +
            " sellInValue='" + getSellInValue() + "'" +
            ", qualityValue='" + getQualityValue() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }


}