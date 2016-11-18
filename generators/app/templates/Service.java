package eu.programisci.app.<%=packageName%>.service;

import eu.programisci.app.<%=packageName%>.dto.<%=nameDTO%>;
import java.util.List;

public interface <%=name%> {
	
    List<<%=nameDTO%>> getAll();

    <%=nameDTO%> getOneById(Long aId);

    <%=nameDTO%> saveOne(<%=nameDTO%> a<%=nameDTO%>);

    List<<%=nameDTO%>> saveMultiple(List<<%=nameDTO%>> a<%=nameDTO%>s);
	
}