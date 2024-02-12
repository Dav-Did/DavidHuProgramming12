package com.davidh.module2_1;

import java.util.Objects;

public class Planet {
    private String designation;
    private double massKg;
    private double orbitEarthYears;
    private PlanetType type;

    public Planet(String designation, PlanetType type){
        this.designation = designation;
        this.type = type;
    }

    public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
        this.designation = designation;
        this.massKg = massKg;
        this.orbitEarthYears = orbitEarthYears;
        this.type = type;
    }

    /**
     * Equals function comparing class, designation, massKg, orbitEarthYears, type
     * @param obj The object being compared to
     * @return True or False
     */


    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (obj.getClass() == this.getClass()) {
            Planet p = (Planet) obj;
            if (p.designation != this.designation) {
                return false;
            } else if (p.massKg != this.massKg) {
                return false;
            } else if (p.orbitEarthYears != this.orbitEarthYears) {
                return false;
            } else if (p.type != this.type) {
                p.type = this.type;
                p.orbitEarthYears = this.orbitEarthYears;
                obj = null;
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }



    @Override
    public int hashCode() {
        return Objects.hash(designation, massKg, orbitEarthYears, type);
    } //Generate hash code using a built-in object.hash function.



    @Override
    public String toString() {
        return "com.davidh.module2_1.Planet{" +
                "designation='" + designation + '\'' +
                ", massKg=" + massKg +
                ", orbitEarthYears=" + orbitEarthYears +
                ", type=" + type +
                '}';
    }

}