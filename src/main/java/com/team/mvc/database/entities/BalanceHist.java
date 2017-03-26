package com.team.mvc.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "BALANCE_HIST")
public class BalanceHist {

    @Id
    @Column(name = "BALANCE_HIST_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BALANCE_HIST_SEQ")
    @SequenceGenerator(name = "BALANCE_HIST_SEQ", sequenceName = "BALANCE_HIST_SEQ")
    private long balanceHistId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARD_ID", nullable = false)
    private Cards card;


    @Column(name = "CHANGES")
    private BigDecimal changes;


    @Column(name = "DATE_EVENT")
    private Timestamp dateEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BALANCE_ID", nullable = false)
    private CardBalance cardBalance;

    public BalanceHist() {
    }

    public long getBalanceHistId() {
        return balanceHistId;
    }

    public Cards getCard() {
        return card;
    }

    public BigDecimal getChanges() {
        return changes;
    }

    public Timestamp getDateEvent() {
        return dateEvent;
    }

    public CardBalance getCardBalance() {
        return cardBalance;
    }

    public void setBalanceHistId(long balanceHistId) {
        this.balanceHistId = balanceHistId;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public void setChanges(BigDecimal changes) {
        this.changes = changes;
    }

    public void setDateEvent(Timestamp dateEvent) {
        this.dateEvent = dateEvent;
    }

    public void setCardBalance(CardBalance cardBalance) {
        this.cardBalance = cardBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceHist that = (BalanceHist) o;

        if (balanceHistId != that.balanceHistId) return false;
        if (changes != that.changes) return false;
        if (dateEvent != null ? !dateEvent.equals(that.dateEvent) : that.dateEvent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (balanceHistId ^ (balanceHistId >>> 32));
        result = 31 * result + (int) (changes.intValue() ^ (changes.intValue() >>> 32));
        result = 31 * result + (dateEvent != null ? dateEvent.hashCode() : 0);
        return result;
    }
}