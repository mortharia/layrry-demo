package layrry.demo.data.provider.service;

import com.querydsl.core.BooleanBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class H2PluginDAOTests {


    DataPluginDAO h2LabelDAO = new DataPluginDAO();

    private static PageRequest defaultPage = PageRequest.of(0, 42);

    @Test
    public void testCountData() {

        String conf = "H2";

        Long result = h2LabelDAO.counts(conf, new BooleanBuilder(), defaultPage);

        assertThat(result).isEqualTo(2);

    }

}
