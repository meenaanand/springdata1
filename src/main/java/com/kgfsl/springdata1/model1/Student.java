// public Character() {
		
// }

// public Character(Integer id,String name) {
//     super();
//     this.id = id;
//     this.name = name;
// }
package com.kgfsl.springdata1.model1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Student
 */
@Entity

public class Student {
    private Long id;
	private String name;

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Student() {
		super();
	}

	public Student(Long id,String name) {
		super();
		this.id = id;
		this.name = name;
	}

}