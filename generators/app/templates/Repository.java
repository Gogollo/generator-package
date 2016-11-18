package eu.programisci.app.<%=packageName%>.repository;

import eu.programisci.app.<%=packageName%>.ob.<%=nameOB%>;
import org.springframework.data.jpa.repository.JpaRepository;

public interface <%=name%> extends JpaRepository<<%=nameOB%>, Long> {
	
}