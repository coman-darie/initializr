package {{packageName}};


import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class {{applicationName}}Service {

        Map<String, String> childToParent = ImmutableMap.of(
        "1", "",
        "2", "1",
        "4", "2",
        "5", "2",
        "3", ""

        );

public String getParent(String node) {
        if(!childToParent.keySet().contains(node)){
        return "Non-existing node : " + node;
        }
        if(Strings.isNullOrEmpty(childToParent.get(node))){
        return "No Parent for node : " + node;
        }
        return childToParent.get(node);
        }
}
