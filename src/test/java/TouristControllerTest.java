

import com.example.turistguidedel2.model.City;
import com.example.turistguidedel2.model.Tag;
import org.springframework.ui.Model;
import com.example.turistguidedel2.controller.TouristController;
import com.example.turistguidedel2.model.TouristAttraction;
import com.example.turistguidedel2.service.TouristService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.AttributedString;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


//@WebMvcTest(TouristControllerTest.class)
//@SpringBootTest(classes = {TouristController.class, TouristService.class})
public class TouristControllerTest {
    @Mock
    private TouristService touristService;

    @Mock
    private Model model;

    @InjectMocks
    private TouristController touristController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAttractions() {
        List<TouristAttraction> attractions = Arrays.asList(new TouristAttraction("", "", 0, new ArrayList<>(), "", LocalDateTime.now(), 10.0, 5.0, 4.0),
                new TouristAttraction("", "", 0, new ArrayList<>(), "", LocalDateTime.now(), 10.0, 5.0, 4.0));
        when(touristService.getAllAttractions()).thenReturn(attractions);

        String viewName = touristController.getAttractions(model);
        verify(model).addAttribute("attractions", attractions);
        assertEquals("attractionList", viewName);

        verify(model).addAttribute("attractions", attractions);
    }

   @Test
    public void testGetAttractionTags() {
        TouristAttraction attraction = new TouristAttraction("", "", 0, new ArrayList<>(), "", LocalDateTime.now(), 10.0, 5.0, 4.0);
        attraction.setAttraction_id(1);
        attraction.setName("Attraction 1");
        attraction.setTagList(Arrays.asList());

        when(touristService.getAttractionById(1)).thenReturn(attraction);
        Model model = mock(Model.class);

        String viewName = touristController.getAttractionTags(model, 1);
        verify(model).addAttribute("attraction", attraction);
        verify(model).addAttribute("tags", attraction.getTagList());

        assertEquals("tags", viewName);
    }

    @Test
    void testAdd() {
        TouristService touristService = mock(TouristService.class);
        List<City> cityList = new ArrayList<>();
        cityList.add(new City(1, "City 1"));
        when(touristService.getCities()).thenReturn(cityList);

        TouristController touristController = new TouristController(touristService);
        Model model = mock(Model.class);

        String viewName = touristController.add(model);

        verify(model).addAttribute(eq("addForm"), any(TouristAttraction.class));
        verify(model).addAttribute(eq("city"), eq(cityList));
        verify(model).addAttribute(eq("tags"), anyList());

        assertEquals("addAttraction", viewName);
    }

    @Test
    void testSave() {
        TouristService touristService = mock(TouristService.class);

        TouristController touristController = new TouristController(touristService);
        Model model = mock(Model.class);

        TouristAttraction touristAttraction = new TouristAttraction("Name", "Description", 10, new ArrayList<>(), "Location", LocalDateTime.now(), 10.0, 5.0, 4.0);
        String viewName = touristController.save(touristAttraction, model);

        verify(touristService).addAttraction(touristAttraction);
        assertEquals("redirect:/attractions", viewName);
    }

    @Test
    void testUpdate() {
        TouristService touristService = mock(TouristService.class);
        TouristController touristController = new TouristController(touristService);

        Model model = mock(Model.class);
        int attractionId = 1;
        TouristAttraction mockAttraction = new TouristAttraction("Name", "Description", 10, new ArrayList<>(), "Location", LocalDateTime.now(), 10.0, 5.0, 4.0);
        when(touristService.getAttractionById(attractionId)).thenReturn(mockAttraction);

        String viewName = touristController.update(attractionId, model);

        verify(touristService).getAttractionById(attractionId);
        verify(model).addAttribute("attraction", mockAttraction);
        verify(model).addAttribute("cities", touristService.getCities());
        assertEquals("updateAttraction", viewName);
    }

    @Test
    void testUpdateAttraction() {
        TouristService touristService = mock(TouristService.class);
        TouristController touristController = new TouristController(touristService);
        TouristAttraction mockAttraction = new TouristAttraction("Name", "Description", 10, new ArrayList<>(), "Location", LocalDateTime.now(), 10.0, 5.0, 4.0);
        String redirectUrl = touristController.updateAttraction(mockAttraction);

        verify(touristService).editAttraction(mockAttraction.getAttraction_id(), mockAttraction);
        assertEquals("redirect:/attractions", redirectUrl);
    }

    @Test
    void testDelete() {
        TouristService touristService = mock(TouristService.class);
        TouristController touristController = new TouristController(touristService);
        String viewName = touristController.delete(1);
        verify(touristService).delete(1);
        assertEquals("redirect:/attractions", viewName);
    }
    }





