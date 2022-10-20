package ttw.springbe.transactional.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "table_a")
public class TableA {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "current_value")
    private Integer currentValue;
} 
