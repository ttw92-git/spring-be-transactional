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
@Table(name = "table_b")
public class TableB {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "current_value")
    private Integer currentValue;
} 
