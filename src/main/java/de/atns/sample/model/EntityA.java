package de.atns.sample.model;

import net.sf.gilead.pojo.java5.LightEntity;

import static javax.persistence.CascadeType.ALL;
import javax.persistence.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tbaum
 * @since 13.07.2009 10:08:22
 */
@Entity @Table(name = "a")
public class EntityA extends LightEntity implements Serializable {
// ------------------------------ FIELDS ------------------------------

    @Id @GeneratedValue(strategy = IDENTITY) private long id;

    @Version private long version;

    private String prop1;
    private String prop2;

    @OneToMany(cascade = ALL, fetch = LAZY)
    private Set<EntityB> list = new HashSet<EntityB>();

// --------------------------- CONSTRUCTORS ---------------------------

    public EntityA() {
    }

    public EntityA(String prop1, String prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public Set<EntityB> getList() {
        return list;
    }

    private void setList(Set<EntityB> list) {
        this.list = list;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public long getVersion() {
        return version;
    }

    private void setVersion(long version) {
        this.version = version;
    }

// ------------------------ CANONICAL METHODS ------------------------

    @Override public String toString() {
        return "EntityA{" +
                "id=" + id +
                ", version=" + version +
                ", prop1='" + prop1 + '\'' +
                ", prop2='" + prop2 + '\'' +
                ", list=" + list +
                '}';
    }

// -------------------------- OTHER METHODS --------------------------

    public void add(EntityB entityB) {
        list.add(entityB);
    }
}