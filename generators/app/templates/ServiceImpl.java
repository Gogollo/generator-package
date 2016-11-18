package eu.programisci.app.<%=packageName%>.service.impl;

import eu.programisci.app.<%=packageName%>.converters.<%=nameConv%>;
import eu.programisci.app.<%=packageName%>.dto.<%=nameDTO%>;
import eu.programisci.app.<%=packageName%>.repository.<%=nameRepo%>;
import eu.programisci.app.<%=packageName%>.service.<%=nameServ%>;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class <%=name%> implements <%=nameServ%> {
    
	@Setter(onMethod = @__(@Autowired))
    private <%=nameRepo%> <%=nameRepoFirstLower%>;

    @Setter(onMethod = @__(@Autowired))
    private <%=nameConv%> <%=nameConvFirstLower%>;

    @Override
    public List<<%=nameDTO%>> getAll() {
        return <%=nameConvFirstLower%>.OBListToDTOList(<%=nameRepoFirstLower%>.findAll());
    }

    @Override
    public <%=nameDTO%> getOneById(Long aId) {
        return <%=nameConvFirstLower%>.OBToDTO(<%=nameRepoFirstLower%>.findOne(aId));
    }

    @Override
    public <%=nameDTO%> saveOne(<%=nameDTO%> a<%=nameDTO%>) {
        return <%=nameConvFirstLower%>.OBToDTO(<%=nameRepoFirstLower%>.save(<%=nameConvFirstLower%>.DTOtoOB(a<%=nameDTO%>,null)));
    }

    @Override
    public List<<%=nameDTO%>> saveMultiple(List<<%=nameDTO%>> a<%=nameDTO%>s) {
        return <%=nameConvFirstLower%>.OBListToDTOList(<%=nameRepoFirstLower%>.save(<%=nameConvFirstLower%>.DTOListToOBList(a<%=nameDTO%>s)));
    }
	
}