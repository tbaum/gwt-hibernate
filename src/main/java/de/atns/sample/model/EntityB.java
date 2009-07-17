package de.atns.sample.model;

import net.sf.gilead.pojo.java5.LightEntity;

import javax.persistence.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tbaum
 * @since 13.07.2009 10:08:17
 */


@Entity
public class EntityB extends LightEntity implements Serializable {
// ------------------------------ FIELDS ------------------------------

    @Id @GeneratedValue(strategy = IDENTITY) private long id;

    @Version private long version;

    private String prop1;
    private BigDecimal prop2;
    private Date prop3;

    @ManyToOne(fetch = LAZY)
    private EntityA a;

// --------------------------- CONSTRUCTORS ---------------------------

    private EntityB() {
    }

    public EntityB(String prop1, BigDecimal prop2, Date prop3, EntityA a) {
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop3 = prop3;
        this.a = a;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    private EntityA getA() {
        return a;
    }

    private void setA(EntityA a) {
        this.a = a;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public BigDecimal getProp2() {
        return prop2;
    }

    public void setProp2(BigDecimal prop2) {
        this.prop2 = prop2;
    }

    public Date getProp3() {
        return prop3;
    }

    public void setProp3(Date prop3) {
        this.prop3 = prop3;
    }

    public long getVersion() {
        return version;
    }

    private void setVersion(long version) {
        this.version = version;
    }

// ------------------------ CANONICAL METHODS ------------------------

    @Override public String toString() {
        return "EntityB{" +
                "id=" + id +
                ", version=" + version +
                ", prop1='" + prop1 + '\'' +
                ", prop2=" + prop2 +
                ", prop3=" + prop3 +
                '}';
    }
}