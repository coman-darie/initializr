packpackage {{packageName}};

import com.finastra.chassis.openapi.NodesApi
import com.finastra.chassis.openapi.model.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = "/api/example")
class {{applicationName}}Controller implements NodesApi {

{{applicationName}}Service chassisStarterApplicationService = new {{applicationName}}Service();

@Override
public ResponseEntity<Node> getNode(String nodeId) {
String parentId = chassisStarterApplicationService.getParent(nodeId);
return ResponseEntity.ok(new Node().id(nodeId).parentId(parentId));
}
}
