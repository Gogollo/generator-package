package eu.programisci.app.<%=packageName%>.converters;

import eu.programisci.app.<%=packageName%>.dto.<%=nameDTO%>;
import eu.programisci.app.<%=packageName%>.ob.<%=nameOB%>;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class <%=name%> {
	
	public List<<%=nameOB%>> DTOListToOBList(List<<%=nameDTO%>> ins) {
        List<<%=nameOB%>> outs = new ArrayList<>();
        if (ins == null) {
            return outs;
        }
        outs.addAll(ins.stream().map(in -> DTOtoOB(in, null)).collect(Collectors.toList()));
        return outs;
    }

    public <%=nameOB%> DTOtoOB(<%=nameDTO%> in, <%=nameOB%> out) {
        if (in == null) {
            return null;
        }
        if (out == null) {
            out = new <%=nameOB%>();
        }
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        return out;
    }

    public List<<%=nameDTO%>> OBListToDTOList(List<<%=nameOB%>> ins) {
        List<<%=nameDTO%>> outs = new ArrayList<>();
        if (ins == null) {
            return outs;
        }
        outs.addAll(ins.stream().map(this::OBToDTO).collect(Collectors.toList()));
        return outs;
    }

    public <%=nameDTO%> OBToDTO(<%=nameOB%> in) {
        if (in == null) {
            return null;
        }
        <%=nameDTO%> out = new <%=nameDTO%>();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        return out;
    }
}