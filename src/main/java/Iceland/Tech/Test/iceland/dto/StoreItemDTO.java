package Iceland.Tech.Test.iceland.dto;

import java.util.Objects;

/**
 * StoreItemDTO
 */
public class StoreItemDTO {

  
    public int SellInValue;

    public int QualityValue;


    public StoreItemDTO() {
    }

    public StoreItemDTO(int SellInValue, int QualityValue) {
        this.SellInValue = SellInValue;
        this.QualityValue = QualityValue;
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

    public StoreItemDTO SellInValue(int SellInValue) {
        this.SellInValue = SellInValue;
        return this;
    }

    public StoreItemDTO QualityValue(int QualityValue) {
        this.QualityValue = QualityValue;
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
        return SellInValue == storeItemDTO.SellInValue && QualityValue == storeItemDTO.QualityValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(SellInValue, QualityValue);
    }

    @Override
    public String toString() {
        return "{" +
            " SellInValue='" + getSellInValue() + "'" +
            ", QualityValue='" + getQualityValue() + "'" +
            "}";
    }

}