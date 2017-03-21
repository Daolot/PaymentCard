package com.team.mvc.entity;

import javax.persistence.*;

/**
 * Created by vit on 21.03.2017.
 */
@Entity
@Table(name = "BUSES", schema = "CAPTAIN", catalog = "")
public class BusesEntity {
    private short busId;
    private String busNumber;
    private long companyId;

    @Id
    @Column(name = "BUS_ID", nullable = false, precision = 0)
    public short getBusId() {
        return busId;
    }

    public void setBusId(short busId) {
        this.busId = busId;
    }

    @Basic
    @Column(name = "BUS_NUMBER", nullable = false, length = 10)
    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    @Basic
    @Column(name = "COMPANY_ID", nullable = false, precision = 0)
    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusesEntity that = (BusesEntity) o;

        if (busId != that.busId) return false;
        if (companyId != that.companyId) return false;
        if (busNumber != null ? !busNumber.equals(that.busNumber) : that.busNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) busId;
        result = 31 * result + (busNumber != null ? busNumber.hashCode() : 0);
        result = 31 * result + (int) (companyId ^ (companyId >>> 32));
        return result;
    }
}
