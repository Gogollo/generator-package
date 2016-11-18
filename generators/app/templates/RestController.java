package eu.programisci.app.<%=packageName%>.api;


import eu.programisci.app.<%=packageName%>.dto.<%=nameDTO%>;
import eu.programisci.app.<%=packageName%>.service.<%=nameServ%>;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api" + "/<%=packageName%>")
public class <%=name%> {

    @Setter(onMethod = @__(@Autowired))
    private <%=nameServ%> <%=nameServFirstLower%>;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<<%=nameDTO%>>> getAll() {
        List<<%=nameDTO%>> p<%=nameDTO%>s = <%=nameServFirstLower%>.getAll();
        return new ResponseEntity<>(p<%=nameDTO%>s, HttpStatus.OK);
    }

    @RequestMapping(value = "/getOneById", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<<%=nameDTO%>> getOneById(@RequestParam(name = "id") Long aId) {
        <%=nameDTO%> p<%=nameDTO%> = <%=nameServFirstLower%>.getOneById(aId);
        return new ResponseEntity<>(p<%=nameDTO%>, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveOne", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<<%=nameDTO%>> saveOne(@RequestBody <%=nameDTO%> a<%=nameDTO%>) {
        <%=nameDTO%> pReturn = <%=nameServFirstLower%>.saveOne(a<%=nameDTO%>);
        return new ResponseEntity<>(pReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveMultiple", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity saveMultiple(@RequestBody List<<%=nameDTO%>> a<%=nameDTO%>s) {
        List<<%=nameDTO%>> p<%=nameDTO%>s = <%=nameServFirstLower%>.saveMultiple(a<%=nameDTO%>s);
        return new ResponseEntity<>(p<%=nameDTO%>s, HttpStatus.OK);
    }
	
}