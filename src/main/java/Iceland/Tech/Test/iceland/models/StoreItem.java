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
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * StoreItem
 */
@Entity
@Component
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


    private int QualityCheck(int quality) {
        if(quality > 50){ return 50 ;}
        if(quality < 0) { return 0 ; }
        return quality;
    }

    public int[] updateStoreQuality(String itemName, int SellInValue, int QualityValue, LocalDate date ) {
        // return new{0,1};
        String[] splitSearchString = itemName.split("(\\s|\\s+)");//split by whitespace characters
        String[] itemTypes = {"Aged Brie","Christmas Crackers", "Fresh Item", "Frozen Item", "Soap"};
        boolean bool;
        // searchString.toUpperCase().matches(brie)
        for (String searchString : splitSearchString) {
            for (String type : itemTypes) { //cross check the types with each entered string
                if(type.toLowerCase().contains(searchString.toLowerCase())){
                    // System.out.println("This is the searchString: "+searchString+"\n");
                    switch (type) {
                        case "Aged Brie":
                            // Brie calculation
                            // System.out.println("This is the type: "+type+"");
                            System.out.println("Aged Brie actually increases in quality with age!");
                            System.out.println("sell in "+(SellInValue-1)+" days, quality: "+QualityCheck(QualityValue+1));
                            return new int[]{SellInValue-1, QualityCheck(QualityValue+1)};

                        case "Christmas Crackers":
                            // System.out.println("This is the type: "+type+"");
                            System.out.println("XmasCrackers actually increases in quality with age, but lose value past xmas!");
                            if (null != date ) {
                                date = new LocalDate(2020,12,26);
                                System.out.println("Month ==> : "+date.getMonthOfYear());
                                if (date.getMonthOfYear() == 12 && date.getDayOfMonth() > 25) {
                                    System.out.println("It's after christmas, these crackers are now worthless!");
                                    return new int[]{SellInValue-1, 0};
                                }
                            }
                            if  (SellInValue < 0){
                                return  (SellInValue < 0)?
                                new int[]{SellInValue-1, QualityCheck(QualityValue-2)}:
                                new int[]{SellInValue-1, QualityCheck(QualityValue+2)};
                            }
                            if (SellInValue < 6) {
                                System.out.println("SELL IN LESS THAN 5");
                                System.out.println("sell in "+(SellInValue-1)+" days, quality: "+(QualityValue+3));
                                return new int[]{SellInValue-1, QualityCheck(QualityValue+3)};
                            }
                            else
                            if (SellInValue < 11){
                                System.out.println("SELL IN LESS THAN 10");
                                System.out.println("sell in "+(SellInValue-1)+" days, quality: "+(QualityValue+2));
                                return new int[]{SellInValue-1, QualityCheck(QualityValue+2)};
                            }

                            return  (SellInValue < 0)?
                            new int[]{SellInValue-1, QualityCheck(QualityValue-2)}:
                            new int[]{SellInValue-1, QualityCheck(QualityValue+2)};

                        
                        case "Fresh Item":
                            System.out.println("Fresh item case!");
                            System.out.println("sell in "+(SellInValue-1)+" days, quality: "+(QualityCheck(QualityValue-2) ));
                            return  (SellInValue < 0)?
                            new int[]{SellInValue-1, QualityCheck(QualityValue-4)}:
                            new int[]{SellInValue-1, QualityCheck(QualityValue-2)};


                        case "Frozen Item":
                            System.out.println("Frozen Item case!");
                            System.out.println("sell in "+(SellInValue-1)+" days, quality: "+(QualityCheck(QualityValue-1) ));
                            return  (SellInValue < 0)?
                            new int[]{SellInValue-1, QualityCheck(QualityValue-2)}:
                            new int[]{SellInValue-1, QualityCheck(QualityValue-1)};
                        
                        case "Soap":
                            System.out.println("Soap case!");
                            System.out.println("sell in "+(SellInValue)+" days, quality: "+(QualityCheck(QualityValue) ));

                            return new int[]{SellInValue, QualityCheck(QualityValue)};
                    
                        default:
                            System.out.println("This is the type: "+type+"\n");

                            System.out.println("NO SUCH ITEM!");

                            break;
                    }
                }
            }
            
        }
        System.out.println(
        "sell in "+(SellInValue-1)+
        " days, quality: "+
        ((SellInValue < 0)?
        QualityCheck(QualityValue-2):
        QualityCheck(QualityValue-1) )
        );
        return (SellInValue < 0)?
        new int[]{SellInValue-1, QualityCheck(QualityValue-2)}:
        new int[]{SellInValue-1, QualityCheck(QualityValue-1)};
    }
    
}