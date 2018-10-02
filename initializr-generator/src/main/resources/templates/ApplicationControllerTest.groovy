package {{packageName}}

import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.mockito.Mockito.when
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class {{applicationName}}ControllerTest {

private MockMvc mockMvc
@InjectMocks
private ChassisStarterApplicationController chassisStarterApplicationController;
@Mock
private ChassisStarterApplicationControllerService chassisStarterApplicationService;

@Before
public void init() {
MockitoAnnotations.initMocks(this);
mockMvc = MockMvcBuilders.standaloneSetup(chassisStarterApplicationController).build();
}

private String BASE_PATH = "/api/example";

@Test
public void getNodeTest() throws Exception{
when(chassisStarterApplicationService.getParent("2")).thenReturn("1");
String expected = "{\"id\":\"2\",\"parentId\":\"1\"}";
mockMvc.perform(get(BASE_PATH + "/nodes/2"))
.andExpect(status().is(200))
.andExpect(content().string(expected));
}
}
