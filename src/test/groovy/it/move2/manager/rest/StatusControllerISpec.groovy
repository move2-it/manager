package it.move2.manager.rest

import it.move2.manager.ManagerApplication
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.hamcrest.Matchers.containsString
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

    def "Should not return other response"() {
        expect:
        mvc.perform(get("/health-check"))
                .andExpect(status().isOk())
                .andExpect(content().string(doesNotContainString("STH")))
    }

    Matcher<String> doesNotContainString(String s) {
        return CoreMatchers.not(containsString(s))
    }


}
