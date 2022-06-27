package it.move2.manager.rest

import it.move2.manager.ManagerApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.hamcrest.Matchers.not
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = ManagerApplication)
class StatusControllerISpec extends Specification {

    MockMvc mvc

    def setup() {
        mvc = MockMvcBuilders.standaloneSetup(new StatusController()).build()
    }

    def "Should return OK"() {
        expect:
        mvc.perform(get("/health-check"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"))
    }

    def "Should fail on given condition"() {
        expect:
        mvc.perform(get("/health-check"))
                .andExpect(condition)

        where:
        condition << [status().is(not(404)), content().string(not("STH"))]
    }

}
