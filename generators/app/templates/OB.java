package eu.programisci.app.<%=packageName%>.ob;

import eu.programisci.app.base.ob.BaseOB;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "<%=packageName%>")
@SequenceGenerator(allocationSize = 1, name = "SEQUENCE", sequenceName = "gen_<%=packageName%>_id")
@NoArgsConstructor
@Getter
@Setter
public class <%=name%> extends BaseOB {
    @Column(name = "NAZWA")
    private String nazwa;
}