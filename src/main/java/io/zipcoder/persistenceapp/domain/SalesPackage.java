package io.zipcoder.persistenceapp.domain;

import java.math.BigDecimal;

/**
 *
 */
public class SalesPackage {

    private String pkgName;
    private BigDecimal price;

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
