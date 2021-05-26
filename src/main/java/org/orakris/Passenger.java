package org.orakris;

import javax.persistence.*;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;

    @ManyToMany(targetEntity = Train.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "Reservation", joinColumns = { @JoinColumn(name = "pid") },
            inverseJoinColumns = { @JoinColumn(name = "tid") })
    private List<Train> trainList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }
}
